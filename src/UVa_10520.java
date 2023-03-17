import java.util.Arrays;
import java.util.Scanner;

public class UVa_10520 {
	static long[][] memo;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			n = sc.nextInt();
			memo = new long[n+1][n+1];
			for(int i=0; i<=n; i++) Arrays.fill(memo[i], -1);
			memo[n][1] = sc.nextInt();
			System.out.println(dp(1, n));
		}while(sc.hasNext());
	}
	
	static long dp(int i, int j){
		if(memo[i][j]!=-1) return memo[i][j];
		long ans = -1;
		if(i<j){
			for(int k=i; k<j; k++) ans = Math.max(ans, dp(i, k)+dp(k+1, j)); 
		} else {
			long a = 0, b = 0;
			if(i<n)
				for(int k=i+1; k<=n; k++) a = Math.max(a, dp(k, 1)+dp(k, j));
			if(j>0)
				for(int k=1; k<j; k++) b = Math.max(b, dp(i, k)+dp(n, k));
			ans = a+b;
		}
		return memo[i][j] = ans;
	}
}
