import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_10349 {
	static ArrayList<Edge>[] e;
	static int[] depth, next;
	static int INF = 100000000;
	static int target, n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] rOffsets = {1, -1, 0, 0};
		int[] cOffsets = {0, 0, -1, 1};
		while(tc-->0) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			char[][] grid = new char[r][c];
			int[][] ids = new int[r][c];
			int[][] colors = new int[r][c];
			int stars = 0;
			for(int i=0; i<r; i++) {
				grid[i] = sc.next().toCharArray();
				for(int j=0; j<c; j++)
					if(grid[i][j]=='*') 
						ids[i][j] = stars++;
				Arrays.fill(colors[i], -1);
			}
			n = stars+2;
			e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++)
					if(grid[i][j]=='*' && colors[i][j]==-1) {
						LinkedList<Point> q = new LinkedList<>();
						colors[i][j] = 0;
						q.add(new Point(i, j));
						while(!q.isEmpty()) {
							Point cur = q.poll();
							for(int x=0; x<4; x++) {
								int newR = cur.x+rOffsets[x];
								int newC = cur.y+cOffsets[x];
								if(newR>=0 && newR<r && newC>=0 && newC<c && grid[newR][newC]=='*' && colors[newR][newC]==-1) {
									colors[newR][newC] = Math.abs(colors[cur.x][cur.y]-1);
									q.add(new Point(newR, newC));
								}
							}
						}
					}
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) 
					if(colors[i][j]==0) {
						for(int x=0; x<4; x++) {
							int newR = i+rOffsets[x];
							int newC = j+cOffsets[x];
							if(newR>=0 && newR<r && newC>=0 && newC<c && grid[newR][newC]=='*') addEdge(ids[i][j], ids[newR][newC], 1);
						}
					}
			
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++)
					if(colors[i][j]==0) addEdge(n-2, ids[i][j], 1);
					else if(colors[i][j]==1) addEdge(ids[i][j], n-1, 1);
			
			int flow = 0;
			while(true) {
				depth = new int[n];
				Arrays.fill(depth, -1);
				LinkedList<Integer> q = new LinkedList<>();
				depth[n-2] = 0;
				q.add(n-2);
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
				int f = dfs(n-2, INF);
				while(f>0) {
					flow+=f;	
					f = dfs(n-2, INF);
				}
			}
			System.out.println(stars-flow);
		}
	}
	
	static class Point{
		int x, y;
		
		public Point(int i, int j) {
			x = i;
			y = j;
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
	
	static class Edge{
		int src, dest, cap, flow;
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
