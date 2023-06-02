import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class UVa_422 {
	public static void main(String[] args) throws Exception {
		int[] rOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] cOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Character, ArrayList<Point>> start = new HashMap<>();
		char[][] grid = new char[n][];
		
		for(char i='a'; i<='z'; i++) start.put(i, new ArrayList<>());
		for(int i=0; i<n; i++) {
			grid[i] = br.readLine().toLowerCase().toCharArray();
			for(int j=0; j<n; j++) start.get(grid[i][j]).add(new Point(i, j));
		}

		while(true) {
			String x = br.readLine();
			if(x.equals("0")) break;
			char[] s = x.toLowerCase().toCharArray();
			boolean matched = false;
			
			for(Point p : start.get(s[0])) {
				Point end = null;
				
				for(int dir=0; !matched && dir<8; dir++) {
					int curR = p.r;
					int curC = p.c;
					for(int i=1; i<s.length; i++) {
						int newR = curR+rOffsets[dir];
						int newC = curC+cOffsets[dir];
						if(newR>=0 && newR<n && newC>=0 && newC<n) {
							if(grid[newR][newC]!=s[i]) break;
							curR = newR;
							curC = newC;
						} else break;
						
						if(i==s.length-1) {
							matched = true;
							end = new Point(curR, curC);
						}
					}
				}
				
				if(matched) {
					System.out.println(p+" "+end);
					break;
				}
			}
			
			if(!matched) System.out.println("Not found");
		}
	}
	
	static class Point {
		int r, c;
		
		Point(int a, int b){
			r = a;
			c = b;
		}
		
		public String toString() {
			return (r+1)+","+(c+1);
		}
	}
}
