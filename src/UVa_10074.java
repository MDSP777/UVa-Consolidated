

import java.util.Scanner;

public class UVa_10074 {
    static int[][] rect;
    static int[][][][] memo;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int nRows = sc.nextInt();
            if(nRows==0) break;
            int nCols = sc.nextInt();

            rect = new int[nRows][nCols];
            for(int i=0; i<nRows; i++)
                for(int j=0; j<nCols; j++)
                    rect[i][j] = sc.nextInt();
            
            int larger = Math.max(nRows, nCols);
            memo = new int[larger+1][larger+1][larger+1][larger+1];
            for(int i=0; i<=larger; i++)
                for(int j=0; j<=larger; j++)
                    for(int k=0; k<=larger; k++)
                        for(int l=0; l<=larger; l++) memo[i][j][k][l] = Integer.MIN_VALUE;
            System.out.println(dp(0, nCols, 0, nRows));
        }
    }
    
    static int dp(int startJ, int endJ, int startI, int endI){
        int best = 0;
        if(startI>=endI || startJ>=endJ) return Integer.MIN_VALUE;
        if(memo[startJ][endJ][startI][endI]!= Integer.MIN_VALUE) return memo[startJ][endJ][startI][endI];
        boolean flag = false;
        for(int i=startI; i<endI; i++)
            for(int j=startJ; j<endJ; j++){
                best++;
                if(rect[i][j]==1){
                    best = Integer.MIN_VALUE;
                    flag = true;
                    break;
                }
                if(flag) break;
            }

        best = Math.max(best, dp(startJ, endJ, startI, endI-1));
        best = Math.max(best, dp(startJ, endJ-1, startI, endI));
        best = Math.max(best, dp(startJ, endJ, startI+1, endI));
        best = Math.max(best, dp(startJ+1, endJ, startI, endI));
        memo[startJ][endJ][startI][endI] = best;
        return best;
    }
}
