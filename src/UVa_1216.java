import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_1216 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			int nF = Integer.parseInt(br.readLine());
			ArrayList<Double> x = new ArrayList<>();
			ArrayList<Double> y = new ArrayList<>();
			while(true) {
				String s = br.readLine();
				if(s.equals("-1")) break;
				String[] split = s.split(" ");
				x.add(Double.parseDouble(split[0]));
				y.add(Double.parseDouble(split[1]));
			}
			ArrayList<Edge> e = new ArrayList<>();
			for(int i=0; i<x.size(); i++)
				for(int j=i+1; j<y.size(); j++) e.add(new Edge(i, j, Math.sqrt(Math.pow(x.get(i)-x.get(j), 2)+Math.pow(y.get(i)-y.get(j), 2))));
			Collections.sort(e);
			int nS = x.size();
			double maxEdge = 0;
			DisjointSet ds = new DisjointSet(nS);
			for(int i=0; i<e.size(); i++) {
				if(nS==nF) break;
				if(!ds.isSameSet(e.get(i).src, e.get(i).dest)) {
					ds.union(e.get(i).src, e.get(i).dest);
					nS--;
					maxEdge = Math.max(maxEdge, e.get(i).weight);
				}
			}
			System.out.println((int)Math.ceil(maxEdge));
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
