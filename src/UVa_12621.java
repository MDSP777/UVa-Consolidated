import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UVa_12621 {
	static int[][] memo;
	static int target, n, FAIL = 1_000_000_000;
	static ArrayList<Integer> v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			target = Integer.parseInt(br.readLine())/10;
			n = Integer.parseInt(br.readLine());
			v = new ArrayList<>();
			int total = 0;
			String[] split = br.readLine().split(" ");
			for(int i=0; i<n; i++){
				int x = Integer.parseInt(split[i])/10;
				total+=x;
				v.add(x);
			}
			if(total<target) sb.append("NO SOLUTION\n");
			else {
				Collections.sort(v);
				memo = new int[n][300];
				for(int i=0; i<n; i++) Arrays.fill(memo[i], -1);
				sb.append(dp(0, 0)*10).append("\n");
			}
		}
		System.out.print(sb);
	}
	
	static int dp(int idx, int eaten){
		if(idx==n-1) {
			if(eaten+v.get(n-1)<target) return FAIL;
			return eaten+v.get(n-1);
		}
		if(memo[idx][eaten]!=-1) return memo[idx][eaten];
		
		int ans = dp(idx+1, eaten);
		if(eaten+v.get(idx)<target) ans = Math.min(ans, dp(idx+1, eaten+v.get(idx)));
		else ans = Math.min(ans, eaten+v.get(idx));
		return memo[idx][eaten] = ans;
	}
}
