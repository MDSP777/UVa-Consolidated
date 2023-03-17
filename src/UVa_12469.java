import java.util.Scanner;


public class UVa_12469 {
	static int[][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		memo = new int[1001][1001];
		for(int i=0; i<1001; i++)
			for(int j=0; j<1001; j++) memo[i][j] = -1;
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			System.out.println(dp(n, 0)==1 ? "Alicia" : "Roberto");
		}
	}
	
	static int dp(int remStones, int lastMove){
		if(remStones<=2*lastMove) return 1;
		if(memo[remStones][lastMove]!=-1) return memo[remStones][lastMove];
		boolean win = false;
		if(lastMove==0){
			for(int i=1; !win && i<remStones; i++) win|=dp(remStones-i, i)==0;
		} else {
			for(int i=1; !win && i<=lastMove*2; i++) win|=dp(remStones-i, i)==0;
		}
		memo[remStones][lastMove] = win ? 1 : 0;
		return memo[remStones][lastMove];
	}
}
