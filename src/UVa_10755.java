import java.util.Scanner;


public class UVa_10755 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			long[][][] grid = new long[a][b][c];
			boolean allneg = true;
			long largest = Long.MIN_VALUE;
			for(int i=0; i<a; i++){
				for(int j=0; j<b; j++)
					for(int k=0; k<c; k++) {
						grid[i][j][k] = sc.nextLong();
						allneg&=grid[i][j][k]<0;
						largest = Math.max(largest, grid[i][j][k]);
						if(j>0) grid[i][j][k]+=grid[i][j-1][k];
						if(k>0) grid[i][j][k]+=grid[i][j][k-1];
						if(j>0 && k>0) grid[i][j][k]-=grid[i][j-1][k-1];
					}
			}
			if(allneg) System.out.println(largest);
			else {
				long best = Long.MIN_VALUE;
				for(int i=0; i<b; i++)
					for(int j=i; j<b; j++)
						for(int k=0; k<c; k++)
							for(int l=k; l<c; l++){
								long sum = 0;
								long max = Long.MIN_VALUE;
								for(int m=0; m<a; m++){
									sum+=slice(grid[m], i, j, k, l);
									max = Math.max(max, sum);
									if(sum<0) sum = 0;
								}
								best = Math.max(best, max);
							}
				System.out.println(best);
			}
			if(tc>0) System.out.println();
		}
	}
	
	static long slice(long[][] grid, int r1, int r2, int c1, int c2){
		if(r1==0 && c1==0) return grid[r2][c2];
		else if(r1==0) return grid[r2][c2]-grid[r2][c1-1];
		else if(c1==0) return grid[r2][c2]-grid[r1-1][c2];
		else return grid[r2][c2]-grid[r2][c1-1]-grid[r1-1][c2]+grid[r1-1][c1-1];
	}
}
