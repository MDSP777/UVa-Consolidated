import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_634 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			ArrayList<Point> polygon = new ArrayList<>();
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split(" ");
				polygon.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
			}
			polygon.add(polygon.get(0));
			String[] split = br.readLine().split(" ");
			Point p = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
			System.out.println(inPolygon(polygon, p) ? "T" : "F");
		}
	}
	
	static Point toVec(Point a, Point b) {
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static long cross(Point a, Point b) {
		return a.x*b.y - a.y*b.x;
	}
	
	static boolean ccw(Point a, Point b, Point c) {
		return cross(toVec(a, b), toVec(a, c))>0;
	}
	
	static boolean collinear(Point a, Point b, Point c) {
		return cross(toVec(a, b), toVec(a, c)) == 0;
	}
	
	static long dot(Point a, Point b) {
		return a.x*b.x + a.y*b.y;
	}
	
	static double angle(Point a, Point o, Point b){
		Point oa = toVec(o, a), ob = toVec(o, b);
		return Math.acos(dot(oa, ob)*1.0/Math.sqrt(dot(oa, oa)*dot(ob, ob)));
	}
	
	static boolean inPolygon(ArrayList<Point> polygon, Point p) {
		if(polygon.size()<4) return false;
		
		double sum = 0;
		for(int i=0; i<polygon.size()-1; i++){
			if((p.x==polygon.get(i).x && p.y==polygon.get(i).y) ||
					collinear(polygon.get(i), p, polygon.get(i+1)))
				return false;
			if(ccw(p, polygon.get(i), polygon.get(i+1)))
				sum+=angle(polygon.get(i), p, polygon.get(i+1));
			else sum-=angle(polygon.get(i), p, polygon.get(i+1));
		}
		return Math.abs(Math.abs(sum)-2*Math.PI)<1e-9;
	}
	
	static class Point {
		long x, y;
		
		Point(long l, long m){
			x = l;
			y = m;
		}
	}
}
