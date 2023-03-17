import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_11360 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		for(int x=1; x<=nC; x++) {
			int n = Integer.parseInt(br.readLine());
			int[][] m = new int[n][n];
			for(int i=0; i<n; i++) {
				char[] row = br.readLine().toCharArray();
				for(int j=0; j<n; j++) m[i][j] = row[j]-'0';
			}
			int q = Integer.parseInt(br.readLine());
			while(q-->0) {
				String[] split = br.readLine().split("\\s+");
				if(split[0].equals("row")) swapRow(m, Integer.parseInt(split[1])-1, Integer.parseInt(split[2])-1);
				else if(split[0].equals("col")) swapCol(m, Integer.parseInt(split[1])-1, Integer.parseInt(split[2])-1);
				else if(split[0].equals("inc")) add(m, 1);
				else if(split[0].equals("dec")) add(m, -1);
				else m = transpose(m);
			}
			System.out.println("Case #"+x);
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) System.out.print(m[i][j]);
				System.out.println();
			}
			System.out.println();
		}
	}
	
	static void swapRow(int[][] grid, int r1, int r2) {
		for(int i=0; i<grid.length; i++) {
			int temp = grid[r1][i];
			grid[r1][i] = grid[r2][i];
			grid[r2][i] = temp;
		}
	}
	
	static void swapCol(int[][] grid, int c1, int c2) {
		for(int i=0; i<grid.length; i++) {
			int temp = grid[i][c1];
			grid[i][c1] = grid[i][c2];
			grid[i][c2] = temp;
		}
	}
	
	static void add(int[][] grid, int v) {
		for(int i=0; i<grid.length; i++)
			for(int j=0; j<grid.length; j++) {
				grid[i][j]+=v;
				if(grid[i][j]==10) grid[i][j] = 0;
				else if(grid[i][j]==-1) grid[i][j] = 9;
			}
	}
	
	static int[][] transpose(int[][] grid) {
		int[][] res = new int[grid.length][grid.length];
		for(int i=0; i<grid.length; i++)
			for(int j=0; j<grid.length; j++) res[j][i] = grid[i][j];
		return res;
	}
}
