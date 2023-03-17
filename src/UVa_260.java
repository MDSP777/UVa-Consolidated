import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_260 {
	static int[] rOffsets = {-1, -1, 0, 0, 1, 1};
	static int[] cOffsets = {-1, 0, -1, 1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			char[][] grid = new char[n][n];
			for(int i=0; i<n; i++) grid[i] = br.readLine().toCharArray();
			boolean white = true;
			for(int i=0; i<n; i++)
				if(grid[i][0]=='w' && fill(grid, i, 0, 'w')) {
					white = true;
					break;
				} else if(grid[0][i]=='b' && fill(grid, 0, i, 'b')) {
					white = false;
					break;
				}
			System.out.println(x+++" "+(white ? "W" : "B"));
		}
	}
	
	static boolean fill(char[][] grid, int r, int c, char a) {
		grid[r][c] = 'x';
		if(a=='w' && c==grid.length-1) return true;
		if(a=='b' && r==grid.length-1) return true;
		boolean success = false;
		for(int i=0; i<6; i++) {
			int newR = r+rOffsets[i];
			int newC = c+cOffsets[i];
			if(newR>=0 && newR<grid.length && newC>=0 && newC<grid.length && grid[newR][newC]==a) success|=fill(grid, newR, newC, a);
		}
		return success;
	}
}
