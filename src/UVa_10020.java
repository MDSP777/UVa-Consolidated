import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class UVa_10020 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			int m = sc.nextInt();
			ArrayList<Point> points = new ArrayList<>();
			while(true){
				int l = sc.nextInt();
				int r = sc.nextInt();
				if(l==0 && r==0) break;
				if(r>0 && l<=m) points.add(new Point(l, r));
			}
			Collections.sort(points);
			if(points.isEmpty() || points.get(0).l>0) System.out.println(0);
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
					if(st.peek().r>=m) break;
				}
				if(st.isEmpty() || !success || curLeft>0 || st.peek().r<m) System.out.println(0);
				else {
					System.out.println(st.size());
					ArrayList<Point> ans = new ArrayList<>();
					while(!st.isEmpty()) ans.add(st.pop());
					for(int i=ans.size()-1; i>=0; i--) System.out.println(ans.get(i).l+" "+ans.get(i).r);
				}
			}
			if(tc>0) System.out.println();
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
