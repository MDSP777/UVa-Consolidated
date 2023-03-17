import java.io.BufferedReader;
import java.io.InputStreamReader;


public class UVa_10536 {
	static int[] memo;
	static int bound = 1<<16;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		memo = new int[bound];
		for(int i=0; i<bound; i++) memo[i] = -1;
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			br.readLine();
			int mask = 0;
			for(int i=0; i<4; i++){
				char[] c = br.readLine().toCharArray();
				for(int j=0; j<4; j++)
					if(c[j]=='X') mask|=(1<<(i*4+j));
			}
			sb.append(dp(mask)==1 ? "WINNING\n" : "LOSING\n");
		}
		System.out.print(sb);
	}
	
	static int dp(int mask){
		if(mask==bound-1) return 1;
		if(memo[mask]!=-1) return memo[mask];
		char[][] grid = reconstruct(mask);
		boolean win = false;
		for(int i=0; i<4 && !win; i++)
			for(int j=0; j<4 && !win; j++)
				if(grid[i][j]=='.' && !win) win|=dp(mask | (1<<(i*4+j)))==0;
		for(int i=0; i<4 && !win; i++){
			if(grid[i][0]=='.' && grid[i][1]=='.'){
				int newMask = mask;
				newMask|=(1<<(i*4));
				newMask|=(1<<(i*4+1));
				win|=dp(newMask)==0;
				if(!win && grid[i][2]=='.'){
					newMask|=(1<<(i*4+2));
					win|=dp(newMask)==0;
				}
			}
			if(grid[i][3]=='.' && grid[i][2]=='.'){
				int newMask = mask;
				newMask|=(1<<(i*4+3));
				newMask|=(1<<(i*4+2));
				win|=dp(newMask)==0;
				if(!win && grid[i][1]=='.'){
					newMask|=(1<<(i*4+1));
					win|=dp(newMask)==0;
				}
			}
			if(grid[0][i]=='.' && grid[1][i]=='.'){
				int newMask = mask;
				newMask|=(1<<(i));
				newMask|=(1<<(4+i));
				win|=dp(newMask)==0;
				if(!win && grid[2][i]=='.'){
					newMask|=(1<<(8+i));
					win|=dp(newMask)==0;
				}
			}
			if(grid[3][i]=='.' && grid[2][i]=='.'){
				int newMask = mask;
				newMask|=(1<<(12+i));
				newMask|=(1<<(8+i));
				win|=dp(newMask)==0;
				if(!win && grid[1][i]=='.'){
					newMask|=(1<<(4+i));
					win|=dp(newMask)==0;
				}
			}
		}
		memo[mask] = win ? 1 : 0;
		return memo[mask];
	}
	
	static char[][] reconstruct(int mask){
		char[][] grid = new char[4][4];
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
				grid[i][j] = (mask & (1<<(i*4+j)))==0 ? '.' : 'X';
		return grid;
	}
}
