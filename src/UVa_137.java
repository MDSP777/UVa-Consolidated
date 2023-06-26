import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UVa_137 {
	static double eps = 1e-9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			String[] split = br.readLine().split("\\s+");
			if(split[0].equals("0")) break;
			ArrayList<Point> p1 = new ArrayList<>();
			for(int i=1; i<split.length; i+=2)
				p1.add(new Point(Integer.parseInt(split[i]), Integer.parseInt(split[i+1])));
			
			split = br.readLine().split("\\s+");
			ArrayList<Point> p2 = new ArrayList<>();
			for(int i=1; i<split.length; i+=2)
				p2.add(new Point(Integer.parseInt(split[i]), Integer.parseInt(split[i+1])));
			Collections.sort(p1);
			Collections.sort(p2);
			p1 = findHull(p1);
			p2 = findHull(p2);
			
			HashSet<Point> inter = new HashSet<>();
			for(Point p : p1)
				if(contains(p2, p)) inter.add(p);
			for(Point p : p2)
				if(contains(p1, p)) inter.add(p);
			
			for(int i=1; i<p1.size(); i++)
				for(int j=1; j<p2.size(); j++)
					if(intersects(p1.get(i-1), p1.get(i) , p2.get(j-1), p2.get(j)))
						inter.add(findIntersection(new Line(p1.get(i-1), p1.get(i)), new Line(p2.get(j-1), p2.get(j))));
					
			ArrayList<Point> points = new ArrayList<>();
			for(Point p : inter) {
				if(Double.isNaN(p.x) || Double.isNaN(p.y) || Double.isInfinite(p.x) || Double.isInfinite(p.y))
					continue;
				points.add(p);
			}
			Collections.sort(points);
			ArrayList<Point> hull = findHull(points);
			
			double ans = area(p1)+area(p2)-2*area(hull);
			sb.append(String.format("%8s", String.format("%.2f", ans)));
		}
		System.out.println(sb);
	}
	
	static Point findIntersection(Line l1, Line l2){
		double x = (l2.b*l1.c - l1.b*l2.c)/(l2.a*l1.b - l1.a*l2.b);
		double y = (Math.abs(l1.b)>eps) ? -(l1.a*x+l1.c) : -(l2.a*x+l2.c);
		return new Point(x, y);
	}
	
	static double area(ArrayList<Point> poly){
		if(poly.size()<4) return 0;
		double a = 0;
		for(int i=1; i<poly.size(); i++)
			a+=cross(poly.get(i-1), poly.get(i));
		return Math.abs(a/2);
	}
	
	static Point toVec(Point a, Point b) {
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static double cross(Point a, Point b) {
		return a.x*b.y - a.y*b.x;
	}
	
	static int orientation(Point a, Point b, Point c){
		double o = cross(toVec(a, b), toVec(a, c));
		if(Math.abs(o)<eps) return 0;
		if(o>eps) return 1;
		return -1;
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
	
	static boolean contains(Point a, Point p, Point b){
		double minX = Math.min(a.x, b.x);
		double maxX = Math.max(a.x, b.x);
		double minY = Math.min(a.y, b.y);
		double maxY = Math.max(a.y, b.y);
		
		return minX<=p.x && p.x<=maxX && minY<=p.y && p.y<=maxY;
	}
	
	static boolean contains(ArrayList<Point> poly, Point p){
		for(int i=1; i<poly.size(); i++)
			if(orientation(poly.get(i-1), poly.get(i), p)!=1)
				return false;
		
		return true;
	}
	
	static boolean intersects(Point a, Point b, Point u, Point v){
		int o1 = orientation(a, b, u);
		int o2 = orientation(a, b, v);
		int o3 = orientation(u, v, a);
		int o4 = orientation(u, v, b);
		
		if(o1!=o2 && o3!=o4) return true;

		if(o1==0 && contains(a, u, b))
			return true;
		if(o2==0 && contains(a, v, b))
			return true;
		if(o3==0 && contains(u, a, v))
			return true;
		if(o4==0 && contains(u, b, v))
			return true;
		
		return false;
	}
	
	static class Point implements Comparable<Point> {
		double x, y;
		
		Point(double a, double b) {
			x = a;
			y = b;
		}
		
		public String toString(){
			return String.format("(%.2f, %.2f)", x, y);
		}

		@Override
		public int compareTo(Point o) {
			if(Math.abs(x-o.x)<eps) return Double.compare(y, o.y);
			return Double.compare(x, o.x);
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
	
	static class Line {
		double a, b, c;
		
		Line(Point p1, Point p2){
			if(p1.x==p2.x){
				a = 1;
				b = 0;
				c = -p1.x;
			} else {
				a = -(p2.y-p1.y)/(p2.x-p1.x);
				b = 1;
				c = -a*p1.x - p1.y;
			}
		}
	}
}
