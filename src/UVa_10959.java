import java.util.BitSet;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_10959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			int[][] e = new int[n][n];
			while(r-->0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				e[u][v] = e[v][u] = 1;
			}
			int[] dist = new int[n];
			LinkedList<State> q = new LinkedList<>();
			BitSet visited = new BitSet();
			q.add(new State(0, 0));
			visited.set(0);
			while(!q.isEmpty()) {
				State cur = q.poll();
				dist[cur.val] = cur.depth;
				for(int i=0; i<n; i++)
					if(e[cur.val][i]==1 && !visited.get(i)) {
						visited.set(i);
						q.add(new State(i, cur.depth+1));
					}
			}
			for(int i=1; i<n; i++) System.out.println(dist[i]);
			if(nC>0) System.out.println();
		}
	}
	
	static class State {
		int val;
		int depth;
		
		public State(int v, int d) {
			val = v;
			depth = d;
		}
	}
}
