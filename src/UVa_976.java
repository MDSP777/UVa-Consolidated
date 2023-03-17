import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;


public class UVa_976 {
	static int[] aEnds, bEnds, bridgeLens;
	static int r, c, gap;
	static int[] rOffsets = {-1, 1, 0, 0};
	static int[] cOffsets = {0, 0, -1, 1};
	static char[][] grid;
	static int[][] memo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split(" ");
			r = Integer.parseInt(split[0]);
			c = Integer.parseInt(split[1]);
			split = br.readLine().split(" ");
			int nBridges = Integer.parseInt(split[0]);
			gap = Integer.parseInt(split[1]);
			grid = new char[r][];
			for(int i=0; i<r; i++) grid[i] = br.readLine().toCharArray();
			
			aEnds = new int[c];
			bEnds = new int[c];
			Arrays.fill(bEnds, r-1);

			fill(0, 0, true);
			fill(r-1, 0, false);
			
			bridgeLens = new int[c];
			for(int i=0; i<c; i++)
				bridgeLens[i] = bEnds[i]-aEnds[i]-1;
			
			memo = new int[c][nBridges+1];
			for(int i=0; i<c; i++) Arrays.fill(memo[i], -1);
			System.out.println(dp(0, nBridges));
		}
	}
	
	static int dp(int index, int nBridges){
		if(nBridges==0) return 0;
		if(index>=c) return 1000000000;
		if(memo[index][nBridges]!=-1) return memo[index][nBridges];
		
		return memo[index][nBridges] = 
				Math.min(dp(index+1, nBridges), dp(index+gap+1, nBridges-1)+bridgeLens[index]);
		
	}
	
	static void fill(int startR, int startC, boolean isA){
		LinkedList<State> q = new LinkedList<>();
		q.add(new State(startR, startC));
		grid[startR][startC] = '.';
		while(!q.isEmpty()){
			State cur = q.poll();
			if(isA) aEnds[cur.c] = Math.max(aEnds[cur.c], cur.r);
			else bEnds[cur.c] = Math.min(bEnds[cur.c], cur.r);
			for(int i=0; i<4; i++){
				int newR = cur.r+rOffsets[i];
				int newC = cur.c+cOffsets[i];
				if(newR>=0 && newR<r && newC>=0 && newC<c && grid[newR][newC]=='#'){
					q.add(new State(newR, newC));
					grid[newR][newC] = '.';
				}
			}
		}
	}
	
	static class State {
		int r, c;
		
		State(int a, int b){
			r = a;
			c = b;
		}
	}
}
