import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;

public class UVa_11228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		for(int curC=1; curC<=nC; curC++) {
			String[] split = br.readLine().split("\\s+");
			int n = Integer.parseInt(split[0]);
			double r = Double.parseDouble(split[1]);
			int[] x = new int[n];
			int[] y = new int[n];
			for(int i=0; i<n; i++) {
				split = br.readLine().split("\\s+");
				x[i] = Integer.parseInt(split[0]);
				y[i] = Integer.parseInt(split[1]);
			}
			Edge[][] adj = new Edge[n][n];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) adj[i][j] = new Edge(i, j, Math.hypot(x[i]-x[j], y[i]-y[j]));
			HashSet<Integer> visited = new HashSet<>();
			visited.add(0);
			PriorityQueue<Edge> q = new PriorityQueue<>();
			for(int i=1; i<n; i++) q.add(adj[0][i]);
			int states = 1;
			double roads = 0;
			double railroads = 0;
			while(visited.size()<n) {
				Edge e = q.poll();
				if(!visited.contains(e.x)) {
					for(int i=0; i<n; i++) if(i!=e.x && !visited.contains(i)) q.add(adj[e.x][i]);
					if(e.weight<=r) roads+=e.weight;
					else {
						railroads+=e.weight;
						states++;
					}
					visited.add(e.x);
				} else if(!visited.contains(e.y)) {
					for(int i=0; i<n; i++) if(i!=e.y && !visited.contains(i)) q.add(adj[e.y][i]);
					if(e.weight<=r) roads+=e.weight;
					else {
						railroads+=e.weight;
						states++;
					}
					visited.add(e.y);
				}
			}
			sb.append("Case #").append(curC).append(": ").append(states).append(" ").append((int)(Math.round(roads))).append(" ").append((int)(Math.round(railroads))).append("\n");
		}
		System.out.print(sb);
	}
	
	static class Edge implements Comparable<Edge> {
		int x; 
		int y;
		double weight;
		
		public Edge(int src, int dest, double weight) {
			this.x = src;
			this.y = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
}
