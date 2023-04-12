import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class UVa_460 {
	static double eps = 1e-9;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			Rectangle rect1 = new Rectangle(new Point(sc.nextInt(), sc.nextInt()),new Point(sc.nextInt(), sc.nextInt()));
			Rectangle rect2 = new Rectangle(new Point(sc.nextInt(), sc.nextInt()),new Point(sc.nextInt(), sc.nextInt()));
			HashSet<Point> inter = new HashSet<>();
			for(Point p : rect1.points)
				if(rect2.contains(p)) inter.add(p);
			for(Point p : rect2.points)
				if(rect1.contains(p)) inter.add(p);
			
			for(LineSegment ls1 : rect1.sides)
				for(LineSegment ls2: rect2.sides)
					if(!areParallel(ls1.line, ls2.line)){
						Point p = findIntersection(ls1.line, ls2.line);
						if(ls1.contains(p) && ls2.contains(p)) inter.add(p);
					}
			
			if(inter.size()!=4) System.out.println("No Overlap");
			else {
				ArrayList<Point> ans = new ArrayList<>();
				for(Point p : inter) ans.add(p);
				Collections.sort(ans);
				Point ll = ans.get(0);
				Point ur = ans.get(3);
				System.out.println(ll.x+" "+ll.y+" "+ur.x+" "+ur.y);
			}
			if(tc>0) System.out.println();
		}
	}
	
	static boolean areParallel(Line l1, Line l2) {
		return Math.abs(l1.a-l2.a)<eps && Math.abs(l1.b-l2.b)<eps;
	}
	
	static Point findIntersection(Line l1, Line l2) {
		double x = (l2.b*l1.c - l1.b*l2.c) / (l2.a*l1.b - l1.a*l2.b);
		double y = (Math.abs(l1.b) > eps) ? -(l1.a*x + l1.c) : -(l2.a*x + l2.c);
		return new Point(x, y);
	}
	
	static Line twoPointsToLine(Point u, Point v) {
		if(Math.abs(u.x-v.x)<eps)
			return new Line(1, 0, -u.x);
		
		double a = -(u.y-v.y)/(u.x-v.x);
		return new Line(a, 1, -(a*u.x)-u.y);
	}
	
	static class LineSegment {
		Point p1, p2;
		Line line;
		
		LineSegment(Point a, Point b){
			p1 = a;
			p2 = b;
			line = twoPointsToLine(p1, p2);
		}

		boolean contains(Point p) {
			return p1.x <= p.x && p.x <= p2.x && p1.y <= p.y && p.y <= p2.y;
		}
	}
	
	static class Line {
		double a, b, c;
		
		Line(double x, double y, double z){
			a = x;
			b = y;
			c = z;
		}
	}
	
	static class Rectangle {
		Point ll, ul, lr, ur;
		LineSegment u, l, r, d;
		Point[] points;
		LineSegment[] sides;
		
		Rectangle(Point a, Point b){
			points = new Point[4];
			points[0] = ll = a;
			points[1] = ur = b;
			points[2] = ul = new Point(ll.x, ur.y);
			points[3] = lr = new Point(ur.x, ll.y);
			sides = new LineSegment[4];
			sides[0] = u = new LineSegment(ul, ur);
			sides[1] = l = new LineSegment(ll, ul);
			sides[2] = r = new LineSegment(lr, ur);
			sides[3] = d = new LineSegment(ll, lr);
		}
		
		boolean contains(Point p){
			return ll.x < p.x && p.x < ur.x && ll.y < p.y && p.y < ur.y; 
		}
	}
	
	static class Point implements Comparable<Point> {
		int x, y;
		
		Point(int a, int b){
			x = a;
			y = b;
		}
		
		Point(double a, double b){
			x = (int)a;
			y = (int)b;
		}

		@Override
		public int compareTo(Point o) {
			if(x==o.x) return y-o.y;
			return x-o.x;
		}
		
		public String toString(){
			return x+" "+y;
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
	}
}
