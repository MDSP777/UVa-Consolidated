import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UVa_318 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true){
			int n = sc.nextInt()+1;
			int m = sc.nextInt();
			if(n==1) break;
			ArrayList<Edge>[] adj = new ArrayList[n];
			for(int i=0; i<n; i++)
				adj[i] = new ArrayList<>();
			while(m-->0){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int t = sc.nextInt();
				adj[a].add(new Edge(a, b, t));
				adj[b].add(new Edge(b, a, t));
			}
			
			int[] toppleTime = new int[n];
			Arrays.fill(toppleTime, 100000000);
			toppleTime[1] = 0;
			double[][] edgeTopple = new double[n][n];
			for(int i=0; i<n; i++)
				Arrays.fill(edgeTopple[i], -1);
			
			PriorityQueue<State> q = new PriorityQueue<>();
			q.add(new State(1, 0));
			while(!q.isEmpty()){
				State cur = q.poll();
				if(toppleTime[cur.idx]<cur.time) continue;
				
				int src = cur.idx;
				toppleTime[src] = cur.time;
				for(Edge e : adj[cur.idx]){
					if(Double.compare(edgeTopple[src][e.dest], -1)==0){
						edgeTopple[src][e.dest] = edgeTopple[e.dest][src] = cur.time+e.time;
					} else if (edgeTopple[src][e.dest]>cur.time){
						edgeTopple[src][e.dest] = edgeTopple[e.dest][src] = (edgeTopple[src][e.dest]+cur.time)/2;
					}
					
					if(toppleTime[e.dest]>cur.time+e.time){
						toppleTime[e.dest] = cur.time+e.time;
						q.add(new State(e.dest, cur.time+e.time));
					}
				}
			}
			
			double ans = -1;
			boolean isKey = true;
			int lastKey = -1, edgeL = -1, edgeR = -1;
			for(int i=1; i<n; i++) {
				if(toppleTime[i]>ans){
					ans = toppleTime[i];
					lastKey = i;
				}
			}
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) {
					if(edgeTopple[i][j]>ans){
						ans = edgeTopple[i][j];
						isKey = false;
						edgeL = Math.min(i, j);
						edgeR = Math.max(i, j);
					}
				}
			
			System.out.println("System #"+tc++);
			System.out.printf("The last domino falls after %.1f seconds, %s.\n\n", ans, isKey ? "at key domino "+lastKey : "between key dominoes "+edgeL+" and "+edgeR);
		}
	}
	
	static class State implements Comparable<State> {
		int idx;
		int time;
		
		State(int a, int b){
			idx = a;
			time = b;
		}

		@Override
		public int compareTo(State o) {
			if(time==o.time) 
				return idx-o.idx;
			return time-o.time;
		}
		
	}
	
	static class Edge {
		int src, dest;
		int time;
		
		Edge(int src, int dest, int time){
			this.src = src;
			this.dest = dest;
			this.time = time;
		}
	}
}
