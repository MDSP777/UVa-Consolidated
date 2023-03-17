import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_776 {
	static ArrayList<String[]> grid;
	static boolean[][] visited;
	static int[] rOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] cOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int r;
	static int c;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean done = false;
		while(true) {
			grid = new ArrayList<>();
			while(true) {
				String s = br.readLine();
				if(s==null || s.isEmpty()) {
					done = true;
					break;
				}
				if(s.equals("%")) break;
				grid.add(s.split(" "));
			}
			r = grid.size();
			c = grid.get(0).length;
			visited = new boolean[r][c];
			int v = 1;
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) 
					if(!visited[i][j]) {
						visited[i][j] = true;
						dfs(i, j, grid.get(i)[j], v);
						v++;
					}
			int[] colMax = new int[c];
			for(int i=0; i<c; i++) {
				int max = 0;
				for(int j=0; j<r; j++) max = Math.max(max, grid.get(j)[i].length());
				colMax[i] = max;
			}
			for(int i=0; i<r; i++) {
				while(grid.get(i)[0].length()<colMax[0]) grid.get(i)[0] = " "+grid.get(i)[0];
				sb.append(grid.get(i)[0]);
				for(int j=1; j<c; j++) {
					while(grid.get(i)[j].length()<colMax[j]) grid.get(i)[j] = " "+grid.get(i)[j];
					sb.append(" ").append(grid.get(i)[j]);
				}
				sb.append("\n");
			}
			sb.append("%\n");
			if(done) break;
		}
		System.out.print(sb);
	}
	
	static void dfs(int curR, int curC, String s, int v) {
		grid.get(curR)[curC] = v+"";
		for(int i=0; i<8; i++) {
			int newR = curR+rOffsets[i];
			int newC = curC+cOffsets[i];
			if(newR>=0 && newR<r && newC>=0 && newC<c && !visited[newR][newC] && grid.get(newR)[newC].equals(s)) {
				visited[newR][newC] = true;
				dfs(newR, newC, s, v);
			}
		}
	}
}
