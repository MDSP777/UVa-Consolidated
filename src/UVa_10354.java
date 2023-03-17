import java.util.HashSet;
import java.util.Scanner;

public class UVa_10354 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int n = sc.nextInt();
			int r = sc.nextInt();
			int bh = sc.nextInt()-1;
			int of = sc.nextInt()-1;
			int yh = sc.nextInt()-1;
			int m = sc.nextInt()-1;
			int[][] adj1 = new int[n][n];
			int[][] adj2 = new int[n][n];
			int[][] next = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) if(i!=j) adj1[i][j] = adj2[i][j] = 2000000; else next[i][j] = i;
			while(r-->0) {
				int s = sc.nextInt()-1;
				int e = sc.nextInt()-1;
				int c = sc.nextInt();
				adj1[s][e] = adj1[e][s] = adj2[s][e] = adj2[e][s] = c;
				next[s][e] = e;
				next[e][s] = s;
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++)
						if(adj1[i][k]+adj1[k][j]<adj1[i][j]) {
							adj1[i][j] = adj1[i][k]+adj1[k][j];
							next[i][j] = next[i][k];
						}
			HashSet<Integer> bad = new HashSet<>();
			bad.add(bh);
			int cur = bh;
			while(next[cur][of]!=of) {
				bad.add(next[cur][of]);
				cur = next[cur][of];
			}
			bad.add(of);
			for(int k=0; k<n; k++) 
				if(adj1[bh][k]+adj1[k][of]==adj1[bh][of]) {
					cur = bh;
					while(next[cur][k]!=k) {
						bad.add(next[cur][k]);
						cur = next[cur][k];
					}
					bad.add(k);
					cur = k;
					while(next[cur][of]!=of) {
						bad.add(next[cur][of]);
						cur = next[cur][of];
					}
				}
			for(int i: bad) 
				for(int j=0; j<n; j++) adj2[i][j] = adj2[j][i] = 2000000;
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++)
						adj2[i][j] = Math.min(adj2[i][j], adj2[i][k]+adj2[k][j]);
			System.out.println(adj2[yh][m]==2000000 ? "MISSION IMPOSSIBLE." : adj2[yh][m]);
		} while(sc.hasNext());
	}
}
