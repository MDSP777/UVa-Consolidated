import java.util.Scanner;

public class UVa_423 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] adj = new int[n][n];
		for(int i=1; i<n; i++)
			for(int j=0; j<i; j++) {
				String s = sc.next();
				if(s.equals("x")) adj[i][j] = adj[j][i] = 2000000;
				else adj[i][j] = adj[j][i] = Integer.parseInt(s);
			}
		for(int k=0; k<n; k++)
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
		int max = 0;
		for(int i=0; i<n; i++) max = Math.max(max, adj[0][i]);
		System.out.println(max);
	}
}
