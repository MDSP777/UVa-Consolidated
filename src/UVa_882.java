import java.util.Scanner;


public class UVa_882 {
	static int[] sum;
	static int[][][] memo;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		sum = new int[101];
		for(int i=1; i<101; i++) sum[i] = sum[i-1]+i;
		int tc = sc.nextInt();
		memo = new int[11][101][101];
		for(int i=0; i<11; i++)
			for(int j=0; j<101; j++)
				for(int k=0; k<101; k++) memo[i][j][k] = -1;
		while(tc-->0){
			int k = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(dp(k, 1, m));
		}
	}
	
	static int dp(int boxLeft, int low, int high){
		if(low>high) return 1000000;
		if(boxLeft==1) return sum[high]-sum[low-1];
		if(low==high) return high;
		if(memo[boxLeft][low][high]!=-1) return memo[boxLeft][low][high];
		int ans = low+dp(boxLeft, low+1, high);
		for(int i=low; i<=high; i++) ans = Math.min(ans, Math.max(i+dp(boxLeft-1, low, i-1), i+dp(boxLeft, i+1, high)));
		memo[boxLeft][low][high] = ans;
		return ans;
	}
}
