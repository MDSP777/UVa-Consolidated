import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_10034 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			br.readLine();
			int n = Integer.parseInt(br.readLine());
			double[] x = new double[n];
			double[] y = new double[n];
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split("\\s+");
				x[i] = Double.parseDouble(split[0]);
				y[i] = Double.parseDouble(split[1]);
			}
			ArrayList<Edge> e = new ArrayList<>();
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					if(i!=j) e.add(new Edge(i, j, Math.sqrt(Math.pow(x[i]-x[j], 2)+Math.pow(y[i]-y[j], 2))));
			Collections.sort(e);
			DisjointSet ds = new DisjointSet(n);
			double total = 0;
			for(int i=0; i<e.size(); i++)
				if(!ds.isSameSet(e.get(i).src, e.get(i).dest)) {
					ds.union(e.get(i).src, e.get(i).dest);
					total+=e.get(i).weight;
				}
			System.out.printf("%.2f\n", total);
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
	
	static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		double weight;
		
		public Edge(int s, int d, double w) {
			src = s;
			dest = d;
			weight = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(weight, o.weight);
		}
	}
}
