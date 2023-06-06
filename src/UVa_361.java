import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UVa_361 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(true) {
			String[] split = br.readLine().split(" ");
			int c = Integer.parseInt(split[0]);
			int r = Integer.parseInt(split[1]);
			int o = Integer.parseInt(split[2]);
			if(c==0 && r==0 && o==0) break;
			
			ArrayList<Point> copPoints = new ArrayList<>();
			HashSet<Point> filter = new HashSet<>();
			while(c-->0) {
				split = br.readLine().split(" ");
				Point cur = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
				copPoints.add(cur);
				filter.add(cur);
			}
			Collections.sort(copPoints);
			boolean copsAllCollinear = true;
			for(int i=2; i<copPoints.size() && copsAllCollinear; i++)
				copsAllCollinear &= collinear(copPoints.get(i-2), copPoints.get(i-1), copPoints.get(i));
			ArrayList<Point> copHull = findHull(filter);
			
			ArrayList<Point > robberPoints = new ArrayList<>();
			filter = new HashSet<>();
			while(r-->0) {
				split = br.readLine().split(" ");
				Point cur = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
				robberPoints.add(cur);
				filter.add(cur);
			}
			Collections.sort(robberPoints);
			boolean robbersAllCollinear = true;
			for(int i=2; i<robberPoints.size() && robbersAllCollinear; i++)
				robbersAllCollinear &= collinear(robberPoints.get(i-2), robberPoints.get(i-1), robberPoints.get(i));
			ArrayList<Point> robberHull = findHull(filter);
			
			sb.append(String.format("Data set %d:\n", tc++));
			while(o-->0) {
				split = br.readLine().split(" ");
				int x = Integer.parseInt(split[0]);
				int y = Integer.parseInt(split[1]);
				Point cur = new Point(x, y);
				
				boolean inCop = copsAllCollinear && copPoints.size()>2 ? within(copPoints.get(0), copPoints.get(copPoints.size()-1), cur) 
																		: contains(copHull, cur);
				boolean inRobber = robbersAllCollinear && robberPoints.size()>2 ? within(robberPoints.get(0), robberPoints.get(robberPoints.size()-1), cur)
																		: contains(robberHull, cur);
				String ans = "neither";
				if(inCop)
					ans = "safe";
				else if(inRobber)
					ans = "robbed";
				
				sb.append(String.format("     Citizen at (%d,%d) is %s.\n", x, y, ans));
			}
			sb.append("\n");
			br.readLine();
		}
		System.out.print(sb);
	}
	
	static boolean within(Point a, Point b, Point p) {
		if(!collinear(a, b, p)) return false;
		
		return a.x<=p.x && p.x<=b.x && a.y<=p.y && p.y<=b.y;
	}
	
	static boolean contains(ArrayList<Point> hull, Point p) {
		if(hull.size()<4) return false;
		
		for(int i=0; i<hull.size()-1; i++)
			if(!ccw(hull.get(i), hull.get(i+1), p) && !collinear(hull.get(i), hull.get(i+1), p))
				return false;
		
		return true;
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
	
	static ArrayList<Point> findHull(HashSet<Point> filter) {
		ArrayList<Point> points = new ArrayList<>();
		for(Point p : filter) 
			points.add(p);
		Collections.sort(points);
		ArrayList<Point> lower = new ArrayList<>();
		for(int i=0; i<points.size(); i++) {
			Point p = points.get(i);
			while(lower.size()>=2 && !ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), p) 
									&& !collinear(lower.get(lower.size()-2), lower.get(lower.size()-1), p))
				lower.remove(lower.size()-1);
			lower.add(p);
		}
		
		ArrayList<Point> upper = new ArrayList<>();
		for(int i=points.size()-1; i>=0; i--) {
			Point p = points.get(i);
			while(upper.size()>=2 && !ccw(upper.get(upper.size()-2), upper.get(upper.size()-1), p)
									&& !collinear(lower.get(lower.size()-2), lower.get(lower.size()-1), p))
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
		
		public String toString() {
			return String.format("(%d,%d)", x, y);
		}
	}
}
