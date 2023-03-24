import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class UVa_218 {
	static double eps = 1e-9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		boolean first = true;
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			ArrayList<Point> pts = new ArrayList<>();
			for(int i=0; i<n; i++){
				String[] split = br.readLine().split(" ");
				pts.add(new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1])));
			}
			Collections.sort(pts);
			ArrayList<Point> hull = findHull(pts);
			if(!first) System.out.println();
			System.out.println("Region #"+t+++":");
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("(%.1f,%.1f)", hull.get(0).x, hull.get(0).y));
			double per = 0;
			for(int i=hull.size()-1; i>=0; i--){
				sb.append(String.format("-(%.1f,%.1f)", hull.get(i).x, hull.get(i).y));
				per += dist(hull.get(i), hull.get((i+1)%hull.size()));
			}
			System.out.println(sb);
			System.out.printf("Perimeter length = %.2f\n", per);
			first = false;
		}
	}
	
	static double dist(Point a, Point b){
		return Math.hypot(a.x-b.x, a.y-b.y);
	}
	
	static double cross(Point a, Point b){
		return a.x*b.y - a.y*b.x;
	}
	
	static Point toVec(Point a, Point b){
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static boolean ccw(Point a, Point b, Point c){
		return cross(toVec(a, b), toVec(a, c)) > eps;
	}
	
	static boolean collinear(Point a, Point b, Point c){
		return cross(toVec(a, b), toVec(a, c)) < eps;
	}
	
	static ArrayList<Point> findHull(ArrayList<Point> p){
		ArrayList<Point> low = new ArrayList<>(), high = new ArrayList<>();
		for(int i=0; i<p.size(); i++){
			while(low.size()>=2 && !ccw(low.get(low.size()-2), low.get(low.size()-1), p.get(i))) //&& 
					//!collinear(low.get(low.size()-2), low.get(low.size()-1), p.get(i))) 
				low.remove(low.size()-1);
			low.add(p.get(i));
		}
		for(int i=p.size()-1; i>=0; i--){
			while(high.size()>=2 && !ccw(high.get(high.size()-2), high.get(high.size()-1), p.get(i))) //&& 
					//!collinear(high.get(high.size()-2), high.get(high.size()-1), p.get(i))) 
				high.remove(high.size()-1);
			high.add(p.get(i));
		}
		
		for(int i=1; i<high.size()-1; i++) low.add(high.get(i));
//		for(int i=0; i<low.size(); i++)
//			System.out.println(low.get(i).x+", "+low.get(i).y);
		return low;
	}
	
	static class Point implements Comparable<Point> {
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}

		@Override
		public int compareTo(Point o) {
			if(Math.abs(x-o.x)<eps) return Double.compare(y, o.y);
			return Double.compare(x, o.x);
		}
		
		
	}
}
