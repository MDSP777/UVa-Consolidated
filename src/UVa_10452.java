

import java.util.ArrayList;
import java.util.Scanner;

public class UVa_10452 {
    static char[][] grid;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=0; x<nC; x++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            grid = new char[r][];
            
            int startR = -1;
            int startC = -1;
            for(int i=0; i<r; i++){
                grid[i] = sc.next().toCharArray();
                for(int j=0; j<c; j++){
                   if(grid[i][j]=='@'){
                       startR = i;
                       startC = j;
                   } 
                }
            }
            
            ArrayList<String> ans = dfs(startR, startC, new ArrayList<String>());
            System.out.print(ans.get(0));
            for(int i=1; i<ans.size()/2; i++) System.out.print(" "+ans.get(i));
            System.out.println();
        }
    }

    private static ArrayList<String> dfs(int i, int j, ArrayList<String> moves) {
        if(grid[i][j]=='#') return moves;
        if(j!=0){
            if(grid[i][j-1]=='I' ||
                    grid[i][j-1]=='E' ||
                    grid[i][j-1]=='H' ||
                    grid[i][j-1]=='O' ||
                    grid[i][j-1]=='V' ||
                    grid[i][j-1]=='A' ||
                    grid[i][j-1]=='#'){
                moves.add("left");
                grid[i][j] = '.';
                ArrayList<String> newArr = (ArrayList<String>) moves.clone();
                ArrayList<String> rem = dfs(i, j-1, newArr);
                if(!rem.contains("dead")){
                    rem.add(0, "left");
                    return rem;
                }
                moves.remove(moves.size()-1);
            } 
        }
        if(j<grid[0].length-1){
            if(grid[i][j+1]=='I' ||
                    grid[i][j+1]=='E' ||
                    grid[i][j+1]=='H' ||
                    grid[i][j+1]=='O' ||
                    grid[i][j+1]=='V' ||
                    grid[i][j+1]=='A' ||
                    grid[i][j+1]=='#'){
                moves.add("right");
                grid[i][j] = '.';
                ArrayList<String> newArr = (ArrayList<String>) moves.clone();
                ArrayList<String> rem = dfs(i, j+1, newArr);
                if(!rem.contains("dead")){
                    rem.add(0, "right");
                    return rem;
                }
                moves.remove(moves.size()-1);
            } 
        }
        if(i!=0){
            if(grid[i-1][j]=='I' ||
                    grid[i-1][j]=='E' ||
                    grid[i-1][j]=='H' ||
                    grid[i-1][j]=='O' ||
                    grid[i-1][j]=='V' ||
                    grid[i-1][j]=='A' ||
                    grid[i-1][j]=='#'){
                moves.add("forth");
                grid[i][j] = '.';
                ArrayList<String> newArr = (ArrayList<String>) moves.clone();
                ArrayList<String> rem = dfs(i-1, j, newArr);
                if(!rem.contains("dead")){
                    rem.add(0, "forth");
                    return rem;
                }
            } 
        }
        moves.add("dead");
        return moves;
    }
}
