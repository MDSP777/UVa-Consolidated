import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class UVa_10086 {
	static int[][][] costs;
	static int[] sizes;
	static int t1, t2, n;
	static int[] out;
	static int[][][] memo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] split = br.readLine().split(" ");
			t1 = Integer.parseInt(split[0]);
			t2 = Integer.parseInt(split[1]);
			if(t1==0 && t2==0) break;
			n = Integer.parseInt(br.readLine());
			costs = new int[2][n][];
			sizes = new int[n];
			for(int i=0; i<n; i++){
				int s = Integer.parseInt(br.readLine());
				sizes[i] = s;
				for(int j=0; j<2; j++){
					costs[j][i] = new int[s+1];
					split = br.readLine().split(" ");
					for(int k=0; k<s; k++)
						costs[j][i][k+1] = Integer.parseInt(split[k]);
				}
			}
			memo = new int[n][t1+1][t2+1];
			for(int j=0; j<n; j++)
				for(int i=0; i<=t1; i++)
					Arrays.fill(memo[j][i], -1);
			System.out.println(dp(0, 0, 0));
			int[] out = new int[n];
			int cur = memo[0][0][0];
			int index = 0, curT1 = 0, curT2 = 0;
			while(cur>0){
				for(int i=0; i<=sizes[index]; i++)
					if(curT1+i<=t1 && curT2+sizes[index]-i<=t2
						&& dp(index+1, curT1+i, curT2+sizes[index]-i)
							+costs[0][index][i]+costs[1][index][sizes[index]-i]==cur){
						cur-=costs[0][index][i]+costs[1][index][sizes[index]-i];
						out[index] = i;
						curT1+=i;
						curT2+=sizes[index]-i;
						index++;
						break;
					}
			}
			System.out.print(out[0]);
			for(int i=1; i<n; i++) System.out.print(" "+out[i]);
			System.out.println("\n");
		}
	}
	
	static int dp(int index, int curT1, int curT2){
		if(index==n) return curT1+curT2==t1+t2 ? 0 : 1000000000;
		if(memo[index][curT1][curT2]!=-1) return memo[index][curT1][curT2];
		int ans = 1000000000;
		for(int i=0; i<=sizes[index]; i++){
			if(curT1+i<=t1 && curT2+sizes[index]-i<=t2){
				int temp = dp(index+1, curT1+i, curT2+sizes[index]-i)
							+costs[0][index][i]+costs[1][index][sizes[index]-i];
				if(temp<ans){
					ans = temp;
				}
			}
		}
		return memo[index][curT1][curT2] = ans;
	}
}
