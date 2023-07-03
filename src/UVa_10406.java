import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_10406 {
	static double eps = 1e-9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] split = br.readLine().split(" ");
			double d = Double.parseDouble(split[0]);
			int n = Integer.parseInt(split[1]);
			if(n==0) break;
			ArrayList<Point> poly = new ArrayList<>();
			for(int i=2; i<split.length; i+=2)
				poly.add(new Point(Double.parseDouble(split[i]), Double.parseDouble(split[i+1])));
			poly.add(poly.get(0));
			
			double area = area(poly);
			double perimeter = perimeter(poly);
			
			poly.add(poly.get(1));
			for(int i=2; i<poly.size(); i++){
				Point a = poly.get(i-2);
				Point b = poly.get(i-1);
				Point c = poly.get(i);
				double theta = angle(a, b, c)/2;
				double w = d/Math.tan(theta);
				perimeter-=w*2;
				area-=d*w;
			}
			
			System.out.printf("%.3f\n", area-perimeter*d);
		}
	}
	
	static double dot(Point a, Point b){
		return a.x*b.x + a.y*b.y;
	}
	
	static double cross(Point a, Point b){
		return a.x*b.y - a.y*b.x;
	}
	
	static double angle(Point a, Point o, Point b){
		Point oa = toVec(o, a), ob = toVec(o, b);
		return Math.acos(dot(oa, ob)*1.0/Math.sqrt(dot(oa, oa)*dot(ob, ob)));
	}
	
	static double dist(Point a, Point b){
		double x = a.x-b.x;
		double y = a.y-b.y;
		return Math.sqrt(x*x+y*y);
	}
	
	static Point toVec(Point a, Point b){
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static double area(ArrayList<Point> poly){
		if(poly.size()<4) return 0;
		double a = 0;
		for(int i=0; i<poly.size()-1; i++)
			a+=cross(poly.get(i), poly.get(i+1));
		return Math.abs(a/2);
	}
	
	static double perimeter(ArrayList<Point> poly){
		double p = 0;
		for(int i=1; i<poly.size(); i++) p+=dist(poly.get(i-1), poly.get(i));
		return p;
	}
	
	static class Point {
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}
	}
}
