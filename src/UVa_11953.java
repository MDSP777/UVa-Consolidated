import java.util.Scanner;


public class UVa_11953 {
	static char[][] grid;
	static int[] rOffsets = {0, 0, -1, 1};
	static int[] cOffsets = {-1, 1, 0, 0};
	static int s;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++){
			s = sc.nextInt();
			grid = new char[s][s];
			for(int i=0; i<s; i++) grid[i] = sc.next().toCharArray();
			int ctr = 0;
			for(int i=0; i<s; i++)
				for(int j=0; j<s; j++)
					if(grid[i][j]!='.' && fill(i, j)) ctr++;
			System.out.println("Case "+t+": "+ctr);
		}
	}
	
	static boolean fill(int r, int c){
		boolean isAlive = grid[r][c]=='x';
		grid[r][c] = '.';
		for(int i=0; i<4; i++){
			int newR = r+rOffsets[i];
			int newC = c+cOffsets[i];
			if(newR>=0 && newR<s && newC>=0 && newC<s && grid[newR][newC]!='.')
				isAlive|=fill(newR, newC);
		}
		return isAlive;
	}
}
