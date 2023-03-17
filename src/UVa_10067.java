import java.util.LinkedList;
import java.util.Scanner;

public class UVa_10067 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int[] s = new int[4];
			for(int i=0; i<4; i++) s[i] = sc.nextInt();
			int[] d = new int[4];
			for(int i=0; i<4; i++) d[i] = sc.nextInt();
			boolean[][][][] f = new boolean[10][10][10][10];
			int r = sc.nextInt();
			while(r-->0) f[sc.nextInt()][sc.nextInt()][sc.nextInt()][sc.nextInt()] = true;
			LinkedList<State> q = new LinkedList<>();
			boolean[][][][] visited = new boolean[10][10][10][10];
			q.add(new State(s, 0));
			int ans = -1;
			visited[s[0]][s[1]][s[2]][s[3]] = true;
			if(equals(s, d)) ans = 0;
			while(!q.isEmpty() && ans==-1) {
				State cur = q.poll();
				for(int i=0; i<4; i++) {
					int[] next = new int[4];
					for(int j=0; j<4; j++) next[j] = cur.val[j];
					next[i] = (next[i]+1)%10;
					if(!visited[next[0]][next[1]][next[2]][next[3]] && !f[next[0]][next[1]][next[2]][next[3]]) {
						visited[next[0]][next[1]][next[2]][next[3]] = true;
						q.add(new State(next, cur.depth+1));
						if(equals(next, d)) {
							ans = cur.depth+1;
							break;
						}
					}
					next = new int[4];
					for(int j=0; j<4; j++) next[j] = cur.val[j];
					next[i]--;
					if(next[i]==-1) next[i] = 9;
					if(!visited[next[0]][next[1]][next[2]][next[3]] && !f[next[0]][next[1]][next[2]][next[3]]) {
						visited[next[0]][next[1]][next[2]][next[3]] = true;
						q.add(new State(next, cur.depth+1));
						if(equals(next, d)) {
							ans = cur.depth+1;
							break;
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	static boolean equals(int[] a, int[] b) {
		for(int i=0; i<4; i++) if(a[i]!=b[i]) return false;
		return true;
	}
	
	static class State {
		int[] val;
		int depth;
		
		public State(int[] v, int d) {
			val = v;
			depth = d;
		}
	}
}
