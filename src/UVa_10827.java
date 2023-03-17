import java.util.Arrays;
import java.util.Scanner;

public class UVa_10827 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			int max = -1000000000;
			int n = sc.nextInt();
			int[][] grid = new int[2*n-1][2*n-1];
			boolean allneg = true;
			int l = -1000000000;
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) {
					grid[i][j] = sc.nextInt();
					allneg &= grid[i][j]<0;
					l = Math.max(l, grid[i][j]);
				}
			if(allneg){
				System.out.println(l);
				continue;
			}
			for(int i=0; i<n; i++){
				for(int j=0; j<n-1; j++) {
					grid[i][n+j] = grid[i][j];
					grid[n+j][i] = grid[j][i];
				}
			}
			for(int i=0; i<n-1; i++)
				for(int j=0; j<n-1; j++) grid[i+n][j+n] = grid[i][j];
			int[][] sums = new int[2*n-1][2*n-1];
			for(int i=0; i<2*n-1; i++){
				sums[i][0] = grid[i][0];
				for(int j=1; j<2*n-1; j++) sums[i][j] = sums[i][j-1]+grid[i][j];
			}
			for(int i=0; i<2*n-1; i++)
				for(int j=i; j<2*n-1; j++){
					if(j-i<=n-1){
//						int sum = 0;
//						int ctr = 0;
//						for(int k=0; k<2*n-1; k++){
//							if(ctr==n){
//								ctr--;
//								sum-=sums[k-n][j]-(i==0 ? 0 : sums[k-n][i-1]);
//								max = Math.max(max, sum);
//							}
//							sum+=sums[k][j]-(i==0 ? 0 : sums[k][i-1]);
//							ctr++;
//							if(sum<0){
//								sum = 0;
//								ctr = 0;
//							}
//							max = Math.max(max, sum);
//						}
						for(int k=0; k<2*n-1; k++){
							int sum = 0;
							for(int m=k; m<2*n-1; m++)
								if(m-k<=n-1){
									sum+=sums[m][j]-(i==0 ? 0 : sums[m][i-1]);
									max = Math.max(max, sum);
								}
						}
					}
				}
			System.out.println(max);
		}
	}
}
