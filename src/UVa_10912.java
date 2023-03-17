import java.util.Arrays;
import java.util.Scanner;

public class UVa_10912 {
	static int[][][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		memo = new int[27][27][360];
		int t = 1;
		for(int i=0; i<27; i++)
			for(int j=0; j<27; j++) Arrays.fill(memo[i][j], -1);
		while(true){
			int l = sc.nextInt();
			int s = sc.nextInt();
			if(l==0 && s==0) break;
			System.out.println("Case "+t+++": "+dp('a'-1, l, s));
		}
	}
	
	static int dp(int c, int l, int s){
		if(s>351 || s<=0 || l>26) return 0;
		if(l==1) return s>(c-'a'+1) && s<=26 ? 1 : 0;
		if(memo[c-'a'+1][l][s]!=-1) return memo[c-'a'+1][l][s];
		int ans = 0;
		for(int i=c+1; i<='z'; i++) ans+=dp(i, l-1, s-(i-'a'+1));
		return memo[c-'a'+1][l][s] = ans;
	}
}
