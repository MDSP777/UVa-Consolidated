import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UVa_11096 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			String[] split = br.readLine().split(" ");
			double t = Double.parseDouble(split[0]);
			int n = Integer.parseInt(split[1]);
			ArrayList<Point> points = new ArrayList<>();
			HashSet<Point> h = new HashSet<>();
			for(int i=0; i<n; i++) {
				split = br.readLine().split(" ");
				h.add(new Point(Long.parseLong(split[0]), Long.parseLong(split[1])));
			}
			for(Point p : h) points.add(p);
			Collections.sort(points);
			ArrayList<Point> hull = findHull(points);
			double len = 0;
			for(int i=1; i<hull.size(); i++) {
				len+=dist(hull.get(i-1), hull.get(i));
			}
			br.readLine();
			System.out.printf("%.5f\n", Math.max(len, t));
		}
	}
	
	static double dist(Point a, Point b) {
		double x = a.x-b.x;
		double y = a.y-b.y;
		return Math.sqrt(x*x+y*y);
	}
	
	static Point toVec(Point a, Point b) {
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static long cross(Point a, Point b) {
		return a.x*b.y - a.y*b.x;
	}
	
	static boolean ccw(Point a, Point b, Point c) {
		return cross(toVec(a, b), toVec(a, c))>0;
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
		long x, y;
		
		Point(long a, long b) {
			x = a;
			y = b;
		}

		@Override
		public int compareTo(Point o) {
			if(x==o.x) return Long.compare(y, o.y);
			return Long.compare(x, o.x);
		}
		
		public String toString() {
			return "("+x+","+y+")";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (x ^ (x >>> 32));
			result = prime * result + (int) (y ^ (y >>> 32));
			return result;
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
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}
