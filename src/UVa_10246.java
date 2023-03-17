import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class UVa_10246 {
	public static void main(String[] args) throws Exception {
//		System.setOut(new PrintStream("out.txt"));
//		System.setIn(new FileInputStream("in.txt"));
		System.out.println(-19%7);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		boolean first = true;
		while(true){
			String[] split = br.readLine().split(" ");
			int c = Integer.parseInt(split[0]);
			int r = Integer.parseInt(split[1]);
			int q = Integer.parseInt(split[2]);
			if(c==0) break;
			if(first) first = false;
			else sb.append("\n");
			int[] costs = new int[c];
			ArrayList<Edge>[] adj = new ArrayList[c];
			split = br.readLine().split(" ");
			for(int i=0; i<c; i++) {
				costs[i] = Integer.parseInt(split[i]);
				adj[i] = new ArrayList<>();
//				best[i][i] = 0;
			}
			
			while(r-->0){
				split = br.readLine().split(" ");
				int src = Integer.parseInt(split[0])-1;
				int dest = Integer.parseInt(split[1])-1;
				int cost = Integer.parseInt(split[2]);
				adj[src].add(new Edge(src, dest, cost));
				adj[dest].add(new Edge(dest, src, cost));
			}
		
			int[][] gBest = new int[c][c];
			int[][] gFeast = new int[c][c];
			for(int i=0; i<c; i++){
				int[] best = gBest[i];
				int[] feast = gFeast[i];
				PriorityQueue<State> pq = new PriorityQueue<>();
				Arrays.fill(best, 100000000);
				best[i] = 0;
				feast[i] = costs[i];
				for(Edge e : adj[i]) {
					pq.add(new State(e.dest, e.cost, Math.max(costs[e.src], costs[e.dest])));
					best[e.dest] = e.cost;
					feast[e.dest] = Math.max(costs[e.src], costs[e.dest]);
					
				}
				while(!pq.isEmpty()){
					State st = pq.poll();
					if(st.cost()>best[st.cur]+feast[st.cur]) continue;
					
					for(Edge e : adj[st.cur]){
						int pathCost = best[st.cur]+e.cost;
						int bestFeast = Math.max(feast[st.cur], costs[e.dest]);
						if(pathCost+bestFeast<best[e.dest]+feast[e.dest]){
							best[e.dest] = pathCost;
							feast[e.dest] = bestFeast;
							pq.add(new State(e.dest, pathCost, bestFeast));
 						}
					}
				}
			}
			
			sb.append("Case #").append(t++).append("\n");
			while(q-->0){
				split = br.readLine().split(" ");
				int src = Integer.parseInt(split[0])-1;
				int dest = Integer.parseInt(split[1])-1;
				
				if(gBest[src][dest]==100000000) sb.append("-1\n");
				else sb.append(gBest[src][dest]+gFeast[src][dest]).append("\n");
			}
		}
		System.out.print(sb);
	}
	
	static class Edge{
		int src, dest, cost;
		
		Edge(int a, int b, int c){
			src = a;
			dest = b;
			cost = c;
		}
	}
	
	static class State implements Comparable<State> {
		int cur, path, feast;
		
		State(int c, int a, int b){
			cur = c;
			path = a;
			feast = b;
		}
		
		int cost(){
			return path+feast;
		}

		@Override
		public int compareTo(State o) {
			return (path+feast)-(o.path+o.feast);
		}
	}
}
