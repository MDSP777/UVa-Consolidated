import java.util.LinkedList;
import java.util.Scanner;

public class UVa_10653 {
	static boolean[][] isBomb;
	static int r;
	static int c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			r = sc.nextInt();
			c = sc.nextInt();
			if(r==0 && c==0) break;
			isBomb = new boolean[r][c];
			int nBombRows = sc.nextInt();
			while(nBombRows-->0) {
				int row = sc.nextInt();
				int nBombs = sc.nextInt();
				while(nBombs-->0) isBomb[row][sc.nextInt()] = true;
			}
			Point start = new Point(sc.nextInt(), sc.nextInt(), 0);
			Point end = new Point(sc.nextInt(), sc.nextInt(), 0);
			System.out.println(bfs(start, end));
		}
	}
	
	private static int bfs(Point start, Point end) {
		int[] rowOffsets = {0,  0, -1, 1};
		int[] colOffsets = {-1, 1,  0, 0};
		boolean[][] visited = new boolean[r][c];
		visited[start.r][start.c] = true;
		LinkedList<Point> l = new LinkedList<>();
		l.add(start);
		while(!l.isEmpty()) {
			Point cur = l.pop();
			for(int i=0; i<4; i++) {
				int newR = cur.r+rowOffsets[i];
				int newC = cur.c+colOffsets[i];
				if(newR>=0 && newR<r && newC>=0 && newC<c && !isBomb[newR][newC] && !visited[newR][newC]) {
					Point newPoint = new Point(newR, newC, cur.depth+1);
					if(newPoint.equals(end)) return newPoint.depth;
					l.add(newPoint);
					visited[newR][newC] = true;
				}
			}
		}
		return -1;
	}

	static class Point {
		int r;
		int c;
		int depth;
		
		public Point(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
		
		public boolean equals(Point p2) {
			return this.r==p2.r && this.c==p2.c;
		}
	}
}
