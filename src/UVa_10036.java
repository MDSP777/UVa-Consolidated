import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class UVa_10036 {
	static int[] terms;
	static int n, k;
	static int[][] memo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			String[] split = br.readLine().split(" ");
			n = Integer.parseInt(split[0]);
			k = Integer.parseInt(split[1]);
			split = br.readLine().split(" ");
			terms = new int[n];
			memo = new int[n][k];
			for(int i=0; i<n; i++) {
				terms[i] = Integer.parseInt(split[i]);
				Arrays.fill(memo[i], -1);
			}
			System.out.println(dp(0, 0)==1 ? "Divisible" : "Not divisible");
		}
	}
	
	static int dp(int index, int target){
		if(index==n-1){
			if(mod(terms[index], k)==target || mod(-terms[index], k)==target)
				return 1;
			return 0;
		}
		if(memo[index][target]!=-1) return memo[index][target];
		int ans = dp(index+1, mod(target-terms[index], k));
		if(ans==0) ans+=dp(index+1, mod(target+terms[index], k));
		return memo[index][target] = ans;
	}
	
	static int mod(int n, int k){
		int ans = n%k;
		if(ans<0) ans+=k;
		return ans;
	}
}
