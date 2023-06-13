import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_10256 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] split = br.readLine().split("\\s+");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			if(n==0 && m==0) break;
			
			ArrayList<Point> points = new ArrayList<>();
			for(int i=0; i<n; i++) {
				split = br.readLine().split(" ");
				points.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
			}
			Collections.sort(points);
			ArrayList<Point> hull1 = findHull(points);
			
			points = new ArrayList<>();
			for(int i=0; i<m; i++) {
				split = br.readLine().split(" ");
				points.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
			}
			Collections.sort(points);
			ArrayList<Point> hull2 = findHull(points);
			
			boolean has = false;
			for(int i=1; !has && i<hull1.size(); i++)
				for(int j=1; !has && j<hull2.size(); j++)
					has |= intersects(hull1.get(i-1), hull1.get(i), hull2.get(j-1), hull2.get(j));
			
			for(int i=0; !has && i<hull1.size(); i++)
				has |= contains(hull2, hull1.get(i));
			for(int i=0; !has && i<hull2.size(); i++)
				has |= contains(hull1, hull2.get(i));
			
			System.out.println(has ? "No" : "Yes");
		}
	}
	
	static boolean intersects(Point a, Point b, Point u, Point v) {
		int o1 = orientation(a, b, u);
		int o2 = orientation(a, b, v);
		int o3 = orientation(u, v, a);
		int o4 = orientation(u, v, b);
		if(o1!=o2 && o3!=o4)
			return true;
		
		if(o1==0 && contains(a, b, u))
			return true;
		if(o2==0 && contains(a, b, v))
			return true;
		if(o3==0 && contains(u, v, a))
			return true;
		if(o4==0 && contains(u, v, b))
			return true;
		
		return false;
	}
	
	static boolean contains(Point a, Point b, Point p){
		return Math.min(a.x, b.x) <= p.x && p.x <= Math.max(a.x, b.x) && 
				Math.min(a.y, b.y) <= p.y && p.y <= Math.max(a.y, b.y);
	}
	
	static boolean contains(ArrayList<Point> points, Point p) {
		if(points.size()<4) return false;
		
		for(int i=1; i<points.size(); i++)
			if(!ccw(points.get(i-1), points.get(i), p) && !collinear(points.get(i-1), points.get(i), p))
				return false;
		return true;
	}
	
	static int orientation(Point a, Point b, Point c){
		int o = cross(toVec(a, b), toVec(a, c));
		if(o==0) return 0;
		if(o>0) return 1;
		return -1;
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
	
	static boolean collinear(Point a, Point b, Point c) {
		return cross(toVec(a, b), toVec(a, c)) == 0;
	}
	
	static ArrayList<Point> findHull(ArrayList<Point> points) {
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
		
		for(int i=1; i<upper.size(); i++)
			lower.add(upper.get(i));
		
		return lower;
	}
	
	static class Point implements Comparable<Point> {
		int x, y;
		
		Point(int a, int b){
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
