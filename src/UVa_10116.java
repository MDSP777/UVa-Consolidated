import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class UVa_10116 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String[] split = br.readLine().split("\\s+");
			int r = Integer.parseInt(split[0]);
			if(r==0) break;
			int c = Integer.parseInt(split[1]);
			int s = Integer.parseInt(split[2])-1;
			char[][] grid = new char[r][c];
			int[][] step = new int[r][c];
			for(int i=0; i<r; i++) {
				grid[i] = br.readLine().toCharArray();
				Arrays.fill(step[i], -1);
			}
			LinkedList<Pair> q = new LinkedList<>();
			q.add(new Pair(0, s, 0));
			step[0][s] = 0;
			while(!q.isEmpty()) {
				Pair cur = q.poll();
				char dir = grid[cur.r][cur.c];
				int newR = cur.r+(dir=='N' ? -1 : dir=='S' ? 1 : 0);
				int newC = cur.c+(dir=='W' ? -1 : dir=='E' ? 1 : 0);
				if(newR<0 || newR==r || newC<0 || newC==c) {
					sb.append(cur.depth+1).append(" step(s) to exit\n");
					break;
				} else if(step[newR][newC]!=-1) {
					sb.append(step[newR][newC]).append(" step(s) before a loop of ").append(cur.depth+1-step[newR][newC]).append(" step(s)\n");
					break;
				} else {
					q.add(new Pair(newR, newC, cur.depth+1));
					step[newR][newC] = cur.depth+1;
				}
			}
		}
		System.out.print(sb);
	}
	
	static class Pair {
		int r;
		int c;
		int depth;
		
		public Pair(int r, int c, int d) {
			this.r = r;
			this.c = c;
			depth = d;
		}
	}
}
