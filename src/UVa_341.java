import java.util.ArrayList;
import java.util.Scanner;

public class UVa_341 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int x = 1;
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			int[][] adj = new int[n][n];
			int[][] next = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) if(i!=j) adj[i][j] = 2000000; else next[i][j] = j;
			for(int i=0; i<n; i++) {
				int nE = sc.nextInt();
				while(nE-->0) {
					int e = sc.nextInt()-1;
					int cost = sc.nextInt();
					adj[i][e] = cost;
					next[i][e] = e;
				}
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++)
						if(adj[i][k]+adj[k][j]<adj[i][j]) {
							adj[i][j] = adj[i][k]+adj[k][j];
							next[i][j] = next[i][k];
						}
			int s = sc.nextInt()-1;
			int e = sc.nextInt()-1;
			int minCost = adj[s][e];
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(s+1);
			while(next[s][e]!=e) {
				ans.add(next[s][e]+1);
				s = next[s][e];
			}
			ans.add(e+1);
			sb.append("Case ").append(x++).append(": Path =");
			for(int i=0; i<ans.size(); i++) sb.append(" ").append(ans.get(i));
			sb.append("; ").append(minCost).append(" second delay\n");
		}
		System.out.print(sb);
	}
}
