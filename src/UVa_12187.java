import java.util.Scanner;

public class UVa_12187 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] rOffsets = {-1, 1, 0, 0};
		int[] cOffsets = {0, 0, -1, 1};
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			int r = sc.nextInt();
			int c = sc.nextInt();
			int w = sc.nextInt();
			int[][] grid = new int[r][c];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) grid[i][j] = sc.nextInt();
			while(w-->0) {
				int[][] newGrid = new int[r][c];
				for(int i=0; i<r; i++)
					for(int j=0; j<c; j++) newGrid[i][j] = grid[i][j];
				for(int i=0; i<r; i++)
					for(int j=0; j<c; j++)
						for(int k=0; k<4; k++) {
							int newR = i+rOffsets[k];
							int newC = j+cOffsets[k];
							if(newR>=0 && newR<r && newC>=0 && newC<c)
								if((grid[i][j]+1)%n==grid[newR][newC]) newGrid[newR][newC] = grid[i][j];
						}
				grid = newGrid;
			}
			for(int i=0; i<r; i++) {
				System.out.print(grid[i][0]);
				for(int j=1; j<c; j++) System.out.print(" "+grid[i][j]);
				System.out.println();
			}
		}
	}
}
