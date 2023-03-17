import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_758 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] rOffsets = {-1, 1, 0, 0};
		int[] cOffsets = {0, 0, -1, 1};
		for(int t=1; t<=tc; t++){
			char[][] grid = new char[10][];
			for(int i=0; i<10; i++) grid[i] = sc.next().toCharArray();
			System.out.println("Game "+t+":\n");
			int mCtr = 1, tScore = 0;
			while(true){
				int[][] vals = new int[10][15];
				boolean[][] visited = new boolean[10][15];
				int best = 0;
				boolean found = false;
				for(int i=0; i<10; i++)
					for(int j=0; j<15; j++)
						if(grid[i][j]!=' ' && !visited[i][j]){
							LinkedList<State> q = new LinkedList<>();
							ArrayList<State> v = new ArrayList<>();
							char target = grid[i][j];
							q.add(new State(i, j));
							visited[i][j] = true;
							while(!q.isEmpty()){
								State cur = q.poll();
								v.add(cur);
								for(int k=0; k<4; k++){
									int newR = cur.r+rOffsets[k];
									int newC = cur.c+cOffsets[k];
									if(newR>=0 && newR<10 && newC>=0 && newC<15 && grid[newR][newC]==target && !visited[newR][newC]){
										visited[newR][newC] = true;
										q.add(new State(newR, newC));
									}
								}
							}
							for(State st : v) vals[st.r][st.c] = v.size();
							best = Math.max(best, v.size());
							if(v.size()>=2) found = true;
						}
				if(!found) break;
				ArrayList<State> v = new ArrayList<>();
				for(int i=0; i<10; i++)
					for(int j=0; j<15; j++)
						if(vals[i][j]==best) v.add(new State(i, j));
				Collections.sort(v);
				int targR = v.get(0).r, targC = v.get(0).c;
				LinkedList<State> q = new LinkedList<>();
				q.add(new State(targR, targC));
				char target = grid[targR][targC];
				int score = (best-2)*(best-2);
				System.out.println("Move "+mCtr+++" at ("+(10-targR)+","+(targC+1)+"): removed "+best+" balls of color "+target+", got "+score+" points.");
				tScore+=score;
				grid[targR][targC] = ' ';
				while(!q.isEmpty()){
					State cur = q.poll();
					for(int k=0; k<4; k++){
						int newR = cur.r+rOffsets[k];
						int newC = cur.c+cOffsets[k];
						if(newR>=0 && newR<10 && newC>=0 && newC<15 && grid[newR][newC]==target){
							grid[newR][newC] = ' ';
							q.add(new State(newR, newC));
						}
					}
				}
				for(int j=0; j<15; j++)
					for(int i=9; i>0; i--)
						if(grid[i][j]==' ') {
							int next = i;
							while(next>=0 && grid[next][j]==' ') next--;
							if(next==-1) break;
							grid[i][j] = grid[next][j];
							grid[next][j] = ' ';
						}
				for(int j=0; j<15; j++){
					boolean isEmpty = isEmptyCol(grid, j);
					if(isEmpty){
						int next = j;
						while(next<15 && isEmptyCol(grid, next)) next++;
						if(next==15) break;
						for(int i=0; i<10; i++){
							char temp = grid[i][j];
							grid[i][j] = grid[i][next];
							grid[i][next] = temp;
						}
					}
				}
			}
			int left = 0;
			for(int i=0; i<10; i++)
				for(int j=0; j<15; j++)
					if(grid[i][j]!=' ') left++;
			if(left==0) tScore+=1000;
			System.out.println("Final score: "+tScore+", with "+left+" balls remaining.");
			if(t<tc) System.out.println();
		}
	}
	
	private static boolean isEmptyCol(char[][] grid, int j) {
		for(int i=0; i<10; i++) if(grid[i][j]!=' ') return false;
		return true;
	}

	static class State implements Comparable<State> {
		int r, c;
		
		State(int a, int b){
			r = a;
			c = b;
		}

		@Override
		public int compareTo(State o) {
			if(c==o.c) return o.r-r;
			return c-o.c;
		}
	}
}
