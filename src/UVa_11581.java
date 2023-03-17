import java.util.Scanner;

public class UVa_11581 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-->0) {
			int[][] grid = new int[3][3];
			for(int i=0; i<3; i++) {
				char[] c = sc.next().toCharArray();
				for(int j=0; j<3; j++) grid[i][j] = c[j]-'0';
			}
			long ans = -1;
			while(sum(grid)>0) {
				grid = f(grid);
				ans++;
			}
			System.out.println(ans);
		}
	}
	
	static int[][] f(int[][] grid) {
		int[][] res = new int[3][3];
		int[] rOffsets = {0, 0, -1, 1};
		int[] cOffsets = {-1, 1, 0, 0};
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				for(int k=0; k<4; k++) {
					int newI = i+rOffsets[k];
					int newJ = j+cOffsets[k];
					if(newI>=0 && newI<3 && newJ>=0 && newJ<3) res[i][j] = (res[i][j]+grid[newI][newJ])%2;
				}
		return res;
	}
	
	static int sum(int[][] grid) {
		int total = 0;
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++) total+=grid[i][j];
		return total;
	}
}
