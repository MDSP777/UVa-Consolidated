import java.util.ArrayList;
import java.util.Scanner;

public class UVa_539 {
	static int maxDepth;
	static ArrayList<Integer>[] adj;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			int m = sc.nextInt();
			maxDepth = 0;
			adj = new ArrayList[n];
			for(int i=0; i<n; i++) adj[i] = new ArrayList<Integer>();
			while(m-->0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a].add(b);
				adj[b].add(a);
			}
			for(int i=0; i<n; i++) {
				visited = new boolean[n][n];
				dfs(i, 0);
			}
			System.out.println(maxDepth);
		}
	}
	
	static void dfs(int cur, int depth) {
		maxDepth = Math.max(maxDepth, depth);
		for(int next : adj[cur])
			if(!visited[cur][next]) {
				visited[cur][next] = visited[next][cur] = true;
				dfs(next, depth+1);
				visited[cur][next] = visited[next][cur] = false;
			}
	}
}
