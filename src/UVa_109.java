import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;


public class UVa_109 {
	static double eps = 1e-9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Polygon> p = new ArrayList<>();
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==-1) break;
			ArrayList<Point> pts = new ArrayList<>();
			for(int i=0; i<n; i++){
				String[] split = br.readLine().split(" ");
				pts.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
			}
			Collections.sort(pts);
			p.add(new Polygon(findHull(pts)));
		}
		double total = 0;
		BitSet bombed = new BitSet();
		while(true){
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			String[] split = s.split(" ");
			Point cur = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
			for(int i=0; i<p.size(); i++)
				if(!bombed.get(i) && p.get(i).contains(cur)){
					total+=p.get(i).area;
					bombed.set(i);
					break;
				}
		}
		System.out.printf("%.2f\n", total);
	}
	
	static ArrayList<Point> findHull(ArrayList<Point> points){
		ArrayList<Point> low = new ArrayList<>(), up = new ArrayList<>();
		int n = points.size();
		for(int i=0; i<n; i++){
			while(low.size()>=2 && !ccw(low.get(low.size()-2), low.get(low.size()-1), points.get(i))) 
				low.remove(low.size()-1);
			low.add(points.get(i));
		}
		for(int i=n-1; i>=0; i--){
			while(up.size()>=2 && !ccw(up.get(up.size()-2), up.get(up.size()-1), points.get(i))) 
				up.remove(up.size()-1);
			up.add(points.get(i));
		}
		for(int i=1; i<up.size()-1; i++) low.add(up.get(i));
		return low;
	}
	
	static double cross(Point a, Point b){
		return a.x*b.y-a.y*b.x;
	}
	
	static boolean ccw(Point a, Point b, Point c){
		return cross(toVec(a, b), toVec(a, c)) > eps;
	}
	
	static boolean collinear(Point a, Point b, Point c){
		return Math.abs(cross(toVec(a, b), toVec(a, c))) < eps;
	}
	
	static Point toVec(Point a, Point b){
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static class Polygon {
		ArrayList<Point> pts;
		int minX, maxX, minY, maxY;
		double area;
		
		Polygon(ArrayList<Point> p){
			pts = p;
			area = 0;
			minX = minY = 10000000;
			maxX = maxY = -10000000;
			for(int i=0; i<pts.size(); i++){
				area+=cross(pts.get(i), pts.get((i+1)%pts.size()));
				minX = Math.min(minX, pts.get(i).x);
				minY = Math.min(minY, pts.get(i).y);
				maxX = Math.max(maxX, pts.get(i).x);
				maxY = Math.max(maxY, pts.get(i).y);
			}
//			for(int i=0; i<pts.size(); i++)
//				System.out.println(pts.get(i).x+" "+pts.get(i).y);
			area/=2;
//			System.out.println("POLYGON AREA = " + area);
		}
		
		boolean contains(Point p){
			if(p.x > maxX || p.y > maxY || p.x < minX || p.y < minY) return false;
			for(int i=0; i<pts.size(); i++)
				if(!ccw(pts.get(i), pts.get((i+1)%pts.size()), p) && 
						!collinear(pts.get(i), pts.get((i+1)%pts.size()), p)) return false;
			return true;
		}
	}
	
	static class Point implements Comparable<Point>{
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
	}
}
