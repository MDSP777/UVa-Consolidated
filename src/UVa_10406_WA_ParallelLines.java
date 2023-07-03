import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// not sure why this doesn't work, passes all TCs I've tried
// idea: 1. per polygon edge, find the 2 lines parallel to it with perpendicular distance d
//		 2. for every pair of adjacent edges, find the intersections of their parallel lines
//		 3. there will be a total of 4 intersections, but only store the one that falls inside the polygon
//		 4. find the area of the polygon created by the intersections
public class UVa_10406_WA_ParallelLines {
	static double eps = 1e-9;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while(true){
			double d = sc.nextDouble();
			int n = sc.nextInt();
			if(n==0) break;
			ArrayList<Point> poly = new ArrayList<>();
			for(int i=0; i<n; i++)
				poly.add(new Point(sc.nextDouble(), sc.nextDouble()));
			
			poly.add(poly.get(0));
			poly.add(poly.get(1));
			ArrayList<Point> cut = new ArrayList<>();
			Line[] pl1 = findParallelLines(toLine(poly.get(0), poly.get(1)), d);
//			System.out.println(pl1[0]);
//			System.out.println(pl1[1]);
			for(int i=2; i<poly.size(); i++){
				Line[] pl2 = findParallelLines(toLine(poly.get(i-1), poly.get(i)), d);
//				System.out.println(pl2[0]);
//				System.out.println(pl2[1]);
				
				for(int j=0; j<2; j++)
					for(int k=0; k<2; k++){
						Point p = findIntersection(pl1[j], pl2[k]);
						if(contains(poly, p))
							cut.add(p);
					}
				
				pl1 = pl2;
			}
//			cut.add(cut.get(0)); // this causes RTE for some reason
			Collections.sort(cut);
			cut = findHull(cut);
			System.out.printf("%.3f\n", area(cut));
		}
	}
	
	static Line[] findParallelLines(Line l, double d){
		Line[] lines = new Line[2];
		if(l.isVertical()){
			lines[0] = new Line(l.a, l.b, l.c+d);
			lines[1] = new Line(l.a, l.b, l.c-d);
			return lines;
		}
		double m = l.slope();
		double b = -l.c;
		
		double delta = d/Math.cos(Math.atan(m));
		lines[0] = fromSI(m, b+delta);
		lines[1] = fromSI(m, b-delta);
		
		return lines;
	}
	
	static Point findIntersection(Line l1, Line l2){
		double x = (l2.b*l1.c - l1.b*l2.c)/(l2.a*l1.b - l1.a*l2.b);
		double y = (Math.abs(l1.b)>eps) ? -(l1.a*x+l1.c) : -(l2.a*x+l2.c);
		return new Point(x, y);
	}
	
	static Line fromSI(double m, double b){
		return new Line(-m, 1, -b);
	}
	
	static boolean equal(double a, double b){
		return Math.abs(a-b)<eps;
	}
	
	static Line toLine(Point p1, Point p2){
		if(equal(p1.x, p2.x)){
			return new Line(1, 0, -p1.x);
		}
		double m = (p2.y-p1.y)/(p2.x-p1.x);
		return new Line(-m, 1, -(p1.y-m*p1.x));
	}
	
	static Point toVec(Point a, Point b){
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static double cross(Point a, Point b){
		return a.x*b.y - a.y*b.x;
	}
	
	static int orientation(Point a, Point b, Point c){
		double o = cross(toVec(a, b), toVec(a, c));
		if(o>eps) return 1; // ccw
		if(Math.abs(o)<eps) return 0; // collinear
		return -1; // cw
	}
	
	static double area(ArrayList<Point> poly){
		if(poly.size()<4) return 0;
		double a = 0;
		for(int i=0; i<poly.size()-1; i++)
			a+=cross(poly.get(i), poly.get(i+1));
		return Math.abs(a/2);
	}
	
	static boolean contains(ArrayList<Point> poly, Point p){
		for(int i=1; i<poly.size(); i++)
			if(orientation(poly.get(i-1), poly.get(i), p)!=-1) return false;
		return true;
	}
	
	static ArrayList<Point> findHull(ArrayList<Point> points) {
		ArrayList<Point> lower = new ArrayList<>();
		for(int i=0; i<points.size(); i++){
			Point p = points.get(i);
			while(lower.size()>=2 && orientation(lower.get(lower.size()-2), lower.get(lower.size()-1), p)<1)
				lower.remove(lower.size()-1);
			lower.add(p);
		}
		
		ArrayList<Point> upper = new ArrayList<>();
		for(int i=points.size()-1; i>=0; i--){
			Point p = points.get(i);
			while(upper.size()>=2 && orientation(upper.get(upper.size()-2), upper.get(upper.size()-1), p)<1)
				upper.remove(upper.size()-1);
			upper.add(p);
		}
		
		for(int i=1; i<upper.size(); i++)
			lower.add(upper.get(i));
		
		return lower;
	}
	
	static class Point implements Comparable<Point> {
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}
		
		public String toString(){
			return String.format("(%.2f, %.2f)", x, y);
		}

		@Override
		public int compareTo(Point o) {
			if(equal(x, o.x)) return Double.compare(y, o.y);
			return Double.compare(x, o.x);
		}
	}
	
	static class Line {
		double a, b, c;
		
		Line(double x, double y, double z){
			a = x;
			b = y;
			c = z;
		}
		
		boolean isVertical(){
			return equal(b, 0);
		}
		
		double slope() {
			return -a;
		}
		
		public String toString(){
			return String.format("%.2fx + %.2fy + %.2f = 0", a, b, c);
		}
	}
}
