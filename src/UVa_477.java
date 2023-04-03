import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class UVa_477 {
	static double eps = 1e-9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Shape> list = new ArrayList<>();
		while(true){
			String[] split = br.readLine().split(" ");
			if(split[0].equals("*")) break;
			if(split[0].equals("r")){
				list.add(new Rectangle(Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]), Double.parseDouble(split[4])));
			} else {
				list.add(new Circle(Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3])));
			}
		}
		int ctr = 1;
		while(true){
			String[] split = br.readLine().split(" ");
			double x = Double.parseDouble(split[0]);
			double y = Double.parseDouble(split[1]);
			if(Math.abs(x-9999.9)<eps && Math.abs(y-9999.9)<eps) break;
			Point p = new Point(x, y);
			int ans = 0;
			for(int i=0; i<list.size(); i++){
				if(list.get(i).contains(p)) {
					System.out.println("Point "+ctr+" is contained in figure "+(i+1));
					ans++;
				}
			}
			if(ans==0) System.out.println("Point "+ctr+" is not contained in any figure");
			ctr++;
		}
	}
	
	static abstract class Shape {
		abstract boolean contains(Point p);
	}
	
	static class Circle extends Shape {
		Point c;
		double r;
		
		Circle(double x, double y, double z){
			c = new Point(x, y);
			r = z;
		}

		@Override
		boolean contains(Point p) {
			// TODO Auto-generated method stub
			return Math.hypot(c.x-p.x, c.y-p.y)<=r;
		}
	}
	
	static class Rectangle extends Shape {
		Point ul, lr;
		
		Rectangle(double a, double b, double c, double d){
			ul = new Point(a, b);
			lr = new Point(c, d);
		}

		@Override
		boolean contains(Point p) {
			return p.x>=ul.x && p.x<=lr.x && p.y>=lr.y && p.y<=ul.y;
		}
	}
	
	static class Point{
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}
	}
}
