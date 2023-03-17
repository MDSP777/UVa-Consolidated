import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVa_11690 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			String[] split = br.readLine().split("\\s+");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			int[] deficits = new int[n];
			for(int i=0; i<n; i++) deficits[i] = Integer.parseInt(br.readLine());
			DisjointSet ds = new DisjointSet(n);
			while(m-->0) {
				split = br.readLine().split("\\s+");
				ds.union(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
			}
			HashMap<Integer, Integer> bal = new HashMap<>();
			for(int i=0; i<n; i++) 
				if(!bal.containsKey(ds.findSet(i))) bal.put(ds.findSet(i), deficits[i]);
				else bal.put(ds.findSet(i), bal.get(ds.findSet(i))+deficits[i]);
			boolean p = true;
			for(int i: bal.values()) p&=i==0;
			System.out.println(p ? "POSSIBLE" : "IMPOSSIBLE");
		}
	}
	
	static class DisjointSet {
		int[] p;
		int[] rank;
		
		public DisjointSet(int n) {
			p = new int[n];
			rank = new int[n];
			for(int i=0; i<n; i++) p[i] = i;
		}
		
		int findSet(int i) {
			return p[i]==i ? i : (p[i] = findSet(p[i]));
		}
		
		boolean isSameSet(int i, int j) {
			return findSet(i)==findSet(j);
		}
		
		void union(int i, int j) {
			if(!isSameSet(i, j)) {
				int x = findSet(i);
				int y = findSet(j);
				if(rank[y]>rank[x]) p[x] = y;
				else {
					p[y] = x;
					if(rank[x]==rank[y]) rank[x]++;
				}
			}
		}
	}
}
