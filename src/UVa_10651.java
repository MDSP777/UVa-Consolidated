import java.util.Arrays;
import java.util.Scanner;


public class UVa_10651 {
	static int[] memo;
	static int bound = 1<<12;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		memo = new int[1<<12];
		Arrays.fill(memo, -1);
		while(tc-->0){
			char[] s = sc.next().toCharArray();
			int mask = 0;
			for(int i=0; i<s.length; i++) if(s[i]=='o') mask|=(1<<i);
			System.out.println(dp(mask));
		}
	}
	
	static int dp(int mask){
		if(mask==0) return 0;
		if(memo[mask]!=-1) return memo[mask];
		int ans = 0;
		for(int i=0; i<12; i++) if((mask&(1<<i))!=0) ans++;
		for(int i=2; i<12; i++){
			int l = mask&(1<<(i-2));
			int m = mask&(1<<(i-1));
			int r = mask&(1<<i);
			if(l==0 && m!=0 && r!=0){
				int newMask = mask;
				newMask|=(1<<(i-2));
				newMask&=~(1<<(i-1));
				newMask&=~(1<<(i));
				ans = Math.min(ans, dp(newMask));
			}
			if(l!=0 && m!=0 && r==0){
				int newMask = mask;
				newMask|=(1<<(i));
				newMask&=~(1<<(i-1));
				newMask&=~(1<<(i-2));
				ans = Math.min(ans, dp(newMask));
			}
		}
		memo[mask] = ans;
		return ans;
	}
}
