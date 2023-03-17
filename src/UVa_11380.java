import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_11380 {
	static ArrayList<Edge>[] e;
	static int n;
	static int[] depth;
	static int[] next;
	static int INF = 100000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] rOffsets = {-1, 1, 0, 0};
		int[] cOffsets = {0, 0, -1, 1};
		do{
			int r = sc.nextInt();
			int c = sc.nextInt();
			int p = sc.nextInt();
			char[][] grid = new char[r][];
			for(int i=0; i<r; i++) grid[i] = sc.next().toCharArray();
			
			n = 2*r*c+2;
			e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) {
					int id = c*i+j+1;
					if(grid[i][j]=='#') addEdge(id, n-1, p);
					if(grid[i][j]=='*') addEdge(0, id, 1);
					if(grid[i][j]=='~') continue;
					if(grid[i][j]=='.') addEdge(id, r*c+id, 1);
					for(int x=0; x<4; x++) {
						int newR = i+rOffsets[x];
						int newC = j+cOffsets[x];
						if(newR>=0 && newR<r && newC>=0 && newC<c) {
							if(grid[newR][newC]!='~' && grid[newR][newC]!='*') {
								int src = grid[i][j]=='.' ? r*c+id : id;
								int dest = c*newR+newC+1;
								addEdge(src, dest, INF);
							}
						}
					}
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
			System.out.println(flow);
		}while(sc.hasNext());
	}
	
	static int dfs(int cur, int flow) {
		if(cur==n-1) return flow;
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
	
	static void addEdge(int src, int dest, int cap) {
		Edge e1 = new Edge(src, dest, cap);
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
