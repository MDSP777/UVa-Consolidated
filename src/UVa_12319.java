import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_12319 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			int[][] adj1 = new int[n][n];
			int[][] adj2 = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++) adj1[i][j] = adj1[j][i] = adj2[i][j] = adj2[j][i] = 2000000;
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split("\\s+");
				for(int j=1; j<split.length; j++) adj1[i][Integer.parseInt(split[j])-1] = 1;
			}
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split("\\s+");
				for(int j=1; j<split.length; j++) adj2[i][Integer.parseInt(split[j])-1] = 1;
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++) {
						adj1[i][j] = Math.min(adj1[i][j], adj1[i][k]+adj1[k][j]);
						adj2[i][j] = Math.min(adj2[i][j], adj2[i][k]+adj2[k][j]);
					}
			String[] split = br.readLine().split("\\s+");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			boolean good = true;
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) good&=adj2[i][j]<=a*adj1[i][j]+b;
			System.out.println(good ? "Yes" : "No");
		}
	}
}
