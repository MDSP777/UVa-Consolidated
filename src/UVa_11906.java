import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class UVa_11906 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		for(int x=1; x<=nC; x++) {
			String[] split = br.readLine().split("\\s+");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			int m = Integer.parseInt(split[2]);
			int n = Integer.parseInt(split[3]);
			boolean[][] hasWater = new boolean[r][c];
			int nWater = Integer.parseInt(br.readLine());
			while(nWater-->0) {
				split = br.readLine().split("\\s+");
				hasWater[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = true;
			}
			boolean[][] visited = new boolean[r][c];
			visited[0][0] = true;
			LinkedList<Point> q = new LinkedList<>();
			q.add(new Point(0, 0));
			int nOdd = 0;
			int nEven = 0;
			int[] rOffsets = {-1, 1, 1, -1};
			int[] cOffsets = {1, -1, 1, -1};
			while(!q.isEmpty()) {
				Point cur = q.poll();
				int total = 0;
				for(int i=0; i<4; i++) {
					if(i>=2 && (n==0 || m==0)) break;
					int newR = cur.r+rOffsets[i]*m;
					int newC = cur.c+cOffsets[i]*n;
					if(newR>=0 && newR<r && newC>=0 && newC<c && !hasWater[newR][newC]) {
						total++;
						if(!visited[newR][newC]) {
							visited[newR][newC] = true;
							q.add(new Point(newR, newC));
						}
					}
					if(n!=m) {
						newR = cur.r+rOffsets[i]*n;
						newC = cur.c+cOffsets[i]*m;
						if(newR>=0 && newR<r && newC>=0 && newC<c && !hasWater[newR][newC]) {
							total++;
							if(!visited[newR][newC]) {
								visited[newR][newC] = true;
								q.add(new Point(newR, newC));
							}
						}
					}
				}
				if(total%2==0) nEven++;
				else nOdd++;
			}
			sb.append("Case ").append(x).append(": ").append(nEven).append(" ").append(nOdd).append("\n");
		}
		System.out.print(sb);
	}
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
