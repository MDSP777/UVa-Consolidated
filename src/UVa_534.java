import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;

public class UVa_534 {
	static boolean foundDest;
	static double maxEdge;
	static ArrayList<Edge>[] mstE;
	static BitSet visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = 1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			double[] x = new double[n];
			double[] y = new double[n];
			mstE = new ArrayList[n];
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split(" ");
				x[i] = Double.parseDouble(split[0]);
				y[i] = Double.parseDouble(split[1]);
				mstE[i] = new ArrayList<>();
			}
			ArrayList<Edge> e = new ArrayList<>();
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++) e.add(new Edge(i, j, Math.sqrt(Math.pow(x[i]-x[j], 2)+Math.pow(y[i]-y[j], 2))));
			Collections.sort(e);
			DisjointSet ds = new DisjointSet(n);
			for(int i=0; i<e.size(); i++)
				if(!ds.isSameSet(e.get(i).src, e.get(i).dest)) {
					ds.union(e.get(i).src, e.get(i).dest);
					mstE[e.get(i).src].add(new Edge(e.get(i).src, e.get(i).dest, e.get(i).weight));
					mstE[e.get(i).dest].add(new Edge(e.get(i).dest, e.get(i).src, e.get(i).weight));
				}
			foundDest = false;
			maxEdge = 0;
			visited = new BitSet();
			dfs(0, 1);
			System.out.println("Scenario #"+c++);
			System.out.printf("Frog Distance = %.3f\n\n", maxEdge);
			br.readLine();
		}
	}
	
	static void dfs(int src, int dest) {
		visited.set(src);
		if(src==dest) foundDest = true;
		else 
			for(int i=0; i<mstE[src].size(); i++) 
				if(!visited.get(mstE[src].get(i).dest) && !foundDest) {
					dfs(mstE[src].get(i).dest, dest);
					if(foundDest) maxEdge = Math.max(maxEdge, mstE[src].get(i).weight);
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
