import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class UVa_259 {
	static ArrayList<Edge>[] e;
	static int[] depth;
	static int[] next;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 26+10+2;
		int INF = 1000000000;
		while(true) {
			boolean lastCase = false;
			e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			int[] caps = new int[26];
			int target = 0;
			while(true) {
				String s = br.readLine();
				if(s==null) {
					lastCase = true;
					break;
				} else if(s.isEmpty()) break;
				String[] split = s.split(" ");
				int src = split[0].charAt(0)-'A'+1;
				int cap = split[0].charAt(1)-'0';
				for(int i=0; i<split[1].length()-1; i++) 
					addEdge(src, split[1].charAt(i)-'0'+27, 1);
				caps[src-1] = cap;
				target+=cap;
			}
			for(int i=0; i<26; i++) addEdge(0, i+1, caps[i]);
			for(int i=0; i<10; i++) addEdge(27+i, 37, 1);
			
			int flow = 0;
			while(true) {
				depth = new int[n];
				Arrays.fill(depth, -1);
				LinkedList<Integer> q = new LinkedList<>();
				q.add(0);
				depth[0] = 0;
				while(!q.isEmpty()) {
					int cur = q.poll();
					for(Edge ed : e[cur]) {
						if(ed.cap-ed.flow>0 && depth[ed.dest]==-1) {
							depth[ed.dest] = depth[cur]+1;
							q.add(ed.dest);
						}
					}
				}
				if(depth[37]==-1) break;
				next = new int[n];
				Arrays.fill(next, 0);
				int f = dfs(0, INF);
				while(f>0) {
					flow+=f;
					f = dfs(0, INF);
				}
			}
			if(flow!=target) System.out.println("!");
			else {
				char[] hosting = new char[10];
				Arrays.fill(hosting, '_');
				for(int i=1; i<27; i++)
					for(Edge ed : e[i])
						if(ed.dest>=27 && ed.flow==ed.cap) hosting[ed.dest-27] = (char) ('A'+i-1);
				System.out.println(hosting);
			}
			if(lastCase) break;
		}
	}
	
	static void addEdge(int src, int dest, int flow) {
		Edge e1 = new Edge(src, dest, flow);
		Edge e2 = new Edge(dest, src, 0);
		e1.residual = e2;
		e2.residual = e1;
		e[src].add(e1);
		e[dest].add(e2);
	}
	
	static int dfs(int cur, int flow) {
		if(cur==37) return flow;
		while(next[cur]<e[cur].size()) {
			Edge curE = e[cur].get(next[cur]);
			int rem = curE.cap-curE.flow;
			if(rem>0 && depth[cur]+1==depth[curE.dest]) {
				int bottleneck = dfs(curE.dest, Math.min(flow, rem));
				if(bottleneck>0) {
					curE.augment(bottleneck);
					return bottleneck;
				}
			}
			next[cur]++;
		}
		return 0;
	}
	static class Edge {
		int src, dest, cap, flow;
		Edge residual;
		
		Edge(int a, int b, int c){
			src = a;
			dest = b;
			cap = c;
			flow = 0;
			residual = null;
		}
		
		void augment(int v) {
			flow+=v;
			residual.flow-=v;
		}
	}
}
