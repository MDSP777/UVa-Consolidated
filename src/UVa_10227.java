import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;

public class UVa_10227 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		sc.nextLine();
		while(nC-->0) {
			int p = sc.nextInt();
			int t = sc.nextInt();
			sc.nextLine();
			BitSet[] bs = new BitSet[p];
			for(int i=0; i<p; i++) bs[i] = new BitSet();
			while(sc.hasNext()) {
				String s = sc.nextLine();
				if(s.equals("-1" ) || s.isEmpty()) break;
				String[] split = s.split("\\s+");
				bs[Integer.parseInt(split[0])-1].set(Integer.parseInt(split[1])-1);
			}
			DisjointSet ds = new DisjointSet(p);
			for(int i=0; i<p; i++)
				for(int j=0; j<p; j++)
					if(i!=j && bs[i].equals(bs[j])) ds.union(i, j);
			HashSet<Integer> sets = new HashSet<>();
			for(int i=0; i<p; i++) sets.add(ds.findSet(i));
			System.out.println(sets.size());
			if(nC>0) System.out.println();
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
