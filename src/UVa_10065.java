import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_10065 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			ArrayList<Point> points = new ArrayList<>();
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split(" ");
				points.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
			}
			points.add(points.get(0));
			double pArea = area(points);
			points.remove(points.size()-1);
			Collections.sort(points);
			
			ArrayList<Point> hull = findHull(points);
			double hArea = area(hull);
			sb.append(String.format("Tile #%d\nWasted Space = %.2f", tc++, 100 - pArea/hArea*100)).append(" %\n\n");
		}
		System.out.print(sb);
	}
	
	static Point toVec(Point a, Point b) {
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static int cross(Point a, Point b) {
		return a.x*b.y - a.y*b.x;
	}
	
	static boolean ccw(Point a, Point b, Point c) {
		return cross(toVec(a, b), toVec(a, c)) > 0;
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
	
	static double area(ArrayList<Point> poly) {
		double area = 0;
		for(int i=1; i<poly.size(); i++)
			area+=cross(poly.get(i-1), poly.get(i));
		return Math.abs(area/2);
	}
	
	static class Point implements Comparable<Point> {
		int x, y;
		
		Point(int a, int b) {
			x = a;
			y = b;
		}

		@Override
		public int compareTo(Point o) {
			if(x==o.x) return y-o.y;
			return x-o.x;
		}
		
		public String toString() {
			return String.format("(%d,%d)", x, y);
		}
	}
}
