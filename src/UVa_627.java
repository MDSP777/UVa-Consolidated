import java.util.Scanner;

public class UVa_627 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int n = sc.nextInt();
			int[][] adj = new int[n][n];
			int[][] next = new int[n][n];
			for(int i=0; i<n; i++) {
				next[i][i] = i;
				for(int j=i+1; j<n; j++) adj[i][j] = adj[j][i] = next[i][j] = next[j][i] = 2000000;
				String[] split = sc.next().split("-");
				int u = Integer.parseInt(split[0])-1;
				if(split.length<2) continue;
				split = split[1].split(",");
				for(int j=0; j<split.length; j++) {
					int v = Integer.parseInt(split[j])-1;
					adj[u][v] = 1;
					next[u][v] = v;
				}
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++)
						if(adj[i][k]+adj[k][j]<adj[i][j]) {
							adj[i][j] = adj[i][k]+adj[k][j];
							next[i][j] = next[i][k];
						}
			System.out.println("-----");
			int q = sc.nextInt();
			while(q-->0) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				if(adj[u][v]==2000000) System.out.println("connection impossible");
				else {
					StringBuilder sb = new StringBuilder();
					sb.append(u+1);
					while(u!=v) {
						u = next[u][v];
						sb.append(" ").append(u+1);
					}
					System.out.println(sb);
				}
			}
		} while(sc.hasNext());
	}
}
