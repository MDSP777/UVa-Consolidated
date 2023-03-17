import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class UVa_10382 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split(" ");
			int n = Integer.parseInt(split[0]);
			int l = Integer.parseInt(split[1]);
			int w = Integer.parseInt(split[2]);
			ArrayList<Sprinkler> a = new ArrayList<>();
			while(n-->0){
				split = br.readLine().split(" ");
				long c = Integer.parseInt(split[0]);
				long r = Integer.parseInt(split[1]);
				double dx = Math.sqrt(r*r-(w/2.0)*(w/2.0));
				if(Double.isNaN(dx)) continue;
				a.add(new Sprinkler(c-dx, c+dx));
			}
			Collections.sort(a);
			double curLeft = -1000000000;
			boolean success = true;
			Stack<Sprinkler> st = new Stack<>();
			for(Sprinkler cur : a){
				if(cur.left>l) break;
				if(st.isEmpty()){
					curLeft = cur.left;
					st.push(cur);
				} else {
					if(cur.left>st.peek().right){
						success = false;
						break;
					} else {
						if(Math.abs(cur.left-st.peek().left)<1e-9 || cur.right<=st.peek().right) continue;
						else {
							Sprinkler top = st.pop();
							if((st.isEmpty() && cur.left>0) || (!st.isEmpty() && cur.left>st.peek().right)) st.push(top);
							st.push(cur);
						}
					}
				}
				if(st.peek().right>=l) break;
			}
			if(st.isEmpty() || !success || curLeft>0 || st.peek().right<l) System.out.println(-1);
			else System.out.println(st.size());
		}
	}
	
	static class Sprinkler implements Comparable<Sprinkler> {
		double left, right;
		
		Sprinkler(double l, double r){
			left = l;
			right = r;
		}

		@Override
		public int compareTo(Sprinkler o) {
			if(Math.abs(left-o.left)<1e-9) return Double.compare(o.right, right);
			return Double.compare(left, o.left);
		}
		
		public String toString(){
			return left+" "+right;
		}
	}
}
