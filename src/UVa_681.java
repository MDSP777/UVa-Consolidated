import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class UVa_681 {
	static Point startPoint;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine().trim());
		sb.append(nC).append("\n");
		for(int x=0; x<nC; x++) {
			startPoint = new Point(Double.MAX_VALUE, Double.MAX_VALUE);
			int nPoints = Integer.parseInt(br.readLine().trim());
			ArrayList<Point> points = new ArrayList<>();
			for(int i=0; i<nPoints-1; i++) {
				String[] split = br.readLine().trim().split(" ");
				Point p = new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
				if(p.y<startPoint.y || (p.y==startPoint.y && p.x<startPoint.x)) startPoint = new Point(p.x, p.y);
				points.add(p);
			}
			Collections.sort(points);
			points.add(points.get(0));
			Stack<Point> s = new Stack<>();
			s.push(points.get(0));
			s.push(points.get(1));
//			s.push(points.get(2));
			for(int i=2; i<points.size(); i++) {
				Point p1 = null;
				Point p2 = null;
				Point p3 = null;
				if(!s.isEmpty()) {
					p2 = s.pop();
					p1 = s.peek();
					p3 = points.get(i);
					s.push(p2);
				}
				if(collinear(p1, p2, p3)) {
					s.pop();
					s.push(p3);
					continue;
				}
				while(rightTurn(p1, p2, p3)) {
					s.pop();
					if(!s.isEmpty()) {
						p2 = s.pop();
						p1 = s.peek();
						s.push(p2);
					}
				}
				s.push(points.get(i));
			}
			sb.append(s.size()).append("\n");
			Point[] ans = new Point[s.size()];
			int index = ans.length-1;
			while(!s.isEmpty()) ans[index--] = s.pop();
			for(int i=0; i<ans.length; i++) sb.append(ans[i]).append("\n");
			if(x<nC-1) {
				sb.append("-1\n");
				br.readLine();
			}
			br.readLine();
		}
		System.out.print(sb);
	}
	
	private static boolean collinear(Point p1, Point p2, Point p3) {
		// reference: https://www.geeksforgeeks.org/program-check-three-points-collinear/
		return p1.x*(p2.y-p3.y)+p2.x*(p3.y-p1.y)+p3.x*(p1.y-p2.y)==0;
	}

	private static boolean rightTurn(Point p1, Point p2, Point p3) {
		// reference: https://en.wikipedia.org/wiki/Graham_scan
		double crossProduct = (p2.x-p1.x)*(p3.y-p1.y)-(p2.y-p1.y)*(p3.x-p1.x);
		return crossProduct<=0;
	}

	static class Point implements Comparable<Point> {
		double x;
		double y;
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double slope() {
			// reference: https://www.youtube.com/watch?v=-OMbXkhHFBQ
			return Math.atan((this.y-startPoint.y)/(this.x-startPoint.x));
		}

		@Override
		public int compareTo(Point o) {
			if(this.x==startPoint.x && this.y==startPoint.y) return Integer.MIN_VALUE;
			if(o.x==startPoint.x && o.y==startPoint.y) return Integer.MAX_VALUE;
			double mySlope = this.slope();
			double oSlope = o.slope();
			mySlope += mySlope < 0 ? 180 : 0;
			oSlope += oSlope < 0 ? 180 : 0;
			return Double.compare(Math.atan(mySlope), Math.atan(oSlope));
		}
		
		public String toString() {
//			return "("+x+","+y+") "+Math.atan((this.y-startPoint.y)/(this.x-startPoint.x))*180/Math.PI;
			return (int)x+" "+(int)y;
		}
	}
}

/*
Code to generate random polygon with variable size
import java.util.*;

public class whatever {

    public static void main(String[] args) throws Exception {
        int size = 1000;
        Random r = new Random();
        System.out.println("1");
    	System.out.println(size);
        int startX = r.nextInt(size);
        int startY = r.nextInt(size);
        System.out.println(startX+" "+startY);
        for(int i=1; i<size-1; i++) System.out.println(r.nextInt(size)+" "+r.nextInt(size));
        System.out.println(startX+" "+startY);
    }
}
*/