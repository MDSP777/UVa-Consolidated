import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class UVa_12321 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] split = br.readLine().split(" ");
			int l = Integer.parseInt(split[0]);
			int g = Integer.parseInt(split[1]);
			if(l==0 && g==0) break;
			ArrayList<Point> points = new ArrayList<>();
			for(int i=0; i<g; i++){
				split = br.readLine().split(" ");
				int x = Integer.parseInt(split[0]);
				int r = Integer.parseInt(split[1]);
				int a = x-r;
				int b = x+r;
				if(a<=l && r>=0) points.add(new Point(a, b));
			}
			Collections.sort(points);
			if(points.isEmpty() || points.get(0).l>0) System.out.println(-1);
			else {
				int curLeft = -10000000;
				boolean success = true;
				Stack<Point> st = new Stack<>();
				for(Point cur: points){
					if(st.isEmpty()){
						st.push(cur);
						curLeft = cur.l;
					} else {
						if(cur.l>st.peek().r){
							success = false;
							break;
						}
						if(cur.l==st.peek().l || cur.r<=st.peek().r) continue;
						else {
							Point top = st.pop();
							if((st.isEmpty() && cur.l>0) || (!st.isEmpty() && cur.l>st.peek().r)) st.push(top);
							st.push(cur);
						}
					}
					if(st.peek().r>=l) break;
				}
				if(st.isEmpty() || !success || curLeft>0 || st.peek().r<l) System.out.println(-1);
				else System.out.println(g-st.size());
			}
		}
	}
	
	static class Point implements Comparable<Point>{
		int l, r;
		
		Point(int a, int b){
			l = a;
			r = b;
		}

		@Override
		public int compareTo(Point o) {
			if(l==o.l) return o.r-r;
			return l-o.l;
		}
	}
}
