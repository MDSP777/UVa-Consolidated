import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class UVa_820 {
	static int s, t;
	static int[] levels, nextEdge;
	static ArrayList<Edge>[] e;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 1;
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			s = sc.nextInt()-1;
			t = sc.nextInt()-1;
			int c = sc.nextInt();
			e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			while(c-->0){
				int src = sc.nextInt()-1;
				int dest = sc.nextInt()-1;
				int cap = sc.nextInt();
				e[src].add(new Edge(src, dest, cap));
				e[dest].add(new Edge(dest, src, cap));
			}
			int maxFlow = 0;
			if(s==t){
				System.out.println("Network "+x+++"\nThe bandwidth is "+maxFlow+".\n");
				continue;
			}
			while(true){
				levels = new int[n];
				nextEdge = new int[n];
				Arrays.fill(levels, -1);
				LinkedList<Integer> q = new LinkedList<>();
				q.add(s);
				levels[s] = 0;
				while(!q.isEmpty()){
					int cur = q.poll();
					for(Edge next : e[cur]){
						if(levels[next.dest]==-1 && next.flow<next.cap){
							q.add(next.dest);
							levels[next.dest] = levels[next.src]+1;
						}
					}
				}
				if(levels[t]==-1) break;
				while(true){
					int flow = dfs(s, Integer.MAX_VALUE);
					if(flow==0) break;
					maxFlow+=flow;
				}
			}
			System.out.println("Network "+x+++"\nThe bandwidth is "+maxFlow+".\n");
		}
	}
	
	private static int dfs(int cur, int flow) {
		if(cur==t) return flow;
		while(nextEdge[cur]<e[cur].size()){
			Edge next = e[cur].get(nextEdge[cur]);
			if(next.remaining()>0 && levels[cur]+1==levels[next.dest]){
				int bottleneck = dfs(next.dest, Math.min(flow, next.remaining()));
				if(bottleneck>0){
					next.flow+=bottleneck;
					return bottleneck;
				}
			}
			nextEdge[cur]++;
		}
		return 0;
	}

	static class Edge {
		int src, dest, flow, cap;
		
		Edge(int a, int b, int c){
			src = a;
			dest = b;
			flow = 0;
			cap = c;
		}
		
		int remaining(){
			return cap-flow;
		}
	}
}
