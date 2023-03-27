import java.util.Scanner;

public class UVa_10005 {	
	static double eps = 1e-9;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			Point[] p = new Point[n];
			for(int i=0; i<n; i++) p[i] = new Point(sc.nextInt(), sc.nextInt());
			double r = sc.nextDouble();
			boolean can = false;
			
			for(int i=0; !can && i<n; i++)
				for(int j=i+1; !can && j<n; j++) {
					Point c1 = findCenter(p[i], p[j], r);
					if(c1!=null) {
						boolean yes = true;
						for(Point cur : p) yes &= dist(c1, cur)-r <= eps;
						if(yes) can = true;
					} else {
						Point c2 = findCenter(p[j], p[i], r);
						if(c2!=null) {
							boolean yes = true;
							for(Point cur : p) yes &= dist(c2, cur)-r <= eps;
							if(yes) can = true;
						}
					}
				}
			
			if(can) System.out.println("The polygon can be packed in the circle.");
			else System.out.println("There is no way of packing that polygon.");
		}
	}
	
	private static double dist(Point a, Point b) {
		return Math.hypot(a.x-b.x, a.y-b.y);
	}

	static Point findCenter(Point a, Point b, double r) {
		double d2 = (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
		double det = r*r/d2 - 0.25;
		if(det<-eps) return null;
		double h = Math.sqrt(det);
		return new Point((a.x+b.x)/2 + (a.y-b.y)*h, (a.y+b.y)/2 + (b.x-a.x)*h);
	}
	
	static class Point {
		double x, y;
		
		Point(double d, double e){
			x = d;
			y = e;
		}
		
		public String toString() {
			return "["+x+","+y+"]";
		}
	}
}
