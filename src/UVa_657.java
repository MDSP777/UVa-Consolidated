

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_657 {
    static int total;
    static char[][] grid;
    static int row;
    static int col;
    static ArrayList<Integer> nums;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while(true){
            col = sc.nextInt();
            row = sc.nextInt();
            total = 0;
            if(col==0 && row==0) break;
            sc.nextLine();
            grid = new char[row][col];
            for(int i=0; i<row; i++)
                grid[i] = sc.nextLine().toCharArray();
            nums = new ArrayList();
            for(int i=0; i<row; i++)
                for(int j=0; j<col; j++){
                    if(grid[i][j]=='*'){
                        //total = 0;
                        cleanGrid(i, j);
                        if(total!=0)
                            nums.add(total);
                        total = 0;
                    } else if(grid[i][j]=='X'){
                        total++;
                        cleanSpot(i, j);
                        cleanGrid(i, j);
                        nums.add(total);
                        total = 0;
                    }
                }
            if(total!=0)
                nums.add(total);
            System.out.println("Throw "+n++);
            if(nums.isEmpty())
                System.out.println("\n");
            else{
                Collections.sort(nums);
                int l = nums.size()-1;
                for(int i=0; i<l; i++)
                    System.out.print(nums.get(i)+" ");
                System.out.println(nums.get(l)+"\n");
            }
        }
    }

    private static void cleanGrid(int i, int j) {
        grid[i][j] = '.';
        if(i>0){
            if(grid[i-1][j]=='*') cleanGrid(i-1, j);
            else if(grid[i-1][j]=='X'){
                total++;
                cleanSpot(i-1, j);
                cleanGrid(i-1, j);
            }
        }
        if(i<row-1){
            if(grid[i+1][j]=='*') cleanGrid(i+1, j);
            else if(grid[i+1][j]=='X'){
                total++;
                cleanSpot(i+1, j);
                cleanGrid(i+1, j);
            }
        }
        if(j>0){
            if(grid[i][j-1]=='*') cleanGrid(i, j-1);
            else if(grid[i][j-1]=='X'){
                total++;
                cleanSpot(i, j-1);
                cleanGrid(i, j-1);
            }
        }
        if(j<col-1){
            if(grid[i][j+1]=='*') cleanGrid(i, j+1);
            else if(grid[i][j+1]=='X'){
                total++;
                cleanSpot(i, j+1);
                cleanGrid(i, j+1);
            }
        }
    }

    private static void cleanSpot(int i, int j) {
        grid[i][j] = '*';
        if(i>0){
            if(grid[i-1][j]=='X') cleanSpot(i-1, j);
        }
        if(i<row-1){
            if(grid[i+1][j]=='X') cleanSpot(i+1, j);
        }
        if(j>0){
            if(grid[i][j-1]=='X') cleanSpot(i, j-1);
        }
        if(j<col-1){
            if(grid[i][j+1]=='X') cleanSpot(i, j+1);
        }
    }
}
