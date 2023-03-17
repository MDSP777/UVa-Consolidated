import java.util.Scanner;

public class UVa_10793 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		for(int x=1; x<=nC; x++) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			int[][] adj = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) if(i!=j) adj[i][j] = 2000000;
			while(q-->0) {
				int s = sc.nextInt()-1;
				int e = sc.nextInt()-1;
				adj[s][e] = adj[e][s] = Math.min(sc.nextInt(), adj[s][e]);
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
			int best = 2000000;
			for(int i=5; i<n; i++) {
				boolean good = true;
				for(int j=1; j<5; j++)
					if(adj[i][j]!=adj[i][0]) {
						good = false;
						break;
					}
				if(good) {
					int max = 0;
					for(int j=0; j<n; j++) max = Math.max(max, adj[i][j]);
					best = Math.min(best, max);
				}
			}
			System.out.println("Map "+x+": "+(best==2000000 ? "-1" : best));
		}
	}
}
