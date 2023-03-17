import java.util.Scanner;

public class UVa_1240 {
	static int[][] problems;
	static int[][][] memo;
	static int n;
	
	static int dp(int p, int inactive, int timeLeft){
		if(timeLeft<=0) return 0;
		if(memo[p][inactive][timeLeft]!=-1) return memo[p][inactive][timeLeft];
		int ans = 0;
		for(int i=0; i<3; i++)
			if(i!=inactive)
				for(int j=0; j<n; j++)
					if((p&(1<<j))==0 && problems[i][j]<=timeLeft) ans = Math.max(ans, 1+dp(p|(1<<j), i, timeLeft-problems[i][j]));
		memo[p][inactive][timeLeft] = ans;
		return ans;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		memo = new int[1<<12][3][300];
		problems = new int[3][15];
		while(tc-->0){
			n = sc.nextInt();
			for(int i=0; i<3; i++)
				for(int j=0; j<n; j++) problems[i][j] = sc.nextInt();
			int ans = 0;
			int cap = 1<<n;
			for(int i=0; i<cap; i++)
				for(int j=0; j<3; j++)
					for(int k=0; k<300; k++) memo[i][j][k] = -1;
			for(int i=0; i<3; i++)
				for(int j=0; j<n; j++)
					if(problems[i][j]<=280) ans = Math.max(ans, 1+dp(1<<j, i, 280-problems[i][j]));
			System.out.println(ans);
		}
	}
}
