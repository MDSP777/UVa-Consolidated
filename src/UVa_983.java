import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_983 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			int[][] grid = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					grid[i][j] = Integer.parseInt(br.readLine());
			long[][] out = new long[n-m+1][n-m+1];
			int[][] colSums = new int[n][n];
			for(int i=0; i<n; i++){
				colSums[i][0] = grid[0][i];
				for(int j=1; j<n; j++) colSums[i][j] = colSums[i][j-1]+grid[j][i];
			}
			long total = 0;
			long curLeft = 0;
			for(int i=0; i<n-m+1; i++){
				if(i==0) {
					for(int j=0; j<m; j++) {
						curLeft+=colSums[j][m-1];
					}
				} else {
					for(int j=0; j<m; j++){
						curLeft-=grid[i-1][j];
						curLeft+=grid[i+m-1][j];
					}
				}
				long cur = curLeft;
				out[i][0] = cur;
				total+=cur;
				sb.append(cur).append("\n");
				for(int j=1; j<n-m+1; j++){
					cur-=colSums[j-1][i+m-1]-(i==0 ? 0 : colSums[j-1][i-1]);
					cur+=colSums[j+m-1][i+m-1]-(i==0 ? 0 : colSums[j+m-1][i-1]);
					out[i][j] = cur;
					total+=cur;
					sb.append(cur).append("\n");
				}
			}
			sb.append(total).append("\n");
			String s = br.readLine();
			if(s==null || s.equals("END")) break;
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
