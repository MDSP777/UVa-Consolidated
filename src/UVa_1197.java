import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_1197 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] split = br.readLine().split("\\s+");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			if(n==0) break;
			DisjointSet ds = new DisjointSet(n);
			while(m-->0) {
				split = br.readLine().split("\\s+");
				int x = Integer.parseInt(split[1]);
				for(int i=2; i<split.length; i++) ds.union(x, Integer.parseInt(split[i]));
			}
			int total = 0;
			for(int i=0; i<n; i++) if(ds.isSameSet(0, i)) total++;
			System.out.println(total);
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
