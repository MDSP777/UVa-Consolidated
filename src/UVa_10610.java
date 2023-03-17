import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;

public class UVa_10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] split = br.readLine().split(" ");
			int v = Integer.parseInt(split[0]);
			double m = Integer.parseInt(split[1])*60.0;
			if(v==0 && m==0) break;
			ArrayList<Double> x = new ArrayList<>();
			ArrayList<Double> y = new ArrayList<>();
			while(true) {
				String s = br.readLine();
				if(s.isEmpty()) break;
				split = s.split(" ");
				x.add(Double.parseDouble(split[0]));
				y.add(Double.parseDouble(split[1]));
			}
			int n = x.size();
			ArrayList<Integer>[] e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					if(i!=j) {
						double time = Math.sqrt(Math.pow(x.get(i)-x.get(j), 2)+Math.pow(y.get(i)-y.get(j), 2))/v;
						if(time<=m) {
							e[i].add(j);
							e[j].add(i);
						}
					}
			int ans = -1;
			LinkedList<State> q = new LinkedList<>();
			BitSet visited = new BitSet();
			q.add(new State(0, 0));
			visited.set(0);
			while(!q.isEmpty() && ans==-1) {
				State cur = q.poll();
				for(int next: e[cur.val])
					if(!visited.get(next)) {
						visited.set(next);
						q.add(new State(next, cur.depth+1));
						if(next==1) {
							ans = cur.depth;
							break;
						}
					}
			}
			System.out.println(ans==-1 ? "No." : "Yes, visiting "+ans+" other holes.");
		}
	}
	
	static class State {
		int val;
		int depth;
		
		public State(int v, int d) {
			val = v;
			depth = d;
		}
	}
}
