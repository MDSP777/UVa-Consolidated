import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_1160 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			DisjointSet ds = new DisjointSet(100100);
			int n = 0;
			while(true) {
				String s = br.readLine();
				if(s.equals("-1")) break;
				String[] split = s.split(" ");
				int a = Integer.parseInt(split[0]);
				int b = Integer.parseInt(split[1]);
				if(!ds.isSameSet(a, b)) ds.union(a, b);
				else n++;
			}
			System.out.println(n);
			String s = br.readLine();
			if(s==null) break;
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
			return p[i]==i ? i :(p[i] = findSet(p[i]));
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
