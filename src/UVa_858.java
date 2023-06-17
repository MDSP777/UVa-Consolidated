import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_858 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Point> points = new ArrayList<>();
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split(" ");
				points.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
			}
			points.add(points.get(0));
			double threshold = Integer.parseInt(br.readLine());
			int flightX = Integer.parseInt(br.readLine());
			
			ArrayList<Point> flight = new ArrayList<>();
			for(int i=1; i<points.size(); i++) {
				Point p = findIntersection(points.get(i-1), points.get(i), flightX);
				
				if(p!=null) flight.add(p);
			}
			Collections.sort(flight);
			double total = 0;
			for(int i=1; i<flight.size(); i+=2)
				total+=flight.get(i).y-flight.get(i-1).y;
			System.out.println(total-threshold > -1e-9 ? "YES" : "NO");
		}
	}
	
	static Point findIntersection(Point a, Point b, int flightX) {
		if(a.x>b.x) {
			Point temp = a;
			a = b;
			b = temp;
		}
		if(flightX<a.x || flightX>b.x) return null;
		
		double rise = b.y-a.y;
		double run = b.x-a.x;
		
		double flightRun = flightX-a.x;
		double percent = flightRun/run;
		
		return new Point(a.x+run*percent, a.y+rise*percent);
	}
	
	static class Point implements Comparable<Point> {
		double x, y;
		
		Point(double a, double b) {
			x = a;
			y = b;
		}

		@Override
		public int compareTo(Point o) {
			return Double.compare(y, o.y);
		}
	}
}
