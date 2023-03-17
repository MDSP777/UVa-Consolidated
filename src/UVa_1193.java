import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UVa_1193 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(true){
			int n = sc.nextInt();
			int r = sc.nextInt();
			if(n==0 && r==0) break;
			ArrayList<Point> points = new ArrayList<>();
			for(int i=0; i<n; i++) points.add(new Point(sc.nextInt(), sc.nextInt()));
			boolean can = true;
			for(int i=0; can && i<n; i++) can&=points.get(i).v<=r;
			if(!can) System.out.println("Case "+c+++": -1");
			else {
				int ctr = 0;
				PriorityQueue<Point> pq = new PriorityQueue<>();
				for(int i=0; i<n; i++)
					pq.add(convert(points.get(i), r));
				while(!pq.isEmpty()){
					Point cur = pq.poll();
					double right = cur.v;
					while(!pq.isEmpty() && pq.peek().u<=right){
						Point p = pq.poll();
						right = Math.min(right, p.v);
					}
					ctr++;
				}
				System.out.println("Case "+c+++": "+ctr);
			}
		}
	}
	
	static Point convert(Point p, int r){
		double b = Math.sqrt(r*r-p.v*p.v);
		return new Point(p.u-b, p.u+b);
	}
	
	static class Point implements Comparable<Point> {
		double u, v;
		
		Point(double a, double b){
			u = a;
			v = b;
		}

		@Override
		public int compareTo(Point o) {
			if(u==o.u) return Double.compare(o.v, v);
			return Double.compare(u, o.u);
		}
	}
}
