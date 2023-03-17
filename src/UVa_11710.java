import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UVa_11710 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] split = br.readLine().split("\\s+");
			int n = Integer.parseInt(split[0]);
			if(n==0) break;
			int nE = Integer.parseInt(split[1]);
			HashMap<String, Integer> map = new HashMap<>();
			for(int i=0; i<n; i++) map.put(br.readLine(), i);
			ArrayList<Edge> e = new ArrayList<>();
			while(nE-->0) {
				split = br.readLine().split("\\s+");
				e.add(new Edge(map.get(split[0]), map.get(split[1]), Integer.parseInt(split[2])));
			}
			Collections.sort(e);
			int total = 0;
			DisjointSet ds = new DisjointSet(n);
			for(int i=0; i<e.size(); i++)
				if(!ds.isSameSet(e.get(i).src, e.get(i).dest)) {
					ds.union(e.get(i).src, e.get(i).dest);
					total+=e.get(i).weight;
				}
			System.out.println(ds.allSameSet() ? total : "Impossible");
			br.readLine();
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
			int x = findSet(0);
			for(int i=1; i<p.length; i++) if(findSet(i)!=findSet(0)) return false;
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

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}
}
