import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_859 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] rOffsets = {0, 1, 1, 1, 0};
		int[] cOffsets = {-1, -1, 0, 1, 1};
		do{
			int r = sc.nextInt();
			int c = sc.nextInt();
			boolean[][] grid = new boolean[r][c];
			for(int i=0; i<c; i++){
				grid[sc.nextInt()-1][sc.nextInt()-1] = true;
				grid[sc.nextInt()-1][sc.nextInt()-1] = true;
				grid[sc.nextInt()-1][sc.nextInt()-1] = true;
				grid[sc.nextInt()-1][sc.nextInt()-1] = true;
			}
			int sRow = sc.nextInt()-1;
			int sCol = sc.nextInt()-1;
			LinkedList<State> q = new LinkedList<>();
			boolean[][] visited = new boolean[r][c];
			q.add(new State(sRow, sCol, 0));
			visited[sRow][sCol] = true;
			ArrayList<Answer> ans = new ArrayList<>();
			while(!q.isEmpty()){
				State cur = q.poll();
				for(int i=0; i<5; i++){
					int skipR = cur.r+rOffsets[i];
					int skipC = cur.c+cOffsets[i];
					int newR = cur.r+rOffsets[i]*2;
					int newC = cur.c+cOffsets[i]*2;
					if(newR>=0 && newR<r && newC>=0 && newC<c && grid[skipR][skipC] && !grid[newR][newC] && !visited[newR][newC]){
						ans.add(new Answer(newR+1, newC+1, cur.depth+1));
						visited[newR][newC] = true;
						q.add(new State(newR, newC, cur.depth+1));
					}
				}
			}
			for(int i=0; i<5; i+=2){
				int newR = sRow+rOffsets[i];
				int newC = sCol+cOffsets[i];
				if(newR>=0 && newR<r && newC>=0 && newC<c && !grid[newR][newC]){
					ans.add(new Answer(newR+1, newC+1, 1));
				}
			}
			Collections.sort(ans);
			for(Answer a : ans) System.out.println(a.r+" "+a.c+" "+a.depth);
			if(sc.hasNext()) System.out.println();
		}while(sc.hasNext());
	}
	
	static class State{
		int r, c, depth;
		
		State(int a, int b, int d){
			r = a;
			c = b;
			depth = d;
		}
	}
	
	static class Answer implements Comparable<Answer>{
		int r, c, depth;
		
		Answer(int a, int b, int d){
			r = a;
			c = b;
			depth = d;
		}

		@Override
		public int compareTo(Answer o) {
			if(r==o.r) return c-o.c;
			return o.r-r;
		}
	}
}
