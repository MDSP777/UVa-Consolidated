import java.util.Arrays;
import java.util.Scanner;


public class UVa_11420 {
	static long[][][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		memo = new long[2][70][70];
		for(int x=0; x<2; x++) 
			for(int i=0; i<70; i++) 
				Arrays.fill(memo[x][i], -1);
		while(true){
			int n = sc.nextInt();
			int s = sc.nextInt();
			if(n<0 && s<0) break;
			System.out.println(dp(0, n, s));
		}
	}
	
	static long dp(int unlocked, int n, int s){
		if(s>n || s<0) return 0;
		if(n==1) {
			if(unlocked==1) return s==0 ? 2 : 0;
			else return 1;
		}
		if(memo[unlocked][n][s]!=-1) return memo[unlocked][n][s];
		long ans = unlocked==0 ? dp(0, n-1, s-1)+dp(1, n-1, s) : dp(0, n-1, s)+dp(1, n-1, s);
		return memo[unlocked][n][s] = ans;
	}
}
