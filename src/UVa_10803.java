import java.util.Scanner;

public class UVa_10803 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		for(int c=1; c<=nC; c++) {
			int n = sc.nextInt();
			int[] x = new int[n];
			int[] y = new int[n];
			for(int i=0; i<n; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			double[][] adj = new double[n][n];
			for(int i=0; i<n; i++) {
				adj[i][i] = 0;
				for(int j=i+1; j<n; j++) {
					double dist = Math.sqrt(Math.pow(x[i]-x[j], 2)+Math.pow(y[i]-y[j], 2));
					adj[i][j] = adj[j][i] = dist<=10 ? dist : 2000000;
				}
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
			double max = 0;
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++) max = Math.max(max, adj[i][j]);
			System.out.println("Case #"+c+":");
			if(max>=2000000) System.out.println("Send Kurdy\n");
			else System.out.printf("%.4f\n\n", max);
		}

	}
}
