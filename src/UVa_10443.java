import java.util.Scanner;

public class UVa_10443 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		int[] iOffsets = {-1, 1,  0, 0};
		int[] jOffsets = {0,  0, -1, 1};
		while(nC-->0) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int n = sc.nextInt();
			char[][] grid = new char[r][c];
			for(int i=0; i<r; i++) grid[i] = sc.next().toCharArray();
			while(n-->0) {
				char[][] newGrid = new char[r][c];
				for(int i=0; i<r; i++) newGrid[i] = new String(grid[i]).toCharArray();
				for(int i=0; i<r; i++)
					for(int j=0; j<c; j++)
						for(int k=0; k<4; k++) {
							int newI = i+iOffsets[k];
							int newJ = j+jOffsets[k];
							if(newI>=0 && newI<r && newJ>=0 && newJ<c) {
								if(grid[i][j]=='R' && grid[newI][newJ]=='P') {
									newGrid[i][j] = 'P';
									break;
								} else if(grid[i][j]=='P' && grid[newI][newJ]=='S') {
									newGrid[i][j] = 'S';
									break;
								} else if(grid[i][j]=='S' && grid[newI][newJ]=='R') {
									newGrid[i][j] = 'R';
									break;
								}
							}
						}
				grid = newGrid;
			}
			for(int i=0; i<r; i++) System.out.println(grid[i]);
			if(nC>0) System.out.println();
		}
	}
}
