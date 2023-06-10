import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_1206 {
	static double eps = 1e-9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			
			String[] split = s.replaceAll("[()]", "").split("\\s+");
			ArrayList<Point> points = new ArrayList<>();
			for(String str : split) {
				String[] spl = str.split(",");
				points.add(new Point(Double.parseDouble(spl[0]), Double.parseDouble(spl[1]), "("+str+")"));
			}
			Collections.sort(points);
			
			ArrayList<Point> hull = findHull(points);
			sb.append(hull.get(0));
			for(int i=1; i<hull.size(); i++) 
				sb.append(" ").append(hull.get(i));
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static Point toVec(Point a, Point b) {
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static double cross(Point a, Point b) {
		return a.x*b.y - a.y*b.x;
	}
	
	static boolean ccw(Point a, Point b, Point c) {
		return cross(toVec(a, b), toVec(a, c)) > eps;
	}
	
	static ArrayList<Point> findHull(ArrayList<Point> points) {
		ArrayList<Point> lower = new ArrayList<>();
		for(int i=0; i<points.size(); i++) {
			Point p = points.get(i);
			while(lower.size()>=2 && !ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), p))
				lower.remove(lower.size()-1);
			lower.add(p);
		}
		
		ArrayList<Point> upper = new ArrayList<>();
		for(int i=points.size()-1; i>=0; i--) {
			Point p = points.get(i);
			while(upper.size()>=2 && !ccw(upper.get(upper.size()-2), upper.get(upper.size()-1), p))
				upper.remove(upper.size()-1);
			upper.add(p);
		}
		
		for(int i=1; i<upper.size(); i++)
			lower.add(upper.get(i));
		
		return lower;
	}
	
	static class Point implements Comparable<Point> {
		double x, y;
		String o;
		
		Point(double a, double b) {
			x = a;
			y = b;
			o = toString();
		}
		
		Point(double a, double b, String c) {
			x = a;
			y = b;
			o = c;
		}

		@Override
		public int compareTo(Point o) {
			if(Math.abs(x-o.x)<eps) return Double.compare(y, o.y);
			return Double.compare(x, o.x);
		}
		
		public String toString() {
			return o;
		}
	}
}
