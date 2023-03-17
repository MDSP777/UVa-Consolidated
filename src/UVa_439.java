

import java.util.Scanner;

public class UVa_439 {
    static int xK[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int yK[] = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            
            String src = sc.next();
            String dest = sc.next();
            int aRow = src.charAt(0)-97;
            int aCol = src.charAt(1)-49;
            int bRow = dest.charAt(0)-97;
            int bCol = dest.charAt(1)-49;
            
            char[][] grid = new char[8][8];
            char nMoves = '0';
            grid[aRow][aCol] = '0';
            if(!(aRow==bRow && aCol==bCol)){
                while(grid[bRow][bCol]==0){
                    nMoves++;
                    for(int i=0; i<8; i++)
                        for(int j=0; j<8; j++){
                            if(grid[i][j]==nMoves-1){
                                for(int k=0; k<8; k++){
                                    int newRow = i+xK[k];
                                    int newCol = j+yK[k];
                                    if(newRow>=0 && newRow<8 && newCol>=0 && newCol<8)
                                        grid[newRow][newCol] = nMoves;
                                }
                            }
                        }
                }
            }
            
            System.out.println("To get from "+src+" to "+dest+" takes "+nMoves+" knight moves.");
        }while(sc.hasNext());
    }
}