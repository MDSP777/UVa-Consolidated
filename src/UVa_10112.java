import java.util.Arrays;
import java.util.Scanner;

public class UVa_10112 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			
			Point[] points = new Point[n];
			for(int i=0; i<n; i++)
				points[i] = new Point(sc.next().charAt(0), sc.nextInt(), sc.nextInt());
			Arrays.sort(points);
			Point a = null, b = null, c = null;
			double bestArea = 0;
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++)
					for(int k=j+1; k<n; k++) {
						double area = area(points[i], points[j], points[k]);
						if(area>bestArea) {
							boolean can = true;
							for(int l=0; can && l<n; l++)
								if(!points[l].equals(points[i])
									&& !points[l].equals(points[j])
									&& !points[l].equals(points[k]))
									can &= !contains(points[i], points[j], points[k], points[l]);
							if(can) {
								bestArea = area;
								a = points[i];
								b = points[j];
								c = points[k];
							}
						}
					}
			System.out.printf("%c%c%c\n", a.label, b.label, c.label);
		}
	}
	
	static boolean contains(Point a, Point b, Point c, Point d) {
		double eArea = area(a, b, c);
		double aArea = area(a, b, d)+area(a, c, d)+area(b, c, d);
		return Math.abs(eArea-aArea)<1e-9;
	}
	
	static double area(Point a, Point b, Point c) {
		return 0.5 * Math.abs((c.y-a.y)*(b.x-a.x) - (b.y-a.y)*(c.x-a.x));
	}
	
	static class Point implements Comparable<Point> {
		char label;
		int x, y;
		
		Point(char a, int b, int c) {
			label = a;
			x = b;
			y = c;
		}
		
		public boolean equals(Point o) {
			return x==o.x && y==o.y;
		}

		@Override
		public int compareTo(Point o) {
			return label-o.label;
		}
	}
}
