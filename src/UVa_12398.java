import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_12398 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 1;
		int[] rOffsets = {0, 0, 0, -1, 1};
		int[] cOffsets = {0, -1, 1, 0, 0};
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			int[][] grid = new int[3][3];
			for(int i=0; i<s.length(); i++) {
				int st = s.charAt(i)-'a';
				int r = st/3;
				int c = st%3;
				for(int j=0; j<5; j++) {
					int newR = r+rOffsets[j];
					int newC = c+cOffsets[j];
					if(newR>=0 && newR<3 && newC>=0 && newC<3) grid[newR][newC] = (grid[newR][newC]+1)%10;
				}
			}
			System.out.println("Case #"+x+++":");
			for(int i=0; i<3; i++) System.out.println(grid[i][0]+" "+grid[i][1]+" "+grid[i][2]);
		}
	}
}
