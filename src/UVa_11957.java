import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_11957 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		for(int curC=1; curC<=nC; curC++){
			int n = sc.nextInt();
			char[][] grid = new char[n][];
			for(int i=0; i<n; i++) grid[i] = sc.next().toCharArray();
			ArrayList<State>[][] e = new ArrayList[n][n];
			State s = null;
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) {
					if(grid[i][j]=='W') s = new State(i, j);
					e[i][j] = new ArrayList<>();
				}
			int[][] outD = new int[n][n];
			int[][] inD = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			LinkedList<State> q = new LinkedList<>();
			q.add(s);
			visited[s.r][s.c] = true;
			while(!q.isEmpty()){
				State cur = q.poll();
				int leftR = cur.r-1;
				int rightR = cur.r-1;
				int leftC = cur.c-1;
				int rightC = cur.c+1;
				if(leftR>=0 && leftR<n && leftC>=0 && leftC<n && grid[leftR][leftC]=='B') {
					leftC--;
					leftR--;
				}
				if(rightR>=0 && rightR<n && rightC>=0 && rightC<n && grid[rightR][rightC]=='B') {
					rightC++;
					rightR--;
				}
				if(leftR>=0 && leftR<n && leftC>=0 && leftC<n && grid[leftR][leftC]=='.'){
					if(!visited[leftR][leftC]) q.add(new State(leftR, leftC));
					visited[leftR][leftC] = true;
					inD[leftR][leftC]++;
					outD[cur.r][cur.c]++;
					e[cur.r][cur.c].add(new State(leftR, leftC));
				}
				if(rightR>=0 && rightR<n && rightC>=0 && rightC<n && grid[rightR][rightC]=='.') {
					if(!visited[rightR][rightC]) q.add(new State(rightR, rightC));
					visited[rightR][rightC] = true;
					inD[rightR][rightC]++;
					outD[cur.r][cur.c]++;
					e[cur.r][cur.c].add(new State(rightR, rightC));
				}
			}
			q = new LinkedList<>();
			ArrayList<State> ts = new ArrayList<>();
			q.add(s);
			while(!q.isEmpty()){
				State cur = q.poll();
				ts.add(cur);
				for(State next: e[cur.r][cur.c]){
					inD[next.r][next.c]--;
					if(inD[next.r][next.c]==0) q.add(next);
				}
			}
			int[][] paths = new int[n][n];
			paths[s.r][s.c] = 1;
			for(State i: ts)
				for(State next: e[i.r][i.c]) {
					paths[next.r][next.c]+=paths[i.r][i.c];
					paths[next.r][next.c]%=1000007;
				}
			int total = 0;
			for(int i=0; i<n; i++) {
				total+=paths[0][i];
				total%=1000007;
			}
			System.out.println("Case "+curC+": "+total);
		}
	}
	
	static class State {
		int r;
		int c;
		
		public State(int r, int c){
			this.r = r;
			this.c = c;
		}
		
		public String toString(){
			return r+","+c;
		}
	}
}
