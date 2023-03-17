import java.util.Scanner;

public class UVa_572 {
    static int r, c;
    static char[][] grid;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
        	r = sc.nextInt();
            c = sc.nextInt();
            if(r==0 && c==0) break;
            long total = 0;
            grid = new char[r][c];
            for(int i=0; i<r; i++)
                grid[i] = sc.next().toCharArray();
            for(int i=0; i<r; i++)
                for(int j=0; j<c; j++)
                    if(grid[i][j]=='@'){
                        clean(i, j);
                        total++;
                    }
            System.out.println(total);
        }
    }
    
    public static void clean(int curR, int curC){
    	int[] rOffsets = {-1, -1, -1,  0, 0,  1, 1, 1};
    	int[] cOffsets = {-1,  0,  1, -1, 1, -1, 0, 1};
        grid[curR][curC] = '*';
        for(int i=0; i<8; i++) {
        	int newR = curR+rOffsets[i];
        	int newC = curC+cOffsets[i];
        	if(newR>=0 && newR<r && newC>=0 && newC<c && grid[newR][newC]=='@') clean(newR, newC);
        }
    }
}