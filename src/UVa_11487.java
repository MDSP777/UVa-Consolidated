import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_11487 {
	static char[][] grid;
	static int n;
	static int[] rOffsets = {-1, 1, 0, 0};
	static int[] cOffsets = {0, 0, -1, 1};
	static int[][][][][] memo;
	
	public static void main(String[] args) {
		int t = 1;
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			if(n==0) break;
			grid = new char[n][];
			int letters = 0;
			for(int i=0; i<n; i++) {
				grid[i] = sc.next().toCharArray();
				for(int j=0; j<n; j++) 
					if(grid[i][j]>='A' && grid[i][j]<='Z') letters = Math.max(letters, grid[i][j]-'A'+1);
			}
			Point[] locs = new Point[letters];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					if(grid[i][j]>='A' && grid[i][j]<='Z') 
						locs[grid[i][j]-'A'] = new Point(i, j);
			int path = 0;
			int maxPathLen = 0;
			int[] pathLens = new int[letters];
			for(int curL=1; path>=0 && curL<letters; curL++) {
				int[][] depth = new int[n][n];
				for(int i=0; i<n; i++) Arrays.fill(depth[i], -1);
				depth[locs[curL-1].row][locs[curL-1].col] = 0;
				LinkedList<Point> q = new LinkedList<>();
				q.add(locs[curL-1]);
				while(!q.isEmpty() && depth[locs[curL].row][locs[curL].col]==-1) {
					Point cur = q.poll();
					for(int x=0; depth[locs[curL].row][locs[curL].col]==-1 && x<4; x++) {
						int newR = cur.row+rOffsets[x];
						int newC = cur.col+cOffsets[x];
						if(newR>=0 && newR<n && newC>=0 && newC<n 
								&& depth[newR][newC]==-1 
								&& (grid[newR][newC]=='.' || 
									(grid[newR][newC]>='A' && grid[newR][newC]<=grid[locs[curL].row][locs[curL].col]))) {
							depth[newR][newC] = depth[cur.row][cur.col]+1;
							q.add(new Point(newR, newC));
						}
					}
				}
				if(depth[locs[curL].row][locs[curL].col]==-1) path = -1;
				else {
					pathLens[curL] = depth[locs[curL].row][locs[curL].col];
					maxPathLen = Math.max(maxPathLen, pathLens[curL]);
					path+=depth[locs[curL].row][locs[curL].col];
				}
			}
			if(path==-1) System.out.println("Case "+t+++": Impossible");
			else {
				memo = new int[10][10][10][10][maxPathLen+1];
				for(int i=0; i<10; i++)
					for(int j=0; j<10; j++)
						for(int k=0; k<10; k++)
							for(int l=0; l<10; l++) Arrays.fill(memo[i][j][k][l], -1);
				int total = 1;
				for(int i=1; i<letters; i++) {
					total*=dp(locs[i-1], locs[i], pathLens[i]);
					total%=20437;
				}
				System.out.println("Case "+t+++": "+path+" "+total);
			}
		}
	}
	
	static int dp(Point cur, Point dest, int len) {
		if(len==0) return (cur.row==dest.row && cur.col==dest.col) ? 1 : 0;
		if(memo[cur.row][cur.col][dest.row][dest.col][len]!=-1) return memo[cur.row][cur.col][dest.row][dest.col][len];
		int ans = 0;
		for(int x=0; x<4; x++) {
			int newR = cur.row+rOffsets[x];
			int newC = cur.col+cOffsets[x];
			if(newR>=0 && newR<n && newC>=0 && newC<n 
					&& (grid[newR][newC]=='.' || 
						(grid[newR][newC]>='A' && grid[newR][newC]<=grid[dest.row][dest.col]))) {
				ans+=dp(new Point(newR, newC), dest, len-1);
			}
		}
		return memo[cur.row][cur.col][dest.row][dest.col][len] = ans;
	}
	
	static class Point {
		int row, col;
		
		Point(int a, int b){
			row = a;
			col = b;
		}
	}
}
