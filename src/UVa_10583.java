import java.util.HashSet;
import java.util.Scanner;

public class UVa_10583 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 1;
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0) break;
			DisjointSet ds = new DisjointSet(n);
			while(m-->0) ds.union(sc.nextInt()-1, sc.nextInt()-1);
			HashSet<Integer> ans = new HashSet<>();
			for(int i=0; i<n; i++) ans.add(ds.findSet(i));
			System.out.println("Case "+c+++": "+ans.size());
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
