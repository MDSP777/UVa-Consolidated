import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class UVa_677 {
	static int n, k;
	static boolean[][] adj;
	static StringBuilder sb;
	static boolean[] visited;
	static LinkedList<Integer> path;
	static int ctr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while(true) {
			String[] split = br.readLine().split(" ");
			n = Integer.parseInt(split[0]);
			k = Integer.parseInt(split[1])+1;
			adj = new boolean[n][n];
			for(int i=0; i<n; i++) {
				split = br.readLine().split(" ");
				for(int j=0; j<n; j++)
					adj[i][j] = split[j].equals("1");
			}
			visited = new boolean[n];
			visited[0] = true;
			path = new LinkedList<>();
			ctr = 0;
			bt(0, 0);
			if(ctr==0) sb.append("no walk of length ").append(k-1).append("\n");
			String dump = br.readLine();
			if(dump==null || dump.isEmpty()) break;
			else sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void bt(int cur, int d) {
		path.add(cur+1);
		if(d==k-1) {
			boolean first = true;
			for(int x : path) {
				sb.append(first ? "(": ",").append(x);
				first = false;
			}
			sb.append(")\n");
			ctr++;
			path.pollLast();
			return;
		}
		for(int i=0; i<n; i++)
			if(adj[cur][i] && !visited[i]) {
				visited[i] = true;
				bt(i, d+1);
				visited[i] = false;
			}
		path.pollLast();
	}
}
