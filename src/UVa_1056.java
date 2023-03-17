import java.util.HashMap;
import java.util.Scanner;

public class UVa_1056 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 1;
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0 && m==0) break;
			int index = 0;
			HashMap<String, Integer> map = new HashMap<>();
			int[][] adj = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++) adj[i][j] = adj[j][i] = 2000000; 
			while(m-->0) {
				String s = sc.next();
				String e = sc.next();
				if(!map.containsKey(s)) map.put(s, index++);
				if(!map.containsKey(e)) map.put(e, index++);
				int u = map.get(s);
				int v = map.get(e);
				adj[u][v] = adj[v][u] = 1;
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
			int max = 0;
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) max = Math.max(max, adj[i][j]);
			System.out.println("Network "+x+++": "+(max==2000000 ? "DISCONNECTED" : max)+"\n");
		}
	}
}
