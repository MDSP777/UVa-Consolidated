import java.util.HashMap;
import java.util.Scanner;

public class UVa_762 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		do {
			int r = sc.nextInt();
			HashMap<String, Integer> map = new HashMap<>();
			HashMap<Integer, String> map2 = new HashMap<>();
			int n = 0;
			int[] x = new int[r];
			int[] y = new int[r];
			for(int i=0; i<r; i++) {
				String s1 = sc.next();
				String s2 = sc.next();
				if(!map.containsKey(s1)) {
					map.put(s1, n);
					map2.put(n++, s1);
				}
				if(!map.containsKey(s2)) {
					map.put(s2, n);
					map2.put(n++, s2);
				}
				x[i] = map.get(s1);
				y[i] = map.get(s2);
			}
			int[][] adj = new int[n][n];
			int[][] next = new int[n][n];
			for(int i=0; i<n; i++) {
				next[i][i] = i;
				for(int j=i+1; j<n; j++) adj[i][j] = adj[j][i] = next[i][j] = next[j][i] = 2000000;
			}
			for(int i=0; i<r; i++) {
				adj[x[i]][y[i]] = adj[y[i]][x[i]] = 1;
				next[x[i]][y[i]] = y[i];
				next[y[i]][x[i]] = x[i];
			}
			String s1 = sc.next();
			String s2 = sc.next();
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++)
						if(adj[i][k]+adj[k][j]<adj[i][j]) {
							adj[i][j] = adj[i][k]+adj[k][j];
							next[i][j] = next[i][k];
						}
			if(map.get(s1)==null || map.get(s2)==null || next[map.get(s1)][map.get(s2)]==2000000) sb.append("No route\n");
			else {
				int u = map.get(s1);
				int v = map.get(s2);
				sb.append(s1).append(" ").append(map2.get(next[u][v])).append("\n");
				while(next[u][v]!=v) {
					u = next[u][v];
					sb.append(map2.get(u)).append(" ").append(map2.get(next[u][v])).append("\n");
				}
			}
			if(sc.hasNext()) sb.append("\n");
		} while(sc.hasNext());
		System.out.print(sb);
	}
}
