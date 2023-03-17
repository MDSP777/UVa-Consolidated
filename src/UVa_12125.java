import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class UVa_12125 {
	static ArrayList<Edge>[] e;
	static int[] depth;
	static int[] next;
	static int n;
	static int INF = 1000000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			String[] split = br.readLine().split(" ");
			int p = Integer.parseInt(split[0]);
			double d = Double.parseDouble(split[1]);
			int[] x = new int[p];
			int[] y = new int[p];
			n = 2*p+2;
			e = new ArrayList[n];
			Edge[] sinkEdges = new Edge[p];
			int total = 0;
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			for(int i=0; i<p; i++) {
				split = br.readLine().split(" ");
				x[i] = Integer.parseInt(split[0]);
				y[i] = Integer.parseInt(split[1]);
				int count = Integer.parseInt(split[2]);
				int cap = Integer.parseInt(split[3]);
				addEdge(0, i+1, count);
				addEdge(i+1, p+i+1, cap);
				total+=count;
			}
			for(int i=0; i<p; i++) {
				sinkEdges[i] = new Edge(i+1, n-1, 0);
				Edge e2 = new Edge(n-1, i+1, 0);
				sinkEdges[i].residual = e2;
				e2.residual = sinkEdges[i];
				e[i+1].add(sinkEdges[i]);
				e[n-1].add(e2);
			}
			for(int i=0; i<p; i++)
				for(int j=0; j<p; j++) {
					if(i!=j && dist(x[i]-x[j], y[i]-y[j])<=d) {
						addEdge(p+i+1, j+1, INF);
						addEdge(p+j+1, i+1, INF);
					}
				}
			
			ArrayList<Integer> ans = new ArrayList<>();
			for(int cand=0; cand<p; cand++) {
				sinkEdges[cand].cap = total;
				int flow = 0;
				while(true) {
					LinkedList<Integer> q = new LinkedList<>();
					depth = new int[n];
					Arrays.fill(depth, -1);
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
					if(depth[n-1]==-1) break;
					next = new int[n];
					int f = dfs(0, INF);
					while(f>0) {
						flow+=f;
						f = dfs(0, INF);
					}
				}
				if(sinkEdges[cand].flow==total) ans.add(cand);
				for(int i=0; i<n; i++)
					for(Edge ed : e[i]) ed.flow = 0;
				sinkEdges[cand].cap = 0;
			}
			if(ans.size()==0) System.out.println(-1);
			else {
				System.out.print(ans.get(0));
				for(int i=1; i<ans.size(); i++) System.out.print(" "+ans.get(i));
				System.out.println();
			}
		}
	}
	
	private static int dfs(int cur, int flow) {
		if(cur==n-1) return flow;
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

	static double dist(double x, double y) {
		return Math.sqrt(x*x+y*y);
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
		
		void augment(int v) {
			flow+=v;
			residual.flow-=v;
		}
	}
}
