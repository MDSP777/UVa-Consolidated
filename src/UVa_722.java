import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_722 {
	static int[] rOffsets = {-1, 1, 0, 0};
	static int[] cOffsets = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		br.readLine();
		while(nC-->0) {
			String[] split = br.readLine().split("\\s+");
			int r = Integer.parseInt(split[0])-1;
			int c = Integer.parseInt(split[1])-1;
			ArrayList<char[]> grid = new ArrayList<>();
			while(true) {
				String s = br.readLine();
				if(s==null || s.isEmpty()) break;
				grid.add(s.toCharArray());
			}
			System.out.println(fill(grid, r, c));
			if(nC>0) System.out.println();
		}
	}

	private static int fill(ArrayList<char[]> grid, int r, int c) {
		grid.get(r)[c] = '2';
		int total = 1;
		for(int i=0; i<4; i++) {
			int newR = r+rOffsets[i];
			int newC = c+cOffsets[i];
			if(newR>=0 && newR<grid.size() && newC>=0 && newC<grid.get(0).length && grid.get(newR)[newC]=='0') total+=fill(grid, newR, newC);
		}
		return total;
	}
}
