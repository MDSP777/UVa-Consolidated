import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class UVa_314 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dirOffsets = {-1, 1};
		int[] rOffsets = {-1, 0, 1, 0};
		int[] cOffsets = {0, 1, 0, -1};
		while(true) {
			String[] split = br.readLine().split(" ");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			if(r==0 && c==0) break;
			boolean[][] grid = new boolean[r][c];
			for(int i=0; i<r; i++) {
				split = br.readLine().split(" ");
				for(int j=0; j<c; j++) grid[i][j] = split[j].equals("1");
			}
			split = br.readLine().split(" ");
			int startR = Integer.parseInt(split[0])-1;
			int startC = Integer.parseInt(split[1])-1;
			int endR = Integer.parseInt(split[2])-1;
			int endC = Integer.parseInt(split[3])-1;
			if(startR==endR && startC==endC) {
				System.out.println("0");
				continue;
			}
			int dir = split[4].equals("north") ? 0 : split[4].equals("east") ? 1 : split[4].equals("south") ? 2 : 3;
			boolean[][][] visited = new boolean[r][c][4];
			State start = new State(startR, startC, dir, 0);
			LinkedList<State> q = new LinkedList<>();
			int ans = -1;
			q.add(start);
			visited[startR][startC][dir] = true;
			while(ans==-1 && !q.isEmpty()) {
				State cur = q.poll();
				for(int i=0; i<2; i++) {
					int newDir = (cur.dir+dirOffsets[i])%4;
					if(newDir==-1) newDir = 3;
					if(!visited[cur.r][cur.c][newDir]) {
						visited[cur.r][cur.c][newDir] = true;
						q.add(new State(cur.r, cur.c, newDir, cur.depth+1));
					}
				}
				for(int x=1; x<=3; x++){
					int newR = cur.r+rOffsets[cur.dir]*x;
					int newC = cur.c+cOffsets[cur.dir]*x;
					if(newR<0 || newR>=r-1 || newC<0 || newC>=c-1) break;
					boolean walls = false;
					for(int i=0; i<2; i++)
						for(int j=0; j<2; j++) walls|=grid[newR+i][newC+j];
					if(walls) break;
					if(newR==endR && newC==endC) {
						ans = cur.depth+1;
						break;
					}
					if(!walls && !visited[newR][newC][cur.dir]) {
						visited[newR][newC][cur.dir] = true;
						q.add(new State(newR, newC, cur.dir, cur.depth+1));
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	static class State {
		int r;
		int c;
		int dir;
		int depth;
		
		public State(int r, int c, int dir, int d) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			depth = d;
		}
	}
}
