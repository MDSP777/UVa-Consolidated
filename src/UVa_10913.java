import java.util.Arrays;
import java.util.Scanner;

public class UVa_10913 {
	static int n;
	static int[][] grid;
	static int[][][][] memo;
	static boolean found;
	static int FAIL = -1000000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(true) {
			found = false;
			n = sc.nextInt();
			int k = sc.nextInt();
			if(n==0 && k==0) break;
			grid = new int[n][n];
			memo = new int[n][n][3][k+1];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) {
					grid[i][j] = sc.nextInt();
					for(int l=0; l<3; l++) Arrays.fill(memo[i][j][l], -1);
				}
			int ans = dp(0, 0, 1, grid[0][0]<0 ? k-1 : k)+grid[0][0];
			System.out.println("Case "+t+++": "+(found ? ans : "impossible"));
		}
	}
	
	static int dp(int curR, int curC, int dir, int nRem) {
		if(nRem<0) return FAIL;
		if(curR==n-1 && curC==n-1) {
			found = true;
			return 0;
		}
		if(memo[curR][curC][dir][nRem]!=-1) return memo[curR][curC][dir][nRem];
		int ans = FAIL;
		if(dir==0 || dir==2) {
			if(curC>0) 
				ans = Math.max(ans, dp(curR, curC-1, 0, grid[curR][curC-1]<0 ? nRem-1 : nRem)+grid[curR][curC-1]);
			
		}
		if(dir==1 || dir==2) {
			if(curC<n-1) 
				ans = Math.max(ans, dp(curR, curC+1, 1, grid[curR][curC+1]<0 ? nRem-1 : nRem)+grid[curR][curC+1]);
		}
		if(curR<n-1)
			ans = Math.max(ans, dp(curR+1, curC, 2, grid[curR+1][curC]<0 ? nRem-1 : nRem)+grid[curR+1][curC]);
		return memo[curR][curC][dir][nRem] = ans;
	}
}
