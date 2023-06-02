import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class UVa_10010 {
	public static void main(String[] args) throws Exception {
		int[] rOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] cOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			br.readLine();
			String[] split = br.readLine().split(" ");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			char[][] grid = new char[r][];
			HashMap<Character, ArrayList<Point>> start = new HashMap<>();
			for(char i='a'; i<='z'; i++) start.put(i, new ArrayList<>());
			for(int i=0; i<r; i++) {
				grid[i] = br.readLine().toLowerCase().toCharArray();
				for(int j=0; j<c; j++) start.get(grid[i][j]).add(new Point(i, j));
			}
			int k = Integer.parseInt(br.readLine());
			while(k-->0) {
				char[] s = br.readLine().toLowerCase().toCharArray();
				
				for(Point p : start.get(s[0])) {
					boolean matched = false;
					
					for(int dir=0; !matched && dir<8; dir++) {
						int curR = p.r;
						int curC = p.c;
						for(int i=1; i<s.length; i++) {
							int newR = curR+rOffsets[dir];
							int newC = curC+cOffsets[dir];
							if(newR>=0 && newR<r && newC>=0 && newC<c) {
								if(grid[newR][newC]!=s[i]) break;
								curR = newR;
								curC = newC;
							} else break;
							
							if(i==s.length-1) matched = true;
						}
					}
					
					if(matched) {
						System.out.println(p);
						break;
					}
				}
			}
			
			if(tc>0) System.out.println();
		}
	}
	
	static class Point {
		int r, c;
		
		Point(int a, int b){
			r = a;
			c = b;
		}
		
		public String toString() {
			return (r+1)+" "+(c+1);
		}
	}
}
