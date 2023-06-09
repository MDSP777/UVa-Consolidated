import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// note for BufferedReader: input lines seem to have multiple spaces between tokens
public class UVa_10060 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			double pVol = 0;
			while(n-->0) {
				String[] split = br.readLine().split("\\s+");
				double t = Double.parseDouble(split[0]);
				ArrayList<Point> poly = new ArrayList<>();
				for(int i=1; i<split.length; i+=2) 
					poly.add(new Point(Double.parseDouble(split[i]),
										Double.parseDouble(split[i+1])));
				pVol+=area(poly)*t;
			}
			String[] split = br.readLine().split("\\s+");
			double r = Double.parseDouble(split[0]);
			double t = Double.parseDouble(split[1]);
			double cVol = Math.PI*r*r*t;
			System.out.println((int)(pVol/cVol));
		}
	}
	
	static double cross(Point a, Point b) {
		return a.x*b.y - a.y*b.x;
	}
	
	static double area(ArrayList<Point> polygon) {
		double area = 0;
		for(int i=1; i<polygon.size(); i++)
			area+=cross(polygon.get(i-1), polygon.get(i));
		return Math.abs(area/2);
	}
	
	static class Point {
		double x, y;
		
		Point(double a, double b) {
			x = a;
			y = b;
		}
	}
}
