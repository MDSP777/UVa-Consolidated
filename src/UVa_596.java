import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UVa_596 {
	static double eps = 1e-9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] split = br.readLine().split(" ");
		String tc = split[2];
		while(true) {
			ArrayList<Point> points = new ArrayList<>();
			HashSet<Point> cur = new HashSet<>();
			while(true) {
				split = br.readLine().split(" ");
				if(!split[0].equals("P")) break;
				
				for(int i=2; i<split.length; i+=2)
					cur.add(new Point(Double.parseDouble(split[i]), Double.parseDouble(split[i+1])));
			}
			for(Point p : cur) points.add(p);
			Collections.sort(points);
			ArrayList<Point> hull = findHull(points);
			sb.append(String.format("Sample %s convex hull:\n", tc));
			
			int startIdx = 0;
			Point startPoint = hull.get(0);
			for(int i=1; i<hull.size(); i++) {
				Point p = hull.get(i);
				if(p.x>startPoint.x || (Math.abs(p.x-startPoint.x)<eps && p.y<startPoint.y)) {
					startIdx = i;
					startPoint = p;
				}
			}
			
			for(int i=0; i<hull.size(); i++) {
				sb.append(" ").append(hull.get(startIdx));
				
				startIdx++;
				if(startIdx==hull.size()) startIdx = 0;
			}
			sb.append("\n");
			
			if(split[0].equals("S")) tc = split[2];
			else break;
		}
		System.out.print(sb);
	}
	
	static Point toVec(Point a, Point b) {
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static double cross(Point a, Point b) {
		return (a.x*b.y)-(b.x*a.y);
	}
	
	static boolean ccwOrCollinear(Point a, Point b, Point c) {
		return cross(toVec(a, b), toVec(a, c))>eps || Math.abs(cross(toVec(a, b), toVec(a, c)))<eps;
	}
	
	static ArrayList<Point> findHull(ArrayList<Point> points){
		ArrayList<Point> lower = new ArrayList<>();
		for(int i=0; i<points.size(); i++) {
			Point p = points.get(i);
			while(lower.size()>=2 && !ccwOrCollinear(lower.get(lower.size()-2), lower.get(lower.size()-1), p)) 
				lower.remove(lower.size()-1);
			lower.add(p);
		}
		
		ArrayList<Point> upper = new ArrayList<>();
		for(int i=points.size()-1; i>=0; i--) {
			Point p = points.get(i);
			while(upper.size()>=2 && !ccwOrCollinear(upper.get(upper.size()-2), upper.get(upper.size()-1), p)) 
				upper.remove(upper.size()-1);
			upper.add(p);
		}
		
		for(int i=1; i<upper.size()-1; i++)
			lower.add(upper.get(i));
		
		return lower;
	}
	
	static class Point implements Comparable<Point> {
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}
		
		public int compareTo(Point o) {
			if(Math.abs(x-o.x)<eps) return Double.compare(y, o.y);
			return Double.compare(x, o.x);
		}
		
		public String toString() {
			return "("+((int)x)+","+((int)y)+")";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(x);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(y);
			result = prime * result + (int) (temp ^ (temp >>> 32));
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
			if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
				return false;
			if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
				return false;
			return true;
		}
	}
}
