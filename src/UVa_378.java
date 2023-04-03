import java.util.Scanner;

public class UVa_378 {
	static double eps = 1e-9;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		System.out.println("INTERSECTING LINES OUTPUT");
		while(tc-->0) {
			Point a = new Point(sc.nextDouble(), sc.nextDouble());
			Point b = new Point(sc.nextDouble(), sc.nextDouble());
			Point c = new Point(sc.nextDouble(), sc.nextDouble());
			Point d = new Point(sc.nextDouble(), sc.nextDouble());
			Line l1 = twoPointsToLine(a, b);
			Line l2 = twoPointsToLine(c, d);
			if(areSame(l1, l2)) System.out.println("LINE");
			else if(areParallel(l1, l2)) System.out.println("NONE");
			else {
				Point p = findIntersection(l1, l2);
				System.out.printf("POINT %.2f %.2f\n", p.x, p.y);
			}
			
		}
		System.out.println("END OF OUTPUT");
	}
	
	static boolean areParallel(Line l1, Line l2) {
		return Math.abs(l1.a-l2.a)<eps && Math.abs(l1.b-l2.b)<eps;
	}
	
	static boolean areSame(Line l1, Line l2) {
		return areParallel(l1, l2) && Math.abs(l1.c-l2.c)<eps;
	}
	
	static Point findIntersection(Line l1, Line l2) {
		double x = (l2.b*l1.c - l1.b*l2.c) / (l2.a*l1.b - l1.a*l2.b);
		double y = (Math.abs(l1.b) > eps) ? -(l1.a*x + l1.c) : -(l2.a*x + l2.c);
		return new Point(x, y);
	}
	
	static Line twoPointsToLine(Point u, Point v) {
		if(Math.abs(u.x-v.x)<eps)
			return new Line(1, 0, -u.x);
		
		double a = -(u.y-v.y)/(u.x-v.x);
		return new Line(a, 1, -(a*u.x)-u.y);
	}
	
	static class Point {
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}
	}
	
	static class Line {
		double a, b, c;
		
		Line(double x, double y, double z){
			a = x;
			b = y;
			c = z;
		}
	}
}
