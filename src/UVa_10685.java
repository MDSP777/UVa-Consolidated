import java.util.HashMap;
import java.util.Scanner;

public class UVa_10685 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0) break;
			int index = 0;
			HashMap<String, Integer> map = new HashMap<>();
			for(int i=0; i<n; i++) map.put(sc.next(), index++);
			DisjointSet ds = new DisjointSet(n);
			while(m-->0) ds.union(map.get(sc.next()), map.get(sc.next()));
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
				size[y]+=size[x];
				size[x] = size[y];
			}
		}
	}
}
