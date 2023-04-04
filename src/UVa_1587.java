import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class UVa_1587 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			ArrayList<Point> arr = new ArrayList<>();
			for(int i=0; i<6; i++) arr.add(new Point(sc.nextInt(), sc.nextInt()));
			Collections.sort(arr);
			if(!(arr.get(0).equals(arr.get(1)) && arr.get(2).equals(arr.get(3)) && arr.get(4).equals(arr.get(5)))){
				System.out.println("IMPOSSIBLE");
			} else {
				Point p1 = arr.get(0);
				Point p2 = arr.get(2);
				Point p3 = arr.get(4);
				if(p1.x==p2.x && ((p1.y==p3.x && p2.y==p3.y) || (p2.y==p3.x && p1.y==p3.y)))
					System.out.println("POSSIBLE");
				else System.out.println("IMPOSSIBLE");
			}
		}while(sc.hasNext());
	}
	
	static class Point implements Comparable<Point>{
		int x, y;
		
		Point(int a, int b){
			x = Math.min(a, b);
			y = Math.max(a, b);
		}

		@Override
		public int compareTo(Point o) {
			if(x==o.x) return y-o.y;
			return x-o.x;
		}
		
		public boolean equals(Point o) {
			return x==o.x && y==o.y;
		}
	}
}
