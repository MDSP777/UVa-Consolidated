import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_784 {
	static int[] rOffsets = {0, 0, -1, 1};
	static int[] cOffsets = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			ArrayList<char[]> grid = new ArrayList<>();
			String sep = "";
			while(true) {
				String s = br.readLine();
				if(s.replaceAll("[^_]", "_").equals(s)) {
					sep = s;
					break;
				}
				grid.add(s.toCharArray());
			}
			boolean found = false;
			for(int i=0; i<grid.size(); i++) {
				for(int j=0; j<grid.get(i).length; j++) 
					if(grid.get(i)[j]=='*') {
						fill(grid, i, j);
						found = true;
						break;
					}
				if(found) break;
			}
			for(int i=0; i<grid.size(); i++) System.out.println(grid.get(i));
			System.out.println(sep);
		}
	}
	
	static void fill(ArrayList<char[]> grid, int r, int c) {
		grid.get(r)[c] = '#';
		for(int i=0; i<4; i++) {
			int newR = r+rOffsets[i];
			int newC = c+cOffsets[i];
			if(newR>=0 && newR<grid.size() && newC>=0 && newC<grid.get(r).length && grid.get(newR)[newC]!='X' && grid.get(newR)[newC]!='#') fill(grid, newR, newC);
		}
	}
}
