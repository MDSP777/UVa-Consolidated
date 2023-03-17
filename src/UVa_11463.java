import java.io.InputStreamReader;
import java.io.BufferedReader;

public class UVa_11463 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		for(int x=1; x<=nC; x++) {
			int n = Integer.parseInt(br.readLine());
			int q = Integer.parseInt(br.readLine());
			int[][] adj = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) if(i!=j) adj[i][j] = 2000000;
			while(q-->0) {
				String[] split = br.readLine().split(" ");
				int src = Integer.parseInt(split[0]);
				int dest = Integer.parseInt(split[1]);
				adj[src][dest] = adj[dest][src] = 1;
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
			int ans = 0;
			String[] split = br.readLine().split(" ");
			int src = Integer.parseInt(split[0]);
			int dest = Integer.parseInt(split[1]);
			for(int k=0; k<n; k++) ans = Math.max(ans, adj[src][k]+adj[k][dest]);
			System.out.println("Case "+x+": "+ans);
		}
	}
}
