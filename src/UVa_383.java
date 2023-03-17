import java.util.HashMap;
import java.util.Scanner;

public class UVa_383 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("SHIPPING ROUTES OUTPUT");
		int nC = sc.nextInt();
		for(int c=1; c<=nC; c++) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			int q = sc.nextInt();
			HashMap<String, Integer> map = new HashMap<>();
			int[][] adj = new int[n][n];
			for(int i=0; i<n; i++) {
				map.put(sc.next(), i);
				for(int j=i+1; j<n; j++) adj[i][j] = adj[j][i] = 2000000;
			}
			while(r-->0) {
				int s = map.get(sc.next());
				int d = map.get(sc.next());
				adj[s][d] = adj[d][s] = 1;
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
			System.out.println("\nDATA SET  "+c+"\n");
			while(q-->0) {
				int w = sc.nextInt();
				int s = map.get(sc.next());
				int d = map.get(sc.next());
				System.out.println(adj[s][d]==2000000 ? "NO SHIPMENT POSSIBLE" : "$"+(100*w*adj[s][d]));
			}
		}
		System.out.println("\nEND OF OUTPUT");
	}
}
