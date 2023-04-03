import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class UVa_10652 {
	static double eps = 1e-9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			int n = Integer.parseInt(br.readLine());
			double rectArea = 0;
			
			ArrayList<Point> p = new ArrayList<>();
			while(n-->0){
				String[] split = br.readLine().split(" ");
				double x = Double.parseDouble(split[0]);
				double y = Double.parseDouble(split[1]);
				double w = Double.parseDouble(split[2]);
				double h = Double.parseDouble(split[3]);
				double theta = 360-Double.parseDouble(split[4]); // convert cw angle to ccw
				if(theta>360) theta-=360;
				rectArea+=w*h;
				
				// translate center to 0,0 (and rectangle corners accordingly)
				// rotate each corner by theta using rotation matrix
				// then return point to original orientation by adding back x and y
				theta = toRad(theta);
				p.add(rotate(new Point(-w/2, h/2), theta).add(x, y));
				p.add(rotate(new Point(w/2, h/2), theta).add(x, y));
				p.add(rotate(new Point(-w/2, -h/2), theta).add(x, y));
				p.add(rotate(new Point(w/2, -h/2), theta).add(x, y));
			}
			Collections.sort(p);
			
			ArrayList<Point> hull = findHull(p);
			double hullArea = 0;
			for(int i=1; i<hull.size(); i++)
				hullArea+=cross(hull.get(i-1), hull.get(i));
			hullArea/=2;
			System.out.printf("%.1f ", rectArea/hullArea*100);
			System.out.println("%");
		}
	}
	
	// monotone chain algorithm
	static ArrayList<Point> findHull(ArrayList<Point> p){
		ArrayList<Point> lower = new ArrayList<>();
		for(int i=0; i<p.size(); i++){
			while(lower.size()>=2 && !ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), p.get(i))) 
				lower.remove(lower.size()-1);
			lower.add(p.get(i));
		}
		ArrayList<Point> upper = new ArrayList<>();
		for(int i=p.size()-1; i>=0; i--){
			while(upper.size()>=2 && !ccw(upper.get(upper.size()-2), upper.get(upper.size()-1), p.get(i))) 
				upper.remove(upper.size()-1);
			upper.add(p.get(i));
		}
		for(int i=1; i<upper.size(); i++) lower.add(upper.get(i));
		return lower;
	}
	
	static double cross(Point a, Point b){
		return a.x*b.y-a.y*b.x;
	}
	
	static Point toVec(Point a, Point b){
		return new Point(b.x-a.x, b.y-a.y);
	}
	
	static boolean ccw(Point a, Point b, Point c){
		return cross(toVec(a, b), toVec(a, c)) > eps;
	}
	
	static Point rotate(Point p, double theta){
		return new Point(p.x*Math.cos(theta)-p.y*Math.sin(theta), p.x*Math.sin(theta)+p.y*Math.cos(theta));
	}
	
	static double toRad(double deg){
		return deg/180 * Math.PI;
	}
	
	static class Point implements Comparable<Point>{
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
		
		Point add(double x, double y){
			this.x+=x;
			this.y+=y;
			return this;
		}
	}
}
