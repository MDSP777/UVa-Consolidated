import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UVa_10944 {
	static int[] rIdx;
	static int[] cIdx;
	static int n;
	static int[][] memo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		rIdx = new int[20];
		cIdx = new int[20];
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split(" ");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			
			char[][] grid = new char[r][];
			for(int i=0; i<r; i++)
				grid[i] = br.readLine().toCharArray();
			
			n = 1;
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) {
					if(grid[i][j]=='L') {
						rIdx[0] = i;
						cIdx[0] = j;
					} else if(grid[i][j]=='#') {
						rIdx[n] = i;
						cIdx[n] = j;
						n++;
					}
				}
			
			memo = new int[n][1<<n];
			for(int i=0; i<n; i++)
				Arrays.fill(memo[i], -1);
			sb.append(dp(0, 1)).append("\n");
		}
		System.out.print(sb);
	}
	
	static int dp(int idx, int mask) {
		if(mask==(1<<n)-1)
			return dist(idx, 0);
		if(memo[idx][mask]!=-1) 
			return memo[idx][mask];
		
		int best = 10000000;
		for(int i=1; i<n; i++)
			if((mask & (1<<i))==0) 
				best = Math.min(best, dist(idx, i)+dp(i, mask | (1<<i)));
		
		return memo[idx][mask] = best;
	}
	
	static int dist(int i, int j) {
		int l1 = Math.abs(rIdx[i]-rIdx[j]);
		int l2 = Math.abs(cIdx[i]-cIdx[j]);
		
		return Math.max(l1, l2);
	}
}
