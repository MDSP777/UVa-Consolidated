import java.util.Scanner;

public class UVa_295 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++){
			int w = sc.nextInt();
			int h = sc.nextInt();
			int n = sc.nextInt();
			Point[] p = new Point[n];
			for(int i=0; i<n; i++){
				p[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			double high = h, low = 0;
			while(Math.abs(high-low)>1e-9){
				double mid = (low+high)/2;
				DisjointSet ds = new DisjointSet(n+2); // [n] = top, [n+1] = bottom
				for(int i=0; i<n; i++){
					for(int j=i+1; j<n; j++)
						if(intersects(p[i], p[j], mid))
							ds.join(i, j);
					if(p[i].y+mid>h) ds.join(i, n);
					if(p[i].y-mid<0) ds.join(i, n+1);
				}
				if(ds.isSameSet(n, n+1)) high = mid;
				else low = mid;
			}
			System.out.printf("Maximum size in test case %d is %.4f.\n", t, high);
		}
	}
	
	static boolean intersects(Point p1, Point p2, double diam){
		int ans = (p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y);
		return ans<diam*diam;
	}
	
	static class Point{
		int x, y;
		
		Point(int a, int b){
			x = a;
			y = b;
		}
	}
	
	static class DisjointSet{
		int[] p;
		int[] rank;
		
		public DisjointSet(int n) {
			p = new int[n];
			rank = new int[n];
			for(int i=0; i<n; i++) p[i] = i;
		}
		
		int findSet(int i){
			return p[i]==i ? i : (p[i] = findSet(p[i]));
		}
		
		boolean isSameSet(int i, int j){
			return findSet(i)==findSet(j);
		}
		
		void join(int i, int j){
			int x = findSet(i);
			int y = findSet(j);
			if(x!=y){
				if(rank[y]>rank[x]){
					p[x] = y;
				} else {
					p[y] = x;
					if(rank[x]==rank[y]) rank[x]++;
				}
			}
		}
	}
}
