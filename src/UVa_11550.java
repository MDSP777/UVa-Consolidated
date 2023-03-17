import java.util.Scanner;

public class UVa_11550 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			boolean[][] grid = new boolean[r][c];
			boolean[][] adj = new boolean[r][r];
			int[] colSums = new int[c];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) {
					grid[i][j] = sc.nextInt()==1;
					colSums[j]+=grid[i][j] ? 1 : 0;
				}
			boolean yes = true;
			for(int i=0; i<c; i++) 
				if(colSums[i]!=2) {
					yes = false;
					break;
				} else {
					int a = -1;
					int b = -1;
					for(int j=0; j<r; j++)
						if(grid[j][i]) {
							if(a==-1) a = j;
							else b = j;
						}
					if(adj[a][b]) {
						yes = false;
						break;
					} adj[a][b] = true;
				}
			System.out.println(yes ? "Yes" : "No");
		}
	}
}
