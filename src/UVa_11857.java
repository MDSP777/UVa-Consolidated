import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_11857 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] split = br.readLine().split("\\s+");
			int n = Integer.parseInt(split[0]);
			int nE = Integer.parseInt(split[1]);
			if(n==0 && nE==0) break;
			ArrayList<Edge> e = new ArrayList<>();
			while(nE-->0) {
				split = br.readLine().split("\\s+");
				e.add(new Edge(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
			}
			Collections.sort(e);
			int last = 0;
			DisjointSet ds = new DisjointSet(n);
			for(int i=0; i<e.size(); i++)
				if(!ds.isSameSet(e.get(i).src, e.get(i).dest)) {
					ds.union(e.get(i).src, e.get(i).dest);
					last = e.get(i).weight;
				}
			System.out.println(ds.allSameSet() ? last : "IMPOSSIBLE");
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
		
		boolean allSameSet() {
			for(int i=1; i<p.length; i++) if(!isSameSet(0, i)) return false;
			return true;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;
		
		public Edge(int s, int d, int w) {
			src = s;
			dest = d;
			weight = w;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}
}
