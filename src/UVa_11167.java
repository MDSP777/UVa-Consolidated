import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class UVa_11167 {
	static ArrayList<Edge>[] e;
	static int n = 100+50000+2;
	static int INF = 100000000;
	static int[] depth;
	static int[] next;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true) {
			String[] split = br.readLine().split(" ");
			int m = Integer.parseInt(split[0]);
			if(m==0) break;
			int s = Integer.parseInt(split[1]);
			e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			int target = 0;
			boolean[] bound = new boolean[50001];
			Pair[] pairs = new Pair[m];
			for(int i=0; i<m; i++) {
				split = br.readLine().split(" ");
				int v = Integer.parseInt(split[0]);
				int a = Integer.parseInt(split[1]);
				int b = Integer.parseInt(split[2]);
				pairs[i] = new Pair(a, b);
				bound[a] = bound[b] = true;
				addEdge(0, i+1, v);
				target+=v;
			}
			int left = -1;
			int[] end = new int[50010];
			for(int i=0; i<=50000; i++)
				if(bound[i]) {
					if(left==-1) left = i;
					else {
						addEdge(101+left, n-1, s*(i-left));
						end[left] = i;
						left = i;
					}
				}
			for(int i=0; i<m; i++)
				for(int j=pairs[i].a; j<pairs[i].b; j++)
					if(bound[j]) {
						addEdge(i+1, 101+j, end[j]-j);
					}
			
			int flow = 0;
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
				if(depth[n-1]==-1) break;
				next = new int[n];
				int f = dfs(0, INF);
				while(f>0) {
					flow+=f;
					f = dfs(0, INF);
				}
			}
			
			if(flow!=target) sb.append("Case ").append(t++).append(": No\n");
			else {
				int[] vals = new int[50000];
				sb.append("Case ").append(t++).append(": Yes\n");
				for(int i=1; i<m+1; i++) {
					ArrayList<Pair> p = new ArrayList<>();
					for(int j=0; j<e[i].size(); j++) {
						Edge curE = e[i].get(j);
						if(curE.rem()<curE.cap && curE.dest>=101) {
							int a = curE.dest-101, b = -1;
							if(curE.flow==curE.cap) {
								b = a+curE.flow;
								if(p.size()>0 && a==p.get(p.size()-1).b) p.get(p.size()-1).b = b;
								else p.add(new Pair(a, b));
							} else if(vals[a]%(end[a]-a)+curE.flow<=end[a]-a){
								a+=vals[a]%(end[a]-a);
								b = a+curE.flow;
								if(p.size()>0 && a==p.get(p.size()-1).b) p.get(p.size()-1).b = b;
								else p.add(new Pair(a, b));
							} else {
								a = curE.dest-101;
								int right = end[a]-a-vals[a]%(end[a]-a);
								b = a+curE.flow-right;
								if(p.size()>0 && a==p.get(p.size()-1).b) p.get(p.size()-1).b = b;
								else p.add(new Pair(a, b));
								if(right>0) {
									b = end[a];
									a+=vals[a]%(end[a]-a);
									p.add(new Pair(a, b));
								}
							}
							vals[curE.dest-101]+=curE.flow;
						}
					}
					
					sb.append(p.size());
					for(Pair cur : p) sb.append(" (").append(cur.a).append(",").append(cur.b).append(")");
					sb.append("\n");
				}
			}
		}
		System.out.print(sb);
	}
	
	static int dfs(int cur, int flow) {
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
		
		public String toString() {
			return src+" "+dest+" "+flow+"/"+cap;
		}
	}
	
	static class Pair{
		int a, b;
		
		Pair(int x, int y){
			a = x;
			b = y;
		}
	}
}
