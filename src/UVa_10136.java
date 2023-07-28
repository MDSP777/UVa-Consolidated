import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_10136 {
	static double eps = 1e-9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		br.readLine();
		
		while(tc-->0){
			ArrayList<Point> points = new ArrayList<>();
			while(true){
				String s = br.readLine();
				if(s==null || s.isEmpty()) break;
				
				String[] split = s.split(" ");
				points.add(new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1])));
			}
			
			int best = 1;
			for(int i=0; i<points.size(); i++)
				for(int j=0; j<points.size(); j++){
					Point center = findCenter(points.get(i), points.get(j), 2.5);
					int cur = 0;
					if(center!=null){
						for(Point p : points)
							if(dist(center, p)-2.5 <= eps) cur++;
						best = Math.max(best, cur);
					}
					
					center = findCenter(points.get(j), points.get(i), 2.5);
					cur = 0;
					if(center!=null){
						for(Point p : points)
							if(dist(center, p)-2.5 <= eps) cur++;
						best = Math.max(best, cur);
					}
				}
			sb.append(best).append("\n");
			if(tc>0) sb.append("\n");
		}
		System.out.print(sb);
	}
	
	private static double dist(Point a, Point b) {
		return Math.hypot(a.x-b.x, a.y-b.y);
	}

	static Point findCenter(Point a, Point b, double r) {
		double d2 = (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
		double det = r*r/d2 - 0.25;
		if(det<-eps) return null;
		double h = Math.sqrt(det);
		return new Point((a.x+b.x)/2 + (a.y-b.y)*h, (a.y+b.y)/2 + (b.x-a.x)*h);
	}
	
	static class Point {
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}
	}
}
