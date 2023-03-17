

import java.util.Scanner;

public class UVa_10616 {
    static int[][] memo;
    static int[] list;
    static int[] ctr;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = 1;
        while(true){
            int size = sc.nextInt();
            int nQueries = sc.nextInt();
            if(size==0 && nQueries==0) break;
            
            list = new int[size];
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++){
                list[i] = sc.nextInt();
                max = Math.max(max, list[i]);
            }
            ctr = new int[max+1];
            for(int i=0; i<size; i++){
                ctr[list[i]]++;
            }
            
            memo = new int[21][11];
            for(int i=0; i<=20; i++)
                for(int j=0; j<=11; j++)
                    memo[i][j] = -1;
            
            System.out.println("SET "+nC+++":");
            for(int i=0; i<nQueries; i++) System.out.println("QUERY "+(i+1)+": "+dp(sc.nextInt(), sc.nextInt()));
        }

    }

    private static int dp(int d, int m) {
        if(d<=0 || m<=0) return 0;
        if(memo[d][m]!=-1) return memo[d][m];
        
        if(m==1){
            memo[d][m] = ctr[m];
            return ctr[m];
        } else {
            int total = 0;
            
            return total;
        }
    }
}
