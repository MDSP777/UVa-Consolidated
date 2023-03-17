import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_466 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 1;
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			int n = Integer.parseInt(s);
			char[][] orig = new char[n][n];
			char[][] target = new char[n][n];
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split("\\s+");
				orig[i] = split[0].toCharArray();
				target[i] = split[1].toCharArray();
			}
			String ans = "improperly transformed.";
			if(equal(orig, target)) ans = "preserved.";
			else if(equal(rot90(orig), target)) ans = "rotated 90 degrees.";
			else if(equal(rot90(rot90(orig)), target)) ans = "rotated 180 degrees.";
			else if(equal(rot90(rot90(rot90(orig))), target)) ans = "rotated 270 degrees.";
			else {
				orig = reflect(orig);
				if(equal(orig, target)) ans = "reflected vertically.";
				else if(equal(rot90(orig), target)) ans = "reflected vertically and rotated 90 degrees.";
				else if(equal(rot90(rot90(orig)), target)) ans = "reflected vertically and rotated 180 degrees.";
				else if(equal(rot90(rot90(rot90(orig))), target)) ans = "reflected vertically and rotated 270 degrees.";
			}
			System.out.println("Pattern "+x+++" was "+ans);
		}
	}
	
	static char[][] rot90(char[][] grid) {
		char[][] res = new char[grid.length][grid.length];
		for(int i=0; i<grid.length; i++)
			for(int j=0; j<grid.length; j++)
				res[j][grid.length-i-1] = grid[i][j];
		return res;
	}
	
	static char[][] reflect(char[][] grid) {
		char[][] res = new char[grid.length][grid.length];
		for(int i=0; i<grid.length; i++) res[i] = grid[grid.length-i-1];
		return res;
	}
	
	static boolean equal(char[][] grid, char[][] res) {
		for(int i=0; i<grid.length; i++)
			for(int j=0; j<grid.length; j++) if(grid[i][j]!=res[i][j]) return false;
		return true;
	}
}
