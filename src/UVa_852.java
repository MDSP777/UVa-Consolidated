import java.util.Arrays;
import java.util.Scanner;


public class UVa_852 {
	static char[][] grid = new char[9][9];
	static boolean[][] visited = new boolean[9][9];
	static boolean hitW, hitB;
	static int[] rOffsets = {-1, 1, 0, 0};
	static int[] cOffsets = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			for(int i=0; i<9; i++) {
				grid[i] = sc.next().toCharArray();
				Arrays.fill(visited[i], false);
			}
			int bTotal = 0, wTotal = 0;
			for(int i=0; i<9; i++)
				for(int j=0; j<9; j++)
					if(grid[i][j]=='O') wTotal++;
					else if(grid[i][j]=='X') bTotal++;
					else if(!visited[i][j]){
						hitB = hitW = false;
						int size = fill(i, j);
						if(hitW && !hitB) wTotal+=size;
						else if(hitB && !hitW) bTotal+=size;
					}
			System.out.println("Black "+bTotal+" White "+wTotal);
		}
	}
	
	static int fill(int i, int j){
		visited[i][j] = true;
		int total = 1;
		for(int x=0; x<4; x++){
			int newR = i+rOffsets[x];
			int newC = j+cOffsets[x];
			if(newR>=0 && newR<9 && newC>=0 && newC<9){
				if(grid[newR][newC]=='O') hitW = true;
				else if(grid[newR][newC]=='X') hitB = true;
				else if(!visited[newR][newC]) total+=fill(newR, newC);
			}
		}
		return total;
	}
}
