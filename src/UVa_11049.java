import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_11049 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] rOffsets = {-1, 1, 0, 0};
		int[] cOffsets = {0, 0, -1, 1};
		char[] dir = {'N', 'S', 'W', 'E'};
		while(true){
			int sCol = sc.nextInt()-1;
			int sRow = sc.nextInt()-1;
			if(sCol==-1 && sRow==-1) break;
			int eCol = sc.nextInt()-1;
			int eRow = sc.nextInt()-1;
			HashSet<Cell>[][] no = new HashSet[6][6];
			for(int i=0; i<6; i++)
				for(int j=0; j<6; j++) no[i][j] = new HashSet<>();
			for(int i=0; i<3; i++){
				int c1 = sc.nextInt();
				int r1 = sc.nextInt();
				int c2 = sc.nextInt();
				int r2 = sc.nextInt();
				if(r1==r2 && r1!=0 && r1!=6){ // horizontal
					int l = Math.min(c1, c2);
					int r = Math.max(c1, c2);
					for(int a=l; a<r; a++){
						no[r1-1][a].add(new Cell(r1, a));
						no[r1][a].add(new Cell(r1-1, a));
					}
				} else if(c1==c2 && c1!=0 && c1!=6){
					int l = Math.min(r1, r2);
					int r = Math.max(r1, r2);
					for(int a=l; a<r; a++){
						no[a][c1-1].add(new Cell(a, c1));
						no[a][c1].add(new Cell(a, c1-1));
					}
				}
			}
			Cell ans = null;
			boolean[][] visited = new boolean[6][6];
			LinkedList<Cell> q = new LinkedList<>();
			q.add(new Cell(sRow, sCol, 0));
			visited[sRow][sCol] = true;
			while(!q.isEmpty()){
				Cell cur = q.poll();
				if(cur.r==eRow && cur.c==eCol){
					ans = cur;
					break;
				}
				for(int i=0; i<4; i++){
					int newR = cur.r+rOffsets[i];
					int newC = cur.c+cOffsets[i];
					if(newR>=0 && newR<6 && newC>=0 && newC<6 && !no[cur.r][cur.c].contains(new Cell(newR, newC)) && !visited[newR][newC]){
						visited[newR][newC] = true;
						Cell next = new Cell(newR, newC, cur.depth+1);
						next.path = new StringBuilder(cur.path.toString()).append(dir[i]);
						q.add(next);
					}
				}
			}
			System.out.println(ans.path);
		}
	}
	
	static class Cell {
		int r, c, depth;
		StringBuilder path;
		
		Cell(int a, int b){
			r = a;
			c = b;
			path = new StringBuilder();
		}
		
		Cell(int a, int b, int d){
			r = a;
			c = b;
			depth = d;
			path = new StringBuilder();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + c;
			result = prime * result + r;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}
	}
}
