import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class UVa_825 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] rOffsets = {1, 0};
		int[] cOffsets = {0, 1};
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			br.readLine();
			String[] split = br.readLine().split(" ");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			boolean[][] blocked = new boolean[r][c];
			for(int i=0; i<r; i++) {
				split = br.readLine().split(" ");
				int curR = Integer.parseInt(split[0])-1;
				for(int j=1; j<split.length; j++) {
					int curC = Integer.parseInt(split[j])-1;
					blocked[curR][curC] = true;
				}
			}
			int[][] paths = new int[r][c];
			paths[0][0] = 1;
			LinkedList<State> q = new LinkedList<>();
			q.add(new State(0, 0));
			while(!q.isEmpty()) {
				State cur = q.poll();
				for(int x=0; x<2; x++) {
					int nextR = cur.r+rOffsets[x];
					int nextC = cur.c+cOffsets[x];
					if(nextR>=0 && nextR<r && nextC>=0 && nextC<c && !blocked[nextR][nextC]) {
						if(paths[nextR][nextC]==0) q.add(new State(nextR, nextC));
						paths[nextR][nextC]+=paths[cur.r][cur.c];
					}
				}
			}
			sb.append(String.format("%d\n", paths[r-1][c-1]));
			if(tc>0) sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static class State {
		int r, c;
		
		State(int a, int b){
			r = a;
			c = b;
		}
	}
}
