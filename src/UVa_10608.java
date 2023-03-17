import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_10608 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			String[] split = br.readLine().split("\\s+");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			DisjointSet ds = new DisjointSet(n);
			while(m-->0) {
				split = br.readLine().split("\\s+");
				ds.union(Integer.parseInt(split[0])-1, Integer.parseInt(split[1])-1);
			}
			int best = 0;
			for(int i=0; i<n; i++) best = Math.max(best, ds.size[i]);
			System.out.println(best);
		}
	}
	
	static class DisjointSet {
		int[] p;
		int[] rank;
		int[] size;
		
		public DisjointSet(int n) {
			p = new int[n];
			rank = new int[n];
			size = new int[n];
			for(int i=0; i<n; i++) {
				p[i] = i;
				size[i] = 1;
			}
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
				size[x]+=size[y];
				size[y] = size[x];
			}
		}
	}
}
