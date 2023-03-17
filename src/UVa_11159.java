import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_11159 {
	static ArrayList<Edge>[] e;
	static int[] depth, next;
	static int target;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0; i<n; i++) a[i] = sc.nextInt();
			int m = sc.nextInt();
			int[] b = new int[m];
			for(int i=0; i<m; i++) b[i] = sc.nextInt();
			e = new ArrayList[n+m+2];
			for(int i=0; i<n+m+2; i++) e[i] = new ArrayList<>();
			for(int i=0; i<n; i++) {
				addEdge(n+m, i, 1);
				for(int j=0; j<m; j++)
					if(divisible(b[j], a[i])) {
						addEdge(i, j+n, 1);
					}
			}
			for(int j=0; j<m; j++) addEdge(j+n, n+m+1, 1);
			int flow = 0;
			target = n+m+1;
			while(true) {
				depth = new int[n+m+2];
				Arrays.fill(depth, -1);
				depth[n+m] = 0;
				LinkedList<Integer> q = new LinkedList<>();
				q.add(n+m);
				while(!q.isEmpty()) {
					int cur = q.poll();
					for(Edge ed: e[cur])
						if(ed.rem()>0 && depth[ed.dest]==-1) {
							depth[ed.dest] = depth[cur]+1;
							q.add(ed.dest);
						}
				}
				if(depth[target]==-1) break;
				
				next = new int[n+m+2];
				int f = dfs(n+m, 10000000);
				while(f>0) {
					flow+=f;
					f = dfs(n+m, 10000000);
				}
			}
			System.out.println("Case "+t+": "+flow);
		}
	}
	
	static int dfs(int cur, int flow) {
		if(cur==target) return flow;
		while(next[cur]<e[cur].size()) {
			Edge curE = e[cur].get(next[cur]);
			if(curE.rem()>0 && depth[cur]+1==depth[curE.dest]) {
				int bottleneck = dfs(curE.dest, Math.min(flow, curE.rem()));
				if(bottleneck>0) {
					curE.augment(bottleneck);
					return bottleneck;
				}
			}
			next[cur]++;
		}
		return 0;
	}
	
	static boolean divisible(int p, int q) {
		return (p==0 && q==0) || (q!=0 && p%q==0);
	}
	
	static void addEdge(int src, int dest, int flow) {
		Edge e1 = new Edge(src, dest, flow);
		Edge e2 = new Edge(dest, src, 0);
		e1.residual = e2;
		e2.residual = e1;
		e[src].add(e1);
		e[dest].add(e2);
	}
	
	static class Edge{
		int src, dest, flow, cap;
		Edge residual;
		
		Edge(int a, int b, int c){
			src = a;
			dest = b;
			cap = c;
			flow = 0;
			residual = null;
		}
		
		int rem() {
			return cap-flow;
		}
		
		void augment(int f) {
			flow+=f;
			residual.flow-=f;
		}
	}
}
