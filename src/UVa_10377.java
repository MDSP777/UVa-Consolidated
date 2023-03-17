import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UVa_10377 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		int[] rOffsets = {-1, 0, 1, 0};
		int[] cOffsets = {0, 1, 0, -1};
		char[] chars = {'N', 'E', 'S', 'W'};
		br.readLine();
		while(nC-->0) {
			String[] split = br.readLine().split("\\s+");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			char[][] grid = new char[r][c];
			for(int i=0; i<r; i++) {
				Arrays.fill(grid[i], ' ');
				String n = br.readLine();
				for(int j=0; j<n.length(); j++) grid[i][j] = n.charAt(j);
			}
			split = br.readLine().split("\\s+");
			int curR = Integer.parseInt(split[0])-1;
			int curC = Integer.parseInt(split[1])-1;
			int orientation = 0;
			while(true) {
				String s = br.readLine();
				if(s==null || s.isEmpty()) break;
				for(int i=0; i<s.length(); i++) 
					if(s.charAt(i)=='R') orientation = (orientation+1)%4;
					else if(s.charAt(i)=='L') orientation = orientation==0 ? 3 : orientation-1;
					else if(s.charAt(i)=='F') {
						int newR = curR+rOffsets[orientation];
						int newC = curC+cOffsets[orientation];
						if(grid[newR][newC]!='*') {
							curR = newR;
							curC = newC;
						}
					} else if(s.charAt(i)=='Q') System.out.println((curR+1)+" "+(curC+1)+" "+chars[orientation]);
			}
			if(nC>0) System.out.println();
		}
	}
}
