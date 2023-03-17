

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVa_532 {
    static char[][][] grid;
    static int[][][] gridInt;
    static int nLevels;
    static int nRows;
    static int nCols;
    static Queue<Point> points;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            points = new LinkedList();
            StringTokenizer st = new StringTokenizer(br.readLine());
            nLevels = new Integer(st.nextToken());
            nRows = new Integer(st.nextToken());
            nCols = new Integer(st.nextToken());
            if(nLevels==0 && nRows==0 && nCols==0) break;
            
            grid = new char[nLevels][nRows][nCols];
            gridInt = new int[nLevels][nRows][nCols];
            
            int startLevel = 0;
            int startRow = 0;
            int startCol = 0;
            
            int endLevel = 0;
            int endRow = 0;
            int endCol = 0;
            
            for(int i=0; i<nLevels; i++){
                for(int j=0; j<nRows; j++){
                    grid[i][j] = br.readLine().toCharArray();
                    for(int k=0; k<nCols; k++){
                        if(grid[i][j][k]=='#') gridInt[i][j][k] = Integer.MAX_VALUE;
                        else gridInt[i][j][k] = 0;
                        if(grid[i][j][k]=='S'){
                            startLevel = i;
                            startRow = j;
                            startCol = k;
                        } else if(grid[i][j][k]=='E'){
                            endLevel = i;
                            endRow = j;
                            endCol = k;
                        }
                    }
                }
                br.readLine();
            }
            
            points.add(new Point(startLevel, startRow, startCol));
            while(!points.isEmpty()){
                Point cur = points.poll();
                bfs(cur.level, cur.row, cur.col);
                if(cur.level==endLevel && cur.row==endRow && cur.col==endCol) break;
            }
            if(gridInt[endLevel][endRow][endCol]==0) sb.append("Trapped!\n");
            else sb.append("Escaped in "+gridInt[endLevel][endRow][endCol]+" minute(s).\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int level, int row, int col) {
        if(col-1>=0){
            if(grid[level][row][col-1]!='#'){
                gridInt[level][row][col-1] = gridInt[level][row][col]+1;
                points.add(new Point(level, row, col-1));
                grid[level][row][col-1]='#';
            }
        }
        
        // go right
        if(col+1<nCols){
            if(grid[level][row][col+1]!='#'){
                gridInt[level][row][col+1] = gridInt[level][row][col]+1;
                points.add(new Point(level, row, col+1));
                grid[level][row][col+1]='#';
            }
        }
        
        // go up (same level)
        if(row-1>=0){
            if(grid[level][row-1][col]!='#'){
                gridInt[level][row-1][col] = gridInt[level][row][col]+1;
                points.add(new Point(level, row-1, col));
                grid[level][row-1][col]='#';
            }
        }
        
        // go down (same level)
        if(row+1<nRows){
            if(grid[level][row+1][col]!='#'){
                gridInt[level][row+1][col] = gridInt[level][row][col]+1;
                points.add(new Point(level, row+1, col));
                grid[level][row+1][col]='#';
            }
        }
        
        // go up a level
        if(level-1>=0){
            if(grid[level-1][row][col]!='#'){
                gridInt[level-1][row][col] = gridInt[level][row][col]+1;
                points.add(new Point(level-1, row, col));
                grid[level-1][row][col]='#';
            }
        }
        
        // go down a level
        if(level+1<nLevels){
            if(grid[level+1][row][col]!='#'){
                gridInt[level+1][row][col] = gridInt[level][row][col]+1;
                points.add(new Point(level+1, row, col));
                grid[level+1][row][col]='#';
            }
        }
    }
    
    static class Point{
        int level;
        int row;
        int col;
        
        public Point(int l, int r, int c){
            level = l;
            row = r;
            col = c;
        }
    }
}
