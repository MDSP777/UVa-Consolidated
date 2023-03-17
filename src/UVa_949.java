import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_949 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] rOffsets = {-1, 1, 0, 0};
		int[] cOffsets = {0, 0, -1, 1};
		do{
			int c = sc.nextInt();
			int r = sc.nextInt();
			int m = sc.nextInt();
			HashSet<Cell>[][] no = new HashSet[r][c];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) no[i][j] = new HashSet<>();
			while(m-->0){
				int c1 = sc.nextInt();
				int r1 = sc.nextInt();
				int c2 = sc.nextInt();
				int r2 = sc.nextInt();
				no[r1][c1].add(new Cell(r2, c2));
			}
			Cell[] monitor = new Cell[510];
			m = sc.nextInt();
			while(m-->0){
				int t = sc.nextInt();
				int b = sc.nextInt();
				int a = sc.nextInt();
				monitor[t] = new Cell(a, b);
			}
			LinkedList<Cell> q = new LinkedList<>();
			boolean[][] visited = new boolean[r][c];
			q.add(new Cell(0, 0, 0));
			visited[0][0] = true;
			int ans = -1;
			while(!q.isEmpty()){
				Cell cur = q.poll();
				if(cur.r==r-1 && cur.c==c-1){
					ans = cur.depth;
					break;
				}
				for(int i=0; i<4; i++){
					int newR = cur.r+rOffsets[i];
					int newC = cur.c+cOffsets[i];
					if(newR>=0 && newR<r && newC>=0 && newC<c && !no[cur.r][cur.c].contains(new Cell(newR, newC)) && !visited[newR][newC]){
						if(cur.depth<=500 && monitor[cur.depth+1]!=null && monitor[cur.depth+1].r==newR && monitor[cur.depth+1].c==newC){
							q.add(new Cell(cur.r, cur.c, cur.depth+1));
						} else{
							visited[newR][newC] = true;
							Cell next = new Cell(newR, newC, cur.depth+1);
							q.add(next);
						}
					}
				}
			}
			System.out.println(ans);
		}while(sc.hasNext());
	}
	
	static class Cell{
		int r, c, depth;
		
		Cell(int a, int b){
			r = a;
			c = b;
		}
		
		Cell(int a, int b, int d){
			r = a;
			c = b;
			depth = d;
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
