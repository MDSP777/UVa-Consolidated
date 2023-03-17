import java.util.HashMap;
import java.util.Scanner;

public class UVa_10111 {
	static HashMap<State, Integer> memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		memo = new HashMap<>();
		while(true){
			String s = sc.next();
			if(s.equals("$")) break;
			char[][] grid = new char[4][];
			for(int i=0; i<4; i++) grid[i] = sc.next().toCharArray();
			boolean win = false;
			String ans = "#####";
			for(int i=0; !win && i<4; i++)
				for(int j=0; !win && j<4; j++)
					if(grid[i][j]=='.'){
						grid[i][j] = 'x';
						if(yes(grid, false)==-1){
							win = true;
							ans = "("+i+","+j+")";
						}
						grid[i][j] = '.';
					}
			
			System.out.println(ans);
		}
	}
	
	static int e(char[][] grid){
		int ans = 0;
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++){
				ans*=3;
				ans+=grid[i][j]=='.' ? 0 : grid[i][j]=='o' ? 1 : 2;
			}
		return ans;
	}
	
	static int yes(char[][] grid, boolean xPlay){
		if(hasWin(grid, !xPlay)) return -1;
		if(boardFull(grid)) return 0;
		State st = new State(e(grid), xPlay);
		if(memo.containsKey(st)) return memo.get(st);
		boolean oppWin = true;
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
				if(grid[i][j]=='.'){
					grid[i][j] = xPlay ? 'x' : 'o';
					int res = yes(grid, !xPlay);
					if(res==-1) {
						grid[i][j] = '.';
						memo.put(st, 1);
						return 1;
					}
					oppWin&=res==1;
					grid[i][j] = '.';
				}
		int ans = oppWin ? -1 : 0;
		memo.put(st, ans);
		return ans;
	}
	
	static boolean boardFull(char[][] grid){
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++) if(grid[i][j]=='.') return false;
		return true;
	}
	
	static boolean hasWin(char[][] grid, boolean x){
		char c = x ? 'x' : 'o';
		for(int i=0; i<4; i++){
			if(grid[i][0]==grid[i][1] && grid[i][1]==grid[i][2] && grid[i][2]==grid[i][3] && grid[i][0]==c ||
					grid[0][i]==grid[1][i] && grid[1][i]==grid[2][i] && grid[2][i]==grid[3][i] && grid[0][i]==c) return true;
		}
		if(grid[0][0]==c && grid[0][0]==grid[1][1] && grid[1][1]==grid[2][2] && grid[2][2]==grid[3][3] ||
				grid[0][3]==c && grid[0][3]==grid[1][2] && grid[1][2]==grid[2][1] && grid[2][1]==grid[3][0]) return true;
		return false;
	}
	
	static char[][] copy(char[][] grid){
		char[][] n = new char[4][4];
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++) n[i][j] = grid[i][j];
		return n;
	}
	
	static class State{
		int val;
		boolean xPlay;
		
		State(int v, boolean x){
			val = v;
			xPlay = x;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + val;
			result = prime * result + (xPlay ? 1231 : 1237);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			State other = (State) obj;
			if (val != other.val)
				return false;
			if (xPlay != other.xPlay)
				return false;
			return true;
		}
	}
}
