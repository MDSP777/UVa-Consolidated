import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class UVa_782 {
	static boolean[][] visited;
	static int r;
	static char[][] grid;
	static int[] rOffsets = {-1, 1, 0, 0};
	static int[] cOffsets = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			ArrayList<String> g = new ArrayList<>();
			while(true){
				g.add(br.readLine());
				if(g.get(g.size()-1).contains("_")) break;
			}
			String last = g.get(g.size()-1);
			g.remove(g.size()-1);
			r = g.size();
			int starR = -1, starC = -1;
			grid = new char[r][85];
			for(int i=0; i<r; i++){
				Arrays.fill(grid[i], ' ');
				for(int j=0; j<g.get(i).length(); j++){
					grid[i][j] = g.get(i).charAt(j);
					if(grid[i][j]=='*'){
						starR = i;
						starC = j;
					}
				}
			}
			visited = new boolean[r][85];
			grid[starR][starC] = ' ';
			fill(starR, starC);
			for(int i=0; i<r; i++) System.out.println(new String(grid[i]).replaceAll("\\s+$", ""));
			System.out.println(last);
		}
	}
	
	static void fill(int row, int col){
		visited[row][col] = true;
		boolean hasAdj = false;
		for(int i=0; i<4; i++){
			int newR = row+rOffsets[i];
			int newC = col+cOffsets[i];
			if(newR>=0 && newR<r && newC>=0 && newC<85) {
				if(!visited[newR][newC] && grid[newR][newC]==' ') fill(newR, newC);
				hasAdj|=grid[newR][newC]!=' ' && grid[newR][newC]!='_' && grid[newR][newC]!='#' && grid[newR][newC]!='*';
			}
		}
		if(grid[row][col]==' ' && hasAdj) grid[row][col] = '#';
	}
}
