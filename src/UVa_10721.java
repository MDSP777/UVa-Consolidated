

import java.util.Scanner;

public class UVa_10721 {
    static long[][][] memo = new long[51][51][51];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<=50; i++)
            for(int j=0; j<=50; j++)
                for(int k=0; k<=50; k++)
                    memo[i][j][k] = -1;
        do{
            int n = sc.nextInt();
            int k = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(dp(n, k, m));
        }while(sc.hasNext());

    }

    private static long dp(int n, int k, int m) {
        if(n<=0 || k<=0 || m<=0) return 0;
        if(memo[n][k][m]!=-1) return memo[n][k][m];
        if(k>n || n>k*m) return 0;
        if(k*m==n || k==n || n==1 || (k==1 && n<=m)) return 1;
        long total=0;
        for(int i=1; i<=m; i++)
            total+=dp(n-i, k-1, m);
        memo[n][k][m] = total;
        return total;
    }
}
