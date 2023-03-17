import java.util.Scanner;

public class UVa_10724 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0 && m==0) break;
			boolean[][] roads = new boolean[n][n];
			double[][] adj = new double[n][n];
			int[] x = new int[n];
			int[] y = new int[n];
			for(int i=0; i<n; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) if(i!=j) adj[i][j] = 2000000;
			while(m-->0) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				double dist = Math.sqrt(Math.pow(x[u]-x[v], 2)+Math.pow(y[u]-y[v], 2));
				adj[u][v] = adj[v][u] = dist;
				roads[u][v] = roads[v][u] = true;
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
			double max = 1;
			int s = 0;
			int e = 0;
			for(int u=0; u<n; u++)
				for(int v=u+1; v<n; v++)
					if(!roads[u][v]) {
						double c = 0;
						double dist = Math.sqrt(Math.pow(x[u]-x[v], 2)+Math.pow(y[u]-y[v], 2));
						for(int i=0; i<n; i++)
							for(int j=0; j<n; j++) {
								double curCost = Math.min(adj[i][j], adj[i][u]+dist+adj[v][j]);
								curCost = Math.min(curCost, adj[i][v]+dist+adj[u][j]);
								c+=adj[i][j]-curCost;
							}
						if(c>max) {
							max = c;
							s = u+1;
							e = v+1;
						}
					}
			System.out.println(max==1 ? "No road required" : (s+" "+e));
		}
	}
}
