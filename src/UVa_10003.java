import java.util.Arrays;
import java.util.Scanner;

public class UVa_10003 {
	static int n, l;
	static int[] cuts;
	static int[][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			l = sc.nextInt();
			if(l==0) break;
			n = sc.nextInt();
			cuts = new int[n];
			for(int i=0; i<n; i++) cuts[i] = sc.nextInt();
			int ans = 10000000;
			memo = new int[n][n];
			for(int i=0; i<n; i++) Arrays.fill(memo[i], -1);
			for(int i=0; i<n; i++) ans = Math.min(ans, dp(0, i-1)+dp(i+1, n-1)+l);
			System.out.println("The minimum cutting is "+(n==0 ? 0 : ans)+".");
		}
	}

	private static int dp(int start, int end) {
		if(start>end) return 0;
		if(memo[start][end]!=-1) return memo[start][end];
		if(start==end) return (end==n-1 ? l : cuts[end+1])-(start==0 ? 0 : cuts[start-1]);
		int ans = 1000000;
		for(int i=start; i<=end; i++) ans = Math.min(ans, dp(start, i-1)+dp(i+1, end));
		memo[start][end] = ans+(end==n-1 ? l : cuts[end+1])-(start==0 ? 0 : cuts[start-1]);
		return memo[start][end];
	}
}
