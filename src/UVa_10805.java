import java.util.Scanner;

public class UVa_10805 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		for(int curC=1; curC<=nC; curC++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] adj = new int[n+m][n+m];
			for(int i=0; i<n+m; i++)
				for(int j=i+1; j<n+m; j++) adj[i][j] = adj[j][i] = 20000000;
			int size = n;
			while(m-->0){
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a][size] = adj[size][a] = adj[size][b] = adj[b][size++] = 1;
			}
			for(int k=0; k<size; k++)
				for(int i=0; i<size; i++)
					for(int j=0; j<size; j++) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
			int ans = 20000000;
			for(int i=0; i<size; i++){
				int first = 0;
				int second = 0;
				for(int j=0; j<n; j++)
					if(adj[i][j]>=first){
						second = first;
						first = adj[i][j];
					} else if(adj[i][j]>second) second = adj[i][j];	
				ans = Math.min(ans, first+second);
			}
			System.out.println("Case #"+curC+":\n"+(ans/2)+"\n");
		}
	}
}
