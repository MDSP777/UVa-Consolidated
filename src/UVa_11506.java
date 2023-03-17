import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class UVa_11506 {
	static ArrayList<Edge>[] e;
	static int[] depth;
	static int[] next;
	static int m;
	static int INF = 100000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] split = br.readLine().split(" ");
			m = Integer.parseInt(split[0]);
			int w = Integer.parseInt(split[1]);
			if(m==0 && w==0) break;
			int n = 2*m-2;
			int offset = m-1;
			e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			for(int i=1; i<m-1; i++) {
				split = br.readLine().split(" ");
				int idx = Integer.parseInt(split[0])-1;
				int cap = Integer.parseInt(split[1]);
				addEdge(idx, offset+idx, cap);
			}
			while(w-->0) {
				split = br.readLine().split(" ");
				int a = Integer.parseInt(split[0])-1;
				int b = Integer.parseInt(split[1])-1;
				int c = Integer.parseInt(split[2]);
				if(a>b) {
					int temp = a;
					a = b;
					b = temp;
				}
				if(a==0) addEdge(a, b, c);
				else if(b==m-1) addEdge(offset+a, b, c);
				else {
					addEdge(offset+a, b, c);
					addEdge(offset+b, a, c);
				}
			}
			
			long flow = 0;
			while(true) {
				depth = new int[n];
				Arrays.fill(depth, -1);
				LinkedList<Integer> q = new LinkedList<>();
				q.add(0);
				depth[0] = 0;
				while(!q.isEmpty()) {
					int cur = q.poll();
					for(Edge ed : e[cur])
						if(ed.rem()>0 && depth[ed.dest]==-1) {
							depth[ed.dest] = depth[cur]+1;
							q.add(ed.dest);
						}
				}
				if(depth[m-1]==-1) break;
				next = new int[n];
				int f = dfs(0, INF);
				while(f>0) {
					flow+=f;
					f = dfs(0, INF);
				}
			}
			System.out.println(flow);
		}
	}
	
	static int dfs(int cur, int flow) {
		if(cur==m-1) return flow;
		while(next[cur]<e[cur].size()) {
			Edge curE = e[cur].get(next[cur]);
			if(curE.rem()>0 && depth[curE.dest]==depth[cur]+1) {
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
	
	static void addEdge(int src, int dest, int cost) {
		Edge e1 = new Edge(src, dest, cost);
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
		
		void augment(int v) {
			flow+=v;
			residual.flow-=v;
		}
	}
}
