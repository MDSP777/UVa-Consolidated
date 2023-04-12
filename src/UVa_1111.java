import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class UVa_1111 {
	static double eps = 1e-9;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			ArrayList<Point> points = new ArrayList<>();
			for(int i=0; i<n; i++) points.add(new Point(sc.nextDouble(), sc.nextDouble()));
			Collections.sort(points);
			ArrayList<Point> hull = findHull(points);

			double shortest = 1000000000;
			
			// attempt to use each hull edge as the wall of the chute
			for(int i=1; i<hull.size(); i++){
				LineSegment ls = new LineSegment(hull.get(i-1), hull.get(i));
				double longest = 0;
				// chute width is farthest point from the edge in terms of point-line distance
				// NOT point-line segment distance
				for(Point p : hull)
					if(!p.equals(ls.p1) && !p.equals(ls.p2))
						longest = Math.max(longest, distToLine(p, ls.p1, ls.p2));
				
				// get min chute width across all edges
				shortest = Math.min(longest, shortest);
			}
			System.out.printf("Case %d: %.2f\n", t++, shortest);
		}
	}
	
	static double distToLine(Point p, Point a, Point b){
		Point ap = toVec(a, p), ab = toVec(a, b);
		double u = dot(ap, ab)/norm_sq(ab);
		Point c = translate(a, scale(ab, u));
		return Math.hypot(p.x-c.x, p.y-c.y);
	}
	
	static Point translate(Point p, Point v){
		return new Point(p.x+v.x, p.y+v.y);
	}
	
	static Point scale(Point p, double s){
		return new Point(p.x*s, p.y*s);
	}
	
	static double dot(Point a, Point b){
		return a.x*b.x + a.y*b.y;
	}
	
	static double norm_sq(Point p){
		return p.x*p.x+p.y*p.y;
	}
	
	static ArrayList<Point> findHull(ArrayList<Point> points){
		ArrayList<Point> lower = new ArrayList<>();
		for(int i=0; i<points.size(); i++){
			Point p = points.get(i);
			while(lower.size()>=2 && !ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), p))
				lower.remove(lower.size()-1);
			lower.add(p);
		}
		ArrayList<Point> upper = new ArrayList<>();
		for(int i=points.size()-1; i>=0; i--){
			Point p = points.get(i);
			while(upper.size()>=2 && !ccw(upper.get(upper.size()-2), upper.get(upper.size()-1), p))
				upper.remove(upper.size()-1);
			upper.add(p);
		}
		for(int i=1; i<upper.size(); i++) lower.add(upper.get(i));
		
		return lower;
	}
	
	static Point toVec(Point a, Point b){
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static double cross(Point a, Point b){
		return a.x*b.y - a.y*b.x;
	}
	
	static boolean ccw(Point a, Point b, Point c){
		return cross(toVec(a, b), toVec(a,c)) > eps;
	}
	
	static class LineSegment{
		Point p1, p2;
		
		public LineSegment(Point a, Point b) {
			p1 = a;
			p2 = b;
		}
	}
	
	static class Point implements Comparable<Point> {
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}

		@Override
		public int compareTo(Point o) {
			if(Math.abs(x-o.x)<eps) return Double.compare(y, o.y);
			return Double.compare(x, o.x);
		}
		
		public boolean equals(Point o) {
			return Math.abs(x-o.x)<eps && Math.abs(y-o.y)<eps;
		}
		
		public String toString() {
			return x+" "+y;
		}
	}
}
