import java.util.Scanner;


public class UVa_702 {
	static long[][][] memo;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		memo = new long[2][23][23];
		for(int i=0; i<23; i++)
			for(int j=0; j<23; j++) memo[0][i][j] = memo[1][i][j] = -1;
		do {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==1 && m==1) System.out.println(1);
			else if(m==1) {
				for(int i=2; i<=n; i++){
					long ans = dp(1, i-2, n-i);
					if(ans>0) {
						System.out.println(ans);
						break;
					}
				}
			} else {
				System.out.println(dp(1, m-1, n-m));
			}
		}while(sc.hasNext());
	}
	
	// 0 - up, 1 - down
	static long dp(int dir, int shorter, int taller){
		if(shorter==0 && taller==0) return 1;
		if(dir==0 && taller==0 || dir==1 && shorter==0) return 0;
		if(memo[dir][shorter][taller]!=-1) return memo[dir][shorter][taller];
		long ans = 0;
		if(dir==1){
			for(int i=1; i<=shorter; i++)
				ans+=dp(0, i-1, shorter-i+taller);
		} else {
			for(int i=1; i<=taller; i++)
				ans+=dp(1, shorter+i-1, taller-i);
		}
		memo[dir][shorter][taller] = ans;
		return ans;
	}
}
