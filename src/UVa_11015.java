import java.util.HashMap;
import java.util.Scanner;

public class UVa_11015 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 1;
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0 && m==0) break;
			HashMap<Integer, String> map = new HashMap<>();
			int index = 0;
			for(int i=0; i<n; i++) map.put(index++, sc.next());
			int[][] adj = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++) adj[i][j] = adj[j][i] = 2000000;
			while(m-->0) {
				int src = sc.nextInt()-1;
				int dest = sc.nextInt()-1;
				int c = sc.nextInt();
				adj[src][dest] = adj[dest][src] = c;
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
			int min = Integer.MAX_VALUE;
			String ans = "";
			for(int i=0; i<n; i++) {
				int cur = 0;
				for(int j=0; j<n; j++) cur+=adj[i][j];
				if(cur<min) {
					min = cur;
					ans = map.get(i);
				}
			}
			System.out.println("Case #"+x+++" : "+ans);
		}
	}
}
