import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class UVa_196 {
	static int[][] memo;
	static String[][] grid;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			String[] split = br.readLine().split(" ");
			int c = Integer.parseInt(split[0]);
			int r = Integer.parseInt(split[1]);
			grid = new String[r][c];
			memo = new int[r][c];
			for(int i=0; i<r; i++) {
				grid[i] = br.readLine().split(" ");
				Arrays.fill(memo[i], -1);
			}
			for(int i=0; i<r; i++){
				sb.append(dp(i, 0));
				for(int j=1; j<c; j++) 
					sb.append(" ").append(dp(i, j));
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
	
	static int dp(int i, int j){
		if(memo[i][j]!=-1) return memo[i][j];
		if(grid[i][j].charAt(0)!='=') return memo[i][j] = Integer.parseInt(grid[i][j]);
		String[] split = grid[i][j].substring(1).split("\\+");
		int total = 0;
		for(String cur : split){
			int col = 0;
			while(cur.charAt(0)>='A' && cur.charAt(0)<='Z'){
				col*=26;
				col+=cur.charAt(0)-'A'+1;
				cur = cur.substring(1);
			}
			int row = Integer.parseInt(cur)-1;
			col--;
			total+=dp(row, col);
		}
		return memo[i][j] = total;
	}
}
