import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class UVa_10389 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		br.readLine();
		while(nC-->0) {
			String[] split = br.readLine().split(" ");
			ArrayList<Integer> x = new ArrayList<>();
			ArrayList<Integer> y = new ArrayList<>();
			x.add(Integer.parseInt(split[0]));
			y.add(Integer.parseInt(split[1]));
			x.add(Integer.parseInt(split[2]));
			y.add(Integer.parseInt(split[3]));
			HashMap<Integer, Integer> lines = new HashMap<>();
			lines.put(0, -1);
			lines.put(1, -2);
			int line = 0;
			while(true) {
				String s = br.readLine();
				if(s==null || s.isEmpty()) break;
				split = s.split(" ");
				if(split.length<=4) continue;
				for(int i=0; i<split.length-2; i+=2) {
					x.add(Integer.parseInt(split[i]));
					y.add(Integer.parseInt(split[i+1]));
					lines.put(x.size()-1, line);
				}
				line++;
			}
			double[] dist = new double[x.size()];
			for(int i=1; i<x.size(); i++) dist[i] = 2000000;
			PriorityQueue<State> q = new PriorityQueue<>();
			q.add(new State(0, 0));
			while(!q.isEmpty()) {
				State cur = q.poll();
				if(cur.dist>dist[cur.i]) continue;
				for(int i=0; i<x.size(); i++) {
					double v = lines.get(cur.i)==lines.get(i) && Math.abs(cur.i-i)==1 ? 2000.0/3 : 1000.0/6;
					double time = Math.sqrt(Math.pow(x.get(cur.i)-x.get(i), 2)+Math.pow(y.get(cur.i)-y.get(i), 2))/v;
					if(dist[cur.i]+time<dist[i]) {
						dist[i] = dist[cur.i]+time;
						q.add(new State(i, dist[i]));
					}
				}
			}
			System.out.printf("%.0f\n", dist[1]);
			if(nC>0) System.out.println();
		}
	}
	
	static class State implements Comparable<State> {
		int i;
		double dist;
		
		public State(int i, double dist) {
			this.i = i;
			this.dist = dist;
		}

		@Override
		public int compareTo(State o) {
			return Double.compare(dist, o.dist);
		}
	}
}
