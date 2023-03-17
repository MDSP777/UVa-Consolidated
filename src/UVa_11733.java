import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_11733 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		for(int x=1; x<=nC; x++) {
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int nE = Integer.parseInt(split[1]);
			int aCost = Integer.parseInt(split[2]);
			ArrayList<Edge> e = new ArrayList<>();
			while(nE-->0) {
				split = br.readLine().split(" ");
				e.add(new Edge(Integer.parseInt(split[0])-1, Integer.parseInt(split[1])-1, Integer.parseInt(split[2])));
			}
			Collections.sort(e);
			DisjointSet ds = new DisjointSet(n);
			int bestCost = aCost*n;
			int bestN = n;
			for(int i=0; i<e.size(); i++) 
				if(!ds.isSameSet(e.get(i).src, e.get(i).dest)) {
					int newCost = e.get(i).weight+(bestCost-aCost);
					int newN = bestN-1;
					if(newCost<bestCost) {
						bestCost = newCost;
						bestN = newN;
						ds.union(e.get(i).src, e.get(i).dest);
					}
				}
			sb.append("Case #").append(x).append(": ").append(bestCost).append(" ").append(bestN).append("\n");
		}
		System.out.print(sb);
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
