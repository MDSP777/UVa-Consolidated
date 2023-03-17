import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class UVa_11624 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		int[] rOffsets = {-1, 1,  0, 0};
		int[] cOffsets = { 0, 0, -1, 1};
		while(nC-->0) {
			String[] split = br.readLine().split(" ");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			int startR = 0;
			int startC = 0;
			char[][] grid = new char[r][];
			for(int i=0; i<r; i++) grid[i] = br.readLine().toCharArray();
			LinkedList<State> q = new LinkedList<>();
			boolean[][] used = new boolean[r][c];
			int[][] minFire = new int[r][c];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) {
					minFire[i][j] = 10000000;
					if(grid[i][j]=='F') {
						q.add(new State(i, j, 0));
						used[i][j] = true;
					}
					if(grid[i][j]=='J') {
						startR = i;
						startC = j;
					}
				}
			while(!q.isEmpty()) {
				State cur = q.poll();
				minFire[cur.r][cur.c] = cur.depth;
				for(int i=0; i<4; i++) {
					int newR = cur.r+rOffsets[i];
					int newC = cur.c+cOffsets[i];
					if(newR>=0 && newR<r && newC>=0 && newC<c) {
						if(grid[newR][newC]=='.' && !used[newR][newC]) {
							q.add(new State(newR, newC, cur.depth+1));
							used[newR][newC] = true;
						}
					}
				}
			}
			used = new boolean[r][c];
			used[startR][startC] = true;
			q.add(new State(startR, startC, 0));
			int ans = Integer.MAX_VALUE;
			if(startR==0 || startR==r-1 || startC==0 || startC==c-1) ans = 1;
			else {
				boolean found = false;
				while(!q.isEmpty()) {
					State cur = q.poll();
					for(int i=0; i<4; i++) {
						int newR = cur.r+rOffsets[i];
						int newC = cur.c+cOffsets[i];
						if(newR>=0 && newR<r && newC>=0 && newC<c) {
							if(grid[newR][newC]=='.' && !used[newR][newC] && cur.depth+1<minFire[newR][newC]) {
								if(newR==0 || newR==r-1 || newC==0 || newC==c-1) {
									ans = cur.depth+2;
									found = true;
									break;
								}
								q.add(new State(newR, newC, cur.depth+1));
								used[newR][newC] = true;
							}
						}
					}
					if(found) break;
				}
			}
			sb.append(ans==Integer.MAX_VALUE ? "IMPOSSIBLE" : ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static class State {
		int r;
		int c;
		int depth;
		
		public State(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
	}
}
