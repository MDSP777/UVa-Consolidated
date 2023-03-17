import java.util.Scanner;


public class UVa_11951 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++){
			int r = sc.nextInt(), c = sc.nextInt(), budget = sc.nextInt();
			int[][] grid = new int[r][c];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) grid[i][j] = sc.nextInt();
			int[][] sums = new int[r][c];
			for(int i=0; i<r; i++){
				sums[i][0] = grid[i][0];
				for(int j=1; j<c; j++) sums[i][j] = sums[i][j-1]+grid[i][j];
			}
			long ans = 0, size = 0;
			for(int i=0; i<c; i++)
				for(int j=i; j<c; j++){
					long sum = 0;
					int left = 0;
					for(int k=0; k<r; k++){
						sum+=sums[k][j]-(i>0 ? sums[k][i-1] : 0);
						while(sum>budget){
							sum-=sums[left][j]-(i>0 ? sums[left][i-1] : 0);
							left++;
						}
						int area = (j-i+1)*(k-left+1);
						if(area>size){
							size = area;
							ans = sum;
						}
						if(area==size && sum<ans){
							ans = sum;
						}
					}
				}
			System.out.println("Case #"+t+": "+size+" "+ans);
		}
	}
}
