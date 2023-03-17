import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class UVa_929 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		int[] rOffsets = {0, 0, -1, 1};
		int[] cOffsets = {-1, 1, 0, 0};
		while(nC-->0) {
			int r = Integer.parseInt(br.readLine());
			int c = Integer.parseInt(br.readLine());
			int[][] grid = new int[r][c];
			for(int i=0; i<r; i++) {
				String[] split = br.readLine().split(" ");
				for(int j=0; j<c; j++) grid[i][j] = Integer.parseInt(split[j]);
			}
			int[][] dist = new int[r][c];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) dist[i][j] = 2000000;
			dist[0][0] = grid[0][0];
			PriorityQueue<State> q = new PriorityQueue<>();
			q.add(new State(0, 0, 0));
			while(!q.isEmpty()) {
				State cur = q.poll();
				if(cur.dist>dist[cur.r][cur.c]) continue;
				for(int i=0; i<4; i++) {
					int newR = cur.r+rOffsets[i];
					int newC = cur.c+cOffsets[i];
					if(newR>=0 && newR<r && newC>=0 && newC<c) {
						if(dist[cur.r][cur.c]+grid[newR][newC]<dist[newR][newC]) {
							dist[newR][newC] = dist[cur.r][cur.c]+grid[newR][newC];
							q.add(new State(newR, newC, dist[newR][newC]));
						}
					}
				}
			}
			System.out.println(dist[r-1][c-1]);
		}
	}
	
	static class State implements Comparable<State> {
		int r;
		int c;
		int dist;
		
		public State(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(State o) {
			return Integer.compare(dist, o.dist);
		}
	}
}
