import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class UVa_12047 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		int[] dist = new int[10100];
		int[] dist2 = new int[10100];
		ArrayList<Edge>[] e = new ArrayList[10100];
		ArrayList<Edge>[] be = new ArrayList[10100];
		while(tc-->0){
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			int s = Integer.parseInt(split[2])-1;
			int t = Integer.parseInt(split[3])-1;
			int p = Integer.parseInt(split[4]);
			for(int i=0; i<n; i++){
				e[i] = new ArrayList<>();
				be[i] = new ArrayList<>();
			}
			while(m-->0){
				split = br.readLine().split(" ");
				int u = Integer.parseInt(split[0])-1;
				int v = Integer.parseInt(split[1])-1;
				int c = Integer.parseInt(split[2]);
				e[u].add(new Edge(v, c));
				be[v].add(new Edge(u, c));
			}
			int ans = -1;
			PriorityQueue<Edge> q = new PriorityQueue<>();
			for(int i=0; i<n; i++) dist[i] = dist2[i] = 100000000;
			dist[s] = dist2[t] = 0;
			q.add(new Edge(s, 0));
			while(!q.isEmpty()){
				Edge cur = q.poll();
				int u = cur.dest;
				if(cur.weight>dist[u]) continue;
				for(Edge next: e[u]){
					int cost = dist[u]+next.weight;
					if(cost<dist[next.dest] && cost<=p){
						dist[next.dest] = cost;
						q.add(new Edge(next.dest, cost));
					}
				}
			}
			q.add(new Edge(t, 0));
			while(!q.isEmpty()){
				Edge cur = q.poll();
				int u = cur.dest;
				if(cur.weight>dist2[u]) continue;
				for(Edge next: be[u]){
					int cost = dist2[u]+next.weight;
					if(cost<dist2[next.dest] && cost<=p){
						dist2[next.dest] = cost;
						q.add(new Edge(next.dest, cost));
					}
				}
			}
			for(int i=0; i<n; i++)
				for(Edge next: e[i])
					if(dist[i]+next.weight+dist2[next.dest]<=p) ans = Math.max(ans, next.weight);
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static class Edge implements Comparable<Edge>{
		int dest;
		int weight;
		
		public Edge(int d, int v){
			dest = d;
			weight = v;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(o.weight, weight);
		}
	}
}
