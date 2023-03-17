

import java.util.Scanner;

public class UVa_10943 {
    static long[][] memo = new long[110][110];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int n = sc.nextInt();
        for(int i=0; i<101; i++)
            for(int j=0; j<101; j++) memo[i][j] = -1;
        for(int i=0; i<101; i++) memo[1][i] = 1;
        
        while(sum!=0 || n!=0){
            long total = dp(n, sum);
            System.out.println(total);
            sum = sc.nextInt();
            n = sc.nextInt();
        }
        
    }
    
    public static long dp(int n, int sum){
        long total=0;
        if(memo[n][sum]!=-1) return (memo[n][sum]%1000000);
        if(sum<0) return 0;
        else{
            for(int i=sum; i>=0; i--){
                total+=(dp(n-1, i)%1000000);
            }
            memo[n][sum] = total;
            //System.out.println(n+" "+sum+" "+total);
            return (total%1000000);
        }
    }
}
