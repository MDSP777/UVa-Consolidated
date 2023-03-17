import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_10158 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		DisjointSet ds = new DisjointSet(n*2);
		while(true) {
			String[] split = br.readLine().split("\\s+");
			if(split[0].equals("0")) break;
			int a = Integer.parseInt(split[1]);
			int b = Integer.parseInt(split[2]);
			if(split[0].equals("1")) {
				if(ds.isSameSet(a, b+n) || ds.isSameSet(a+n, b)) System.out.println("-1");
				else {
					ds.union(a, b);
					ds.union(a+n, b+n);
				}
			} else if(split[0].equals("2")) {
				if(ds.isSameSet(a, b)) System.out.println("-1");
				else {
					ds.union(a, b+n);
					ds.union(a+n, b);
				}
			} else if(split[0].equals("3")) System.out.println(ds.isSameSet(a, b) ? "1" : "0");
			else System.out.println((ds.isSameSet(a, b+n) || ds.isSameSet(a+n, b)) ? "1" : "0");
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
