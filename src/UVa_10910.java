import java.util.Arrays;
import java.util.Scanner;

public class UVa_10910 {
	static int p;
	static int[][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			int n = sc.nextInt();
			int t = sc.nextInt();
			p = sc.nextInt();
			memo = new int[n+1][t+1];
			for(int i=0; i<=n; i++) Arrays.fill(memo[i], -1);
			System.out.println(dp(n, t));
		}
	}
	
	static int dp(int n, int t){
		if(n*p>t) return 0;
		if(n==0) return t==0 ? 1 : 0;
		if(n==1) return 1;
		if(memo[n][t]!=-1) return memo[n][t];
		int ans = 0;
		for(int i=p; i<=t; i++) ans+=dp(n-1, t-i);
		return memo[n][t] = ans;
	}
}
