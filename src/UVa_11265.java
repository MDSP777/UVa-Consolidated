import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_11265 {
	static double eps = 1e-9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split(" ");
			int n = Integer.parseInt(split[0]);
			int w = Integer.parseInt(split[1]);
			int h = Integer.parseInt(split[2]);
			Point fountain = new Point(Double.parseDouble(split[3]), Double.parseDouble(split[4]));
			
			ArrayList<Point> p = new ArrayList<>();
			p.add(new Point(0, 0));
			p.add(new Point(w, 0));
			p.add(new Point(w, h));
			p.add(new Point(0, h));
			p.add(new Point(0, 0));
			Polygon poly = new Polygon(p);
			
			for(int i=0; i<n; i++) {
				split = br.readLine().split(" ");
				Point a = new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
				Point b = new Point(Double.parseDouble(split[2]), Double.parseDouble(split[3]));
				
				Polygon q = poly.cut(a, b);
				if(q.points.size()>2 && q.contains(fountain))
					poly = q;
			}
			
			sb.append(String.format("Case #%d: %.3f\n", tc++, poly.area()));
		}
		System.out.print(sb);
	}
	
	static boolean ccw(Point a, Point b, Point c) {
		return cross(toVec(a, b), toVec(a, c)) > -eps;
	}
	
	static Point lineIntersectSeg(Point p, Point q, Point A, Point B) {
		double a = B.y - A.y;
		double b = A.x - B.x;
		double c = B.x * A.y - A.x * B.y;
		double u = Math.abs(a * p.x + b * p.y + c);
		double v = Math.abs(a * q.x + b * q.y + c);
		return new Point((p.x * v + q.x * u) / (u+v), (p.y * v + q.y * u) / (u+v)); 
	}
	
	static Point toVec(Point a, Point b) {
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static double cross(Point a, Point b) {
		return a.x*b.y - a.y*b.x;
	}
	
	static class Polygon {
		ArrayList<Point> points;
		
		Polygon(ArrayList<Point> p){
			points = p;
		}
		
		// cuts this polygon into two, this will store right side, left side is returned as new Polygon
		Polygon cut(Point a, Point b) {
			ArrayList<Point> left = new ArrayList<>();
			ArrayList<Point> right = new ArrayList<>();
			for(int i=0; i<points.size(); i++) {
				double left1 = cross(toVec(a, b), toVec(a, points.get(i))), left2 = 0;
				
				if (i != points.size()-1) 
					left2 = cross(toVec(a, b), toVec(a, points.get(i+1)));
				if (left1 >= -eps) // points[i] is on the left of ab
					left.add(points.get(i)); 
				if(left1 <= eps) // points[i] is on the right of ab
					right.add(points.get(i));
				if (left1 * left2 < -eps) { // edge (points[i], points[i+1]) crosses line ab
					Point inter = lineIntersectSeg(points.get(i), points.get(i+1), a, b);
					left.add(inter);
					right.add(inter);
				}
			}
			if (!left.isEmpty() && !(left.get(left.size()-1).equals(left.get(0))))
				left.add(left.get(0));
			if (!right.isEmpty() && !(right.get(right.size()-1).equals(right.get(0))))
				right.add(right.get(0));
			this.points = right;
			return new Polygon(left);
		}
		
		boolean contains(Point p) {
			for(int i=1; i<points.size(); i++)
				if(!ccw(points.get(i-1), points.get(i), p))
					return false;
			return true;
		}
		
		double area() {
			double area = 0;
			for(int i=1; i<points.size(); i++)
				area+=cross(points.get(i-1), points.get(i));
			return area/2;
		}
	}
	
	static class Point {
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
				return false;
			if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
				return false;
			return true;
		}
	
		public String toString() {
			return String.format("(%.2f, %.2f)", x, y);
		}
	}
}
