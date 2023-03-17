import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_11101 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] rOffsets = {0, 0, -1, 1};
		int[] cOffsets = {-1, 1, 0, 0};
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			LinkedList<State> q = new LinkedList<>();
			while(n-->0) q.add(new State(sc.nextInt(), sc.nextInt(), 0));
			HashSet<State> dest = new HashSet<>();
			n = sc.nextInt();
			while(n-->0) dest.add(new State(sc.nextInt(), sc.nextInt(), 0));
			int ans = -1;
			boolean[][] visited = new boolean[2050][2050];
			while(!q.isEmpty()) {
				State cur = q.poll();
				for(int i=0; i<4; i++) {
					int newR = cur.r+rOffsets[i];
					int newC = cur.c+cOffsets[i];
					if(newR>=0 && newR<=2000 && newC>=0 && newC<=2000 && !visited[newR][newC]) {
						visited[newR][newC] = true;
						State next = new State(newR, newC, cur.depth+1);
						if(dest.contains(next)) {
							ans = next.depth;
							break;
						}
						q.add(next);
					}
				}
				if(ans!=-1) break;
			}
			System.out.println(ans);
		}
	}
	
	static class State {
		int r;
		int c;
		int depth;
		
		public State(int r, int c, int d) {
			this.r = r;
			this.c = c;
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
			State other = (State) obj;
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}
	}
}
