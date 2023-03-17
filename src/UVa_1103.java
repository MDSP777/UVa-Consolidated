import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class UVa_1103 {
	static int[] rOffsets = {0, 0, -1, 1};
	static int[] cOffsets = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x = 1;
		String[] chars = {"W", "A", "K", "J", "S", "D"};
		while(true) {
			String[] split = br.readLine().split("\\s+");
			int r = Integer.parseInt(split[0]);
			if(r==0) break;
			int c = Integer.parseInt(split[1]);
			int[][] grid = new int[r][c*4];
			for(int i=0; i<r; i++) {
				char[] row = br.readLine().toCharArray();
				int ctr = 0;
				for(int j=0; j<c; j++) {
					int[] cur = convert(row[j]);
					for(int k=0; k<4; k++) grid[i][ctr++] = cur[k];
				}
			}
			for(int i=0; i<r; i++) {
				if(grid[i][0]==0) fillBG(grid, i, 0);
				if(grid[i][c*4-1]==0) fillBG(grid, i, c*4-1);
			}
			for(int i=0; i<c*4; i++) {
				if(grid[0][i]==0) fillBG(grid, 0, i);
				if(grid[r-1][i]==0) fillBG(grid, r-1, i);
			}
			ArrayList<String> ans = new ArrayList<>();
			for(int i=0; i<r; i++)
				for(int j=0; j<c*4; j++) 
					if(grid[i][j]==1) {
						int n = fill(grid, i, j);
						ans.add(chars[n]);
					}
			Collections.sort(ans);
			sb.append("Case ").append(x++).append(": ");
			for(String s: ans) sb.append(s);
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static void fillBG(int[][] grid, int r, int c) {
		LinkedList<Pair> q = new LinkedList<>();
		q.add(new Pair(r, c));
		grid[r][c] = -2;
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			for(int i=0; i<4; i++) {
				int newR = cur.r+rOffsets[i];
				int newC = cur.c+cOffsets[i];
				if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length && grid[newR][newC]==0) {
					q.add(new Pair(newR, newC));
					grid[newR][newC] = -2;
				}
			}
		}
	}
	
	static int fill(int[][] grid, int r, int c) {
		LinkedList<Pair> q = new LinkedList<>();
		q.add(new Pair(r, c));
		grid[r][c] = -1;
		int total = 0;
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			for(int i=0; i<4; i++) {
				int newR = cur.r+rOffsets[i];
				int newC = cur.c+cOffsets[i];
				if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length) 
					if(grid[newR][newC]==1) {
						q.add(new Pair(newR, newC));
						grid[newR][newC] = -1;
					} else if(grid[newR][newC]==0) {
						fillBG(grid, newR, newC);
						total++;
					}
			}
		}
		return total;
	}
	
	static int[] convert(char c) {
		switch(c) {
			case '0': return new int[]{0, 0, 0, 0};
			case '1': return new int[]{0, 0, 0, 1};
			case '2': return new int[]{0, 0, 1, 0};
			case '3': return new int[]{0, 0, 1, 1};
			case '4': return new int[]{0, 1, 0, 0};
			case '5': return new int[]{0, 1, 0, 1};
			case '6': return new int[]{0, 1, 1, 0};
			case '7': return new int[]{0, 1, 1, 1};
			case '8': return new int[]{1, 0, 0, 0};
			case '9': return new int[]{1, 0, 0, 1};
			case 'a': return new int[]{1, 0, 1, 0};
			case 'b': return new int[]{1, 0, 1, 1};
			case 'c': return new int[]{1, 1, 0, 0};
			case 'd': return new int[]{1, 1, 0, 1};
			case 'e': return new int[]{1, 1, 1, 0};
			case 'f': return new int[]{1, 1, 1, 1};
		}
		return null;
	}
	
	static class Pair {
		int r;
		int c;
		
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
