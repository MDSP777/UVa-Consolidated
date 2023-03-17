import java.util.LinkedList;
import java.util.Scanner;

public class UVa_10102 {
	static int n;
	static int[] rOffsets = { 0, 0, -1, 1};
	static int[] cOffsets = {-1, 1,  0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			n = sc.nextInt();
			char[][] grid = new char[n][];
			for(int i=0; i<n; i++) grid[i] = sc.next().toCharArray();
			int max = 0;
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					if(grid[i][j]=='1') max = Math.max(max, bfs(i, j, grid));
			System.out.println(max);
		} while(sc.hasNext());
		
		
	}
	
	static int bfs(int r, int c, char[][] grid) {
		boolean[][] visited = new boolean[n][n];
		LinkedList<State> q = new LinkedList<>();
		visited[r][c] = true;
		q.add(new State(r, c, 0));
		while(!q.isEmpty()) {
			State cur = q.poll();
			for(int i=0; i<4; i++) {
				int newR = cur.r+rOffsets[i];
				int newC = cur.c+cOffsets[i];
				if(newR>=0 && newR<n && newC>=0 && newC<n) {
					if(grid[newR][newC]=='3') return cur.depth+1;
					if(!visited[newR][newC]) {
						visited[newR][newC] = true;
						q.add(new State(newR, newC, cur.depth+1));
					}
				}
			}
		}
		return 0;
	}
	
	static class State {
		int r;
		int c;
		int depth;
		
		public State(int r, int c, int d) {
			this.r = r;
			this.c = c;
			depth = d;
		}
	}
}
