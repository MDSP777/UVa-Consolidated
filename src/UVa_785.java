import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_785 {
	static int[] rOffsets = {0, 0, -1, 1};
	static int[] cOffsets = {-1, 1, 0, 0};
	static char wall;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			wall = '_';
			ArrayList<char[]> grid = new ArrayList<>();
			String sep = "";
			while(true) {
				String s = br.readLine();
				if(s==null) return;
				if(s.replaceAll("[^_]", "_").equals(s)) {
					sep = s;
					break;
				}
				if(wall=='_') 
					for(int i=0; i<s.length(); i++) 
						if(s.charAt(i)!=' ' && s.charAt(i)!='_') {
							wall = s.charAt(i);
							break;
						}
				grid.add(s.toCharArray());
			}
			for(int i=0; i<grid.size(); i++) 
				for(int j=0; j<grid.get(i).length; j++) 
					if(grid.get(i)[j]!=' ' && grid.get(i)[j]!=wall) 
						fill(grid, i, j, grid.get(i)[j]);
			for(int i=0; i<grid.size(); i++) System.out.println(grid.get(i));
			System.out.println(sep);
		}
	}
	
	static void fill(ArrayList<char[]> grid, int r, int c, char f) {
		grid.get(r)[c] = f;
		for(int i=0; i<4; i++) {
			int newR = r+rOffsets[i];
			int newC = c+cOffsets[i];
			if(newR>=0 && newR<grid.size() && newC>=0 && newC<grid.get(newR).length && grid.get(newR)[newC]!=wall && grid.get(newR)[newC]!=f) fill(grid, newR, newC, f);
		}
	}
}
