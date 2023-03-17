import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10147 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int n = sc.nextInt();
			double[] x = new double[n];
			double[] y = new double[n];
			for(int i=0; i<n; i++) {
				x[i] = sc.nextDouble();
				y[i] = sc.nextDouble();
			}
			ArrayList<Edge> e = new ArrayList<>();
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++) e.add(new Edge(i, j, Math.pow(x[i]-x[j], 2)+Math.pow(y[i]-y[j], 2)));
			Collections.sort(e);
			DisjointSet ds = new DisjointSet(n);
			int q = sc.nextInt();
			while(q-->0) ds.union(sc.nextInt()-1, sc.nextInt()-1);
			ArrayList<Edge> ans = new ArrayList<>();
			for(int i=0; i<e.size(); i++)
				if(!ds.isSameSet(e.get(i).src, e.get(i).dest)) {
					ds.union(e.get(i).src, e.get(i).dest);
					ans.add(e.get(i));
				}
			if(ans.size()==0) System.out.println("No new highways need");
			else for(int i=0; i<ans.size(); i++) System.out.println((ans.get(i).src+1)+" "+(ans.get(i).dest+1));
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
