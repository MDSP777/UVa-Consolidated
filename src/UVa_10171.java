import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_10171 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int q = Integer.parseInt(br.readLine());
			if(q==0) break;
			int[][] youngAdj = new int[26][26];
			int[][] oldAdj = new int[26][26];
			for(int i=0; i<26; i++)
				for(int j=0; j<26; j++) if(i!=j) youngAdj[i][j] = oldAdj[i][j] = 2000000;
			while(q-->0) {
				String[] split = br.readLine().split(" ");
				int src = split[2].charAt(0)-'A';
				int dest = split[3].charAt(0)-'A';
				int[][] a = split[0].equals("Y") ? youngAdj : oldAdj;
				a[src][dest] = Math.min(Integer.parseInt(split[4]), a[src][dest]);
				if(split[1].equals("B")) a[dest][src] = a[src][dest];
			}
			String[] split = br.readLine().split(" ");
			for(int k=0; k<26; k++)
				for(int i=0; i<26; i++)
					for(int j=0; j<26; j++) {
						youngAdj[i][j] = Math.min(youngAdj[i][j], youngAdj[i][k]+youngAdj[k][j]);
						oldAdj[i][j] = Math.min(oldAdj[i][j], oldAdj[i][k]+oldAdj[k][j]);
					}
			int a = split[0].charAt(0)-'A';
			int b = split[1].charAt(0)-'A';
			int minCost = 1000000;
			for(int i=0; i<26; i++) minCost = Math.min(minCost, youngAdj[a][i]+oldAdj[b][i]);
			if(minCost==1000000) sb.append("You will never meet.\n");
			else {
				sb.append(minCost);
				for(int i=0; i<26; i++) if(youngAdj[a][i]+oldAdj[b][i]==minCost) sb.append(" ").append((char)(i+'A'));
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
