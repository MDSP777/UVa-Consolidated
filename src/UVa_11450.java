

import java.util.Arrays;
import java.util.Scanner;

public class UVa_11450 {
    static int[][] garbs;
    static int[][] memo;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int x=0; x<cases; x++){
            int money = sc.nextInt();
            int nGarbs = sc.nextInt();
            memo = new int[money+1][nGarbs+1];
            for(int i=0; i<=nGarbs; i++) memo[0][i] = 0;
            for(int i=1; i<=money; i++)
                for(int j=0; j<=nGarbs; j++) memo[i][j] = -1;
            garbs = new int[nGarbs][];
            for(int i=0; i<nGarbs; i++){
                int s = sc.nextInt();
                garbs[i] = new int[s];
                for(int j=0; j<s; j++) garbs[i][j] = sc.nextInt();
            }
            int total = 0;
            for(int i=0; i<nGarbs; i++){
                Arrays.sort(garbs[i]);
                total+=garbs[i][0];
            }
            if(total>money) System.out.println("no solution");
            else System.out.println(dp(money, nGarbs, nGarbs));
        }
    }
    
    public static int dp(int money, int nGarbs, int totalGarbs){
        if(money<=0) return 0;
        if(nGarbs<=0) return money;
        if(memo[money][nGarbs]!=-1) return memo[money][nGarbs];
        if(nGarbs==1){
            int cur = totalGarbs-1;
            int best = Integer.MIN_VALUE;
            for(int i=0; i<garbs[cur].length; i++)
                if(garbs[cur][i]>best && money-garbs[cur][i]>=0) best = garbs[cur][i];
            memo[money][1] = best;
            return best;
        }
        int best = Integer.MIN_VALUE;
        int cur = totalGarbs-nGarbs;
        for(int i=0; i<garbs[cur].length; i++){
            int temp = garbs[cur][i] + dp(money-garbs[cur][i], nGarbs-1, totalGarbs);
            if(money-temp>=0)
                best = Math.max(best, temp);
        }
        memo[money][nGarbs] = best;
        return best;
    }
}
