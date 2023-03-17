import java.util.Scanner;

public class UVa_1231 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			int n = sc.nextInt();
			int h = sc.nextInt();
			int f = sc.nextInt();
			int[][] acorn = new int[n][h+1];
			for(int i=0; i<n; i++){
				int l = sc.nextInt();
				for(int j=0; j<l; j++) acorn[i][sc.nextInt()]++;
			}
			int[] dp = new int[h+1];
			for(int i=0; i<n; i++) dp[h] = Math.max(dp[h], acorn[i][h]);
			for(int height=h-1; height>=0; height--)
				for(int tree=0; tree<n; tree++){
					acorn[tree][height]+=Math.max(acorn[tree][height+1], height+f<=h ? dp[height+f] : 0);
					dp[height] = Math.max(dp[height], acorn[tree][height]);
				}
			System.out.println(dp[0]);
		}
	}
}
