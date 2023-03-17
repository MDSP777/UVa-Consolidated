import java.util.Scanner;

public class UVa_567 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int x = 1;
		do {
			StringBuilder sb = new StringBuilder();
			int[][] adj = new int[20][20];
			for(int i=0; i<20; i++)
				for(int j=0; j<20; j++) if(i!=j) adj[i][j] = 2000000;
			for(int i=0; i<19; i++) {
				int e = sc.nextInt();
				while(e-->0) {
					int dest = sc.nextInt()-1;
					adj[i][dest] = adj[dest][i] = 1;
				}
			}
			for(int k=0; k<20; k++)
				for(int i=0; i<20; i++)
					for(int j=0; j<20; j++) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
			int q = sc.nextInt();
			sb.append("Test Set #").append(x++).append("\n");
			while(q-->0) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				sb.append(s<10 ? " ": "").append(s).append(" to ").append(e<10 ? " " : "").append(e).append(": ").append(adj[s-1][e-1]).append("\n");
			}
			System.out.println(sb);
		} while(sc.hasNext());
	}
}
