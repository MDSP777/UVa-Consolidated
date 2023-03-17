import java.util.LinkedList;
import java.util.Scanner;

public class UVa_12160 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 1;
		while(true) {
			int l = sc.nextInt();
			int u = sc.nextInt();
			int r = sc.nextInt();
			if(l==0 && u==0 && r==0) break;
			if(l==u) {
				System.out.println("Case "+x+++": 0");
				continue;
			}
			int[] next = new int[r];
			for(int i=0; i<r; i++) next[i] = sc.nextInt();
			boolean[] visited = new boolean[10000];
			LinkedList<State> q = new LinkedList<>();
			q.add(new State(l, 0));
			visited[l] = true;
			int ans = -1;
			while(!q.isEmpty()) {
				State cur = q.poll();
				for(int i=0; i<r; i++) {
					int n = (cur.val+next[i])%10000;
					if(!visited[n]) {
						visited[n] = true;
						if(n==u) {
							ans = cur.depth+1;
							break;
						}
						q.add(new State(n, cur.depth+1));
					}
				}
				if(ans!=-1) break;
			}
			System.out.println("Case "+x+++": "+(ans==-1 ? "Permanently Locked" : ans));
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
