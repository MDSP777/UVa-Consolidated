import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class UVa_10927 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			HashMap<Double, ArrayList<Point>>[] quadrants = new HashMap[8];
			for(int i=0; i<8; i++) quadrants[i] = new HashMap<>();
			for(int i=0; i<n; i++){
				String[] split = br.readLine().split(" ");
				Point p = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
				HashMap<Double, ArrayList<Point>> curQ = quadrants[getQuadrant(p.x, p.y)];
				double slope = getSlope(p);
				if(!curQ.containsKey(slope)) curQ.put(slope, new ArrayList<Point>());
				curQ.get(slope).add(p);
//				System.out.println(p.x+" "+p.y+" "+slope);
			}
			ArrayList<Point> notVisible = new ArrayList<>();
			for(HashMap<Double, ArrayList<Point>> curQ : quadrants){
				for(Double key : curQ.keySet()){
					ArrayList<Point> points = curQ.get(key);
					Collections.sort(points);
					long maxH = -100;
					for(Point p : points){
						if(p.h<=maxH) notVisible.add(p);
						maxH = Math.max(maxH, p.h);
					}
				}
			}
			sb.append("Data set ").append(t++).append(":\n");
			if(notVisible.isEmpty()) sb.append("All the lights are visible.\n");
			else {
				sb.append("Some lights are not visible:\n");
				Collections.sort(notVisible, new Comparator<Point>() {
					public int compare(Point a, Point b) {
						if(a.x==b.x) return Long.compare(a.y, b.y);
						return Long.compare(a.x, b.x);
					}
				});
				for(int i=0; i<notVisible.size(); i++){
					Point p = notVisible.get(i);
					sb.append("x = ").append(p.x).append(", y = ").append(p.y);
					if(i==notVisible.size()-1) sb.append(".\n");
					else sb.append(";\n");
				}
			}
		}
		System.out.print(sb);
	}
	
	static double getSlope(Point p){
		if(p.x==0) return Double.NaN;
		return p.y*1.0D/p.x;
	}
	
	static int getQuadrant(long x, long y){
		if(x>0){
			if(y>0) return 0; // q1
			if(y==0) return 4; // +x axis
			return 3; // q4
		} else if(x==0){
			if(y>0) return 5; // +y axis
			if(y==0) return -100; // should not happen
			return 7; // -y axis
		} else {
			if(y>0) return 1; // q2
			if(y==0) return 6; // -x axis
			return 2; // q3
		}
	}
	
	static class Point implements Comparable<Point> {
		long x, y, h;
		
		Point(int a, int b, int c){
			x = a;
			y = b;
			h = c;
		}

		@Override
		public int compareTo(Point o) {
			return Long.compare(x*x+y*y, o.x*o.x+o.y*o.y);
		}
	}
}
