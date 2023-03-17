import java.util.Scanner;

public class UVa_10279 {
	static boolean touchedMine;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			touchedMine = false;
			int n = sc.nextInt();
			char[][] grid = new char[n][n];
			for(int i=0; i<n; i++) grid[i] = sc.next().toCharArray();
			for(int i=0; i<n; i++) clean(sc.next().toCharArray(), i, grid);
			if(!touchedMine) removeMines(grid);
			for(int i=0; i<n; i++) System.out.println(grid[i]);			
			if(nC>0) System.out.println();
		}
	}

	private static void removeMines(char[][] grid) {
		for(int i=0; i<grid.length; i++)
			for(int j=0; j<grid.length; j++) if(grid[i][j]=='*') grid[i][j] = '.';
	}

	private static void clean(char[] newArr, int r, char[][] grid) {
		for(int i=0; i<grid.length; i++)
			if(newArr[i]=='x') 
				if(grid[r][i]=='.') grid[r][i] = getMines(r, i, grid);
				else touchedMine = true;
	}

	private static char getMines(int r, int c, char[][] grid) {
		int[] rOffsets = {-1, -1, -1,  0, 0,  1, 1, 1};
    	int[] cOffsets = {-1,  0,  1, -1, 1, -1, 0, 1};
		int total = 0;
		for(int i=0; i<8; i++) {
			int newR = r+rOffsets[i];
			int newC = c+cOffsets[i];
			if(newR>=0 && newR<grid.length && newC>=0 && newC<grid.length) total += grid[newR][newC]=='*' ? 1 : 0;
		}
		return (char) (total+'0');
	}
}
