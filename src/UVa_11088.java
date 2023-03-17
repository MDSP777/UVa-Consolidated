import java.util.Arrays;
import java.util.Scanner;

public class UVa_11088 {
	static int n, bound;
	static int[] vals, memo;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(true){
			n = sc.nextInt();
			if(n==0) break;
			bound = 1<<n;
			vals = new int[n];
			for(int i=0; i<n; i++) vals[i] = sc.nextInt();
			memo = new int[bound];
			Arrays.fill(memo, -1);
			System.out.println("Case "+t+++": "+dp(0));
		}
	}
	
	static int dp(int mask){
		if(mask==bound-1) return 0;
		if(memo[mask]!=-1) return memo[mask];
		int ans = 0;
		for(int i=0; i<n; i++)
			for(int j=i+1; j<n; j++)
				for(int k=j+1; k<n; k++)
					if((mask&(1<<i))==0 && (mask&(1<<j))==0 && (mask&(1<<k))==0 && vals[i]+vals[j]+vals[k]>=20) {
						int newMask = mask;
						newMask|=(1<<i);
						newMask|=(1<<j);
						newMask|=(1<<k);
						ans = Math.max(ans, 1+dp(newMask));
					}
		memo[mask] = ans;
		return ans;
	}
}
