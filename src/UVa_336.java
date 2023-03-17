import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_336 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			int[] x = new int[n];
			int[] y = new int[n];
			HashMap<Integer, Integer> map = new HashMap<>();
			int index = 0;
			for(int i=0; i<n; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
				if(!map.containsKey(x[i])) map.put(x[i], index++);
				if(!map.containsKey(y[i])) map.put(y[i], index++);
			}
			boolean[][] adj = new boolean[index][index];
			for(int i=0; i<n; i++) adj[map.get(x[i])][map.get(y[i])] = adj[map.get(y[i])][map.get(x[i])] = true;
			while(true) {
				int s = sc.nextInt();
				int d = sc.nextInt();
				if(s==0 && d==0) break;
				LinkedList<State> q = new LinkedList<>();
				BitSet bs = new BitSet();
				bs.set(map.get(s));
				q.add(new State(map.get(s), 0));
				int total = 0;
				while(!q.isEmpty()) {
					State cur = q.poll();
					if(cur.depth>d) break;
					total++;
					for(int i=0; i<index; i++)
						if(adj[cur.val][i] && !bs.get(i)) {
							bs.set(i);
							q.add(new State(i, cur.depth+1));
						}
				}
				System.out.println("Case "+c+++": "+(index-total)+" nodes not reachable from node "+s+" with TTL = "+d+".");
			}
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
