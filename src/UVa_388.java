import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_388 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int n = sc.nextInt()+1;
			int index = 0;
			HashMap<String, Integer> map = new HashMap<>();
			HashMap<Integer, String> map2 = new HashMap<>();
			map.put("*", index++);
			map2.put(0, "*");
			ArrayList<Integer>[] e = new ArrayList[n];
			double[] val = new double[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			for(int i=1; i<n; i++) {
				String s = sc.next();
				if(!map.containsKey(s)) {
					map.put(s, index);
					map2.put(index++, s);
				}
				int u = map.get(s);
				val[u] = sc.nextDouble();
				String next = sc.next();
				for(int j=0; j<next.length(); j++) {
					String c = next.charAt(j)+"";
					if(!map.containsKey(c)) {
						map.put(c, index);
						map2.put(index++, c);
					}
					int v = map.get(c);
					e[u].add(v);
					e[v].add(u);
				}
			}
			int[] dist = new int[n];
			BitSet visited = new BitSet();
			LinkedList<State> q = new LinkedList<>();
			q.add(new State(0, 0));
			visited.set(0);
			while(!q.isEmpty()) {
				State cur = q.poll();
				dist[cur.val] = cur.depth; 
				for(int next: e[cur.val])
					if(!visited.get(next)) {
						visited.set(next);
						q.add(new State(next, cur.depth+1));
					}
			}
			double max = -100000000;
			String ans = "";
			for(int i=1; i<n; i++) {
				double v = val[i]*Math.pow(0.95, dist[i]-1);
				if(v>max || (v==max && map2.get(i).charAt(0)<ans.charAt(0))) {
					max = v;
					ans = map2.get(i);
				}
			}
			System.out.println("Import from "+ans);
		} while(sc.hasNext());
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
