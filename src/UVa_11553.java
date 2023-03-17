import java.util.Arrays;
import java.util.Scanner;

public class UVa_11553 {
	static int n;
	static int[][] grid;
	static int[][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			n = sc.nextInt();
			grid = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) grid[i][j] = sc.nextInt();
			memo = new int[1<<n][1<<n];
			for(int i=0; i<(1<<n); i++) Arrays.fill(memo[i], -1);
			System.out.println(dp(0, 0));
		}
	}
	
	static int dp(int a, int b){
		if(a==(1<<n)-1 && b==(1<<n)-1) return 0;
		if(memo[a][b]!=-1) return memo[a][b];
		int ans = -1000000000;
		for(int i=0; i<n; i++)
			if((a&(1<<i)) == 0){
				int tempAns = 1000000000;
				for(int j=0; j<n; j++)
					if((b&(1<<j)) == 0)
						tempAns = Math.min(tempAns, grid[i][j]+dp(a|(1<<i), b|(1<<j)));
				ans = Math.max(ans, tempAns);
			}
		return memo[a][b] = ans;
	}
}
