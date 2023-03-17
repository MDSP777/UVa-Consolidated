import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10946 {
	static int[] rOffsets = {0, 0, -1, 1};
	static int[] cOffsets = {-1, 1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 1;
		while(true) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			if(r==0 && c==0) break;
			char[][] grid = new char[r][c];
			for(int i=0; i<r; i++) grid[i] = sc.next().toCharArray();
			ArrayList<Answer> a = new ArrayList<>();
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++)
					if(grid[i][j]!='.') {
						char val = grid[i][j];
						int size = fill(grid, i, j, val);
						a.add(new Answer(size, val));
					}
			Collections.sort(a, Collections.reverseOrder());
			System.out.println("Problem "+x+++":");
			for(Answer cur: a) System.out.println(cur.c+" "+cur.size);
		}
	}
	
	private static int fill(char[][] grid, int r, int c, char val) {
		int total = 1;
		grid[r][c] = '.';
		for(int i=0; i<4; i++) {
			int newR = r+rOffsets[i];
			int newC = c+cOffsets[i];
			if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length && grid[newR][newC]==val) total+=fill(grid, newR, newC, val);
		}
		return total;
	}

	static class Answer implements Comparable<Answer> {
		int size;
		char c;
		
		public Answer(int s, char c) {
			size = s;
			this.c = c;
		}

		@Override
		public int compareTo(Answer o) {
			if(size==o.size) return Character.compare(o.c, c);
			return Integer.compare(size, o.size);
		}
	}
}
