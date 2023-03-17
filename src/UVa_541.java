

import java.util.Scanner;

public class UVa_541 {
    static int[][] grid;
    static int[] rowSums;
    static int[] colSums;
    static int n;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            n = sc.nextInt();
            if(n==0) break;
            grid = new int[n][n];
            rowSums = new int[n];
            colSums = new int[n];
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++){
                    grid[i][j] = sc.nextInt();
                    rowSums[i] += grid[i][j];
                    colSums[j] += grid[i][j];
                }
            if(allRowsEven() && allColsEven()) System.out.println("OK");
            else{
                boolean success = false;
                for(int i=0; i<n; i++){
                    if(success) break;
                    for(int j=0; j<n; j++){
                        grid[i][j] = Math.abs(grid[i][j]-1);
                        refreshSums();
                        if(allRowsEven() && allColsEven()){
                            success = true;
                            System.out.println("Change bit ("+(i+1)+","+(j+1)+")");
                            break;
                        }
                        grid[i][j] = Math.abs(grid[i][j]-1);
                        refreshSums();
                    }
                }
                if(!success) System.out.println("Corrupt");
            }
        }
    }

    private static boolean allRowsEven() {
        for(int i=0; i<rowSums.length; i++) if(rowSums[i]%2==1) return false;
        return true;
    }

    private static boolean allColsEven() {
        for(int i=0; i<colSums.length; i++) if(colSums[i]%2==1) return false;
        return true;
    }

    private static void refreshSums() {
        rowSums = new int[n];
        colSums = new int[n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++){
                rowSums[i] += grid[i][j];
                colSums[j] += grid[i][j];
            }
    }
}
