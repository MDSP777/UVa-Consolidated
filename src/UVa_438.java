import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_438 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			String[] split = s.split(" ");
			
			double r = circumcircle(new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1])),
									new Point(Double.parseDouble(split[2]), Double.parseDouble(split[3])),
									new Point(Double.parseDouble(split[4]), Double.parseDouble(split[5])));
			System.out.printf("%.2f\n", Math.PI*2*r);
		}
	}
	
	// area of a triangle with side lengths a, b, c
	// Heron's Formula
	static double area(double a, double b, double c) {
		double s = (a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	
	// returns radius of circumcircle of triangle with side lengths a, b, c
	static double circumcircle(double a, double b, double c) {
		return a*b*c/(4*area(a, b, c));
	}
	
	// wrapper function, converts points/triangle vertices to side lengths
	static double circumcircle(Point a, Point b, Point c) {
		return circumcircle(dist(a, b), dist(b, c), dist(a, c));
	}
	
	static double dist(Point a, Point b) {
		return Math.hypot(a.x-b.x, a.y-b.y);
	}
	
	static class Point{
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}
	}
}
