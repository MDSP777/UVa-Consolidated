import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_478 {
	static double eps = 1e-6;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Polygon> polygons = new ArrayList<>();
		while(true) {
			String[] split = br.readLine().split(" ");
			if(split[0].equals("*")) break;
			
			if(split[0].equals("c")) {
				polygons.add(new Circle(
									new Point(Double.parseDouble(split[1]), Double.parseDouble(split[2])), 
									Double.parseDouble(split[3])));
			} else if(split[0].equals("r")) {
				polygons.add(new Rectangle(
									new Point(Double.parseDouble(split[1]), Double.parseDouble(split[2])), 
									new Point(Double.parseDouble(split[3]), Double.parseDouble(split[4]))));
			} else {
				polygons.add(new Triangle(
						new Point(Double.parseDouble(split[1]), Double.parseDouble(split[2])), 
						new Point(Double.parseDouble(split[3]), Double.parseDouble(split[4])), 
						new Point(Double.parseDouble(split[5]), Double.parseDouble(split[6]))));
			}
		}
		
		int ctr = 1;
		while(true) {
			String[] split = br.readLine().split(" ");
			if(split[0].equals("9999.9") && split[1].equals("9999.9")) break;
			
			Point p = new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
			boolean contained = false;
			for(int i=0; i<polygons.size(); i++)
				if(polygons.get(i).contains(p)){
					sb.append(String.format("Point %d is contained in figure %d\n", ctr, i+1));					
					contained = true;
				}
			if(!contained)
				sb.append(String.format("Point %d is not contained in any figure\n", ctr));
			ctr++;
		}
		System.out.print(sb);
	}
	
	static double area(double a, double b, double c) {
		double s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	
	static double dist(Point a, Point b) {
		double x =a.x-b.x;
		double y = a.y-b.y;
		return Math.sqrt(x*x+y*y);
	}
	
	static Point toVec(Point a, Point b) {
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static double cross(Point a, Point b) {
		return a.x*b.y - a.y*b.x;
	}
	
	static boolean collinear(Point a, Point b, Point c) {
		return Math.abs(cross(toVec(a, b), toVec(a, c)))<eps;
	}
	
	static interface Polygon {
		boolean contains(Point p);
	}
	
	static class Circle implements Polygon {
		Point center;
		double r;
		
		Circle(Point a, double b) {
			center = a;
			r = b;
		}

		@Override
		public boolean contains(Point p) {
			return dist(center, p)<r;
		}
	}
	
	static class Rectangle implements Polygon {
		Point ul, br;
		
		Rectangle(Point a, Point b) {
			ul = a;
			br = b;
		}

		@Override
		public boolean contains(Point p) {
			return ul.x<p.x && p.x<br.x && br.y<p.y && p.y<ul.y;
		}
	}
	
	
	static class Triangle implements Polygon {
		Point a, b, c;
		double area;
		
		Triangle(Point x, Point y, Point z) {
			a = x;
			b = y;
			c = z;
			area = area(dist(a, b), dist(b, c), dist(a, c));
		}

		@Override
		public boolean contains(Point p) {
			if(collinear(a, b, p) || collinear(a, c, p) || collinear(b, c, p))
				return false;
			
			double a1 = area(dist(a, b), dist(p, a), dist(p, b));
			double a2 = area(dist(a, c), dist(p, a), dist(p, c));
			double a3 = area(dist(b, c), dist(p, b), dist(p, c));
			
			return Math.abs(a1+a2+a3-area)<eps;
		}
	}
	
	static class Point {
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}
	}
}
