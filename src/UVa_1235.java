import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;

public class UVa_1235 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			String[] split = br.readLine().split("\\s+");
			int n = Integer.parseInt(split[0]);
			ArrayList<Integer> nodes = new ArrayList<>();
			int minStart = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				nodes.add(Integer.parseInt(split[i+1]));
				minStart = Math.min(minStart, cost(0, nodes.get(i)));
			}
			ArrayList<Edge> e = new ArrayList<>();
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++) e.add(new Edge(i, j, cost(nodes.get(i), nodes.get(j))));
			Collections.sort(e);
			DisjointSet ds = new DisjointSet(n);
			int total = 0;
			for(int i=0; i<e.size(); i++) 
				if(!ds.isSameSet(e.get(i).src, e.get(i).dest)) {
					ds.union(e.get(i).src, e.get(i).dest);
					total+=e.get(i).weight;
				}
			System.out.println(total+minStart);
		}
	}
	
	static int cost(int a, int b) {
		int total = 0;
		for(int i=0; i<4; i++) {
			int n1 = a%10;
			int n2 = b%10;
			int d1 = Math.abs(n1-n2);
			int d2 = 10-d1;
			total+=Math.min(d1, d2);
			a/=10;
			b/=10;
		}
		return total;
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
