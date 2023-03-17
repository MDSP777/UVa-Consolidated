import java.util.Scanner;

public class UVa_1112 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nc = sc.nextInt();
		while(nc-->0) {
			int n = sc.nextInt();
			int e = sc.nextInt()-1;
			int t = sc.nextInt();
			int[][] adj = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++) adj[i][j] = adj[j][i] = 2000000;
			int m = sc.nextInt();
			while(m-->0) adj[sc.nextInt()-1][sc.nextInt()-1] = sc.nextInt();	
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
			int total = 0;
			for(int i=0; i<n; i++) if(adj[i][e]<=t) total++;
			System.out.println(total);
			if(nc>0) System.out.println();
		}
	}
}
