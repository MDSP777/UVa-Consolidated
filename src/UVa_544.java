import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;

public class UVa_544 {
	static boolean foundDest;
	static int minEdge;
	static ArrayList<Edge>[] mstE;
	static BitSet visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 1;
		while(true) {
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int nE = Integer.parseInt(split[1]);
			if(n==0 && nE==0) break;
			ArrayList<Edge> e = new ArrayList<>();
			HashMap<String, Integer> map = new HashMap<>();
			int index = 0;
			while(nE-->0) {
				split = br.readLine().split(" ");
				if(!map.containsKey(split[0])) map.put(split[0], index++);
				if(!map.containsKey(split[1])) map.put(split[1], index++);
				e.add(new Edge(map.get(split[0]), map.get(split[1]), Integer.parseInt(split[2])));
			}
			Collections.sort(e);
			DisjointSet ds = new DisjointSet(n);
			mstE = new ArrayList[n];
			for(int i=0; i<n; i++) mstE[i] = new ArrayList<>();
			for(int i=0; i<e.size(); i++)
				if(!ds.isSameSet(e.get(i).src, e.get(i).dest)) {
					ds.union(e.get(i).src, e.get(i).dest);
					mstE[e.get(i).src].add(new Edge(e.get(i).src, e.get(i).dest, e.get(i).weight));
					mstE[e.get(i).dest].add(new Edge(e.get(i).dest, e.get(i).src, e.get(i).weight));
				}
			split = br.readLine().split(" ");
			foundDest = false;
			minEdge = Integer.MAX_VALUE;
			visited = new BitSet();
			dfs(map.get(split[0]), map.get(split[1]));
			System.out.println("Scenario #"+x++);
			System.out.println(minEdge+" tons\n");
		}
	}
	
	static void dfs(int src, int dest) {
		visited.set(src);
		if(src==dest) foundDest = true;
		else 
			for(int i=0; i<mstE[src].size(); i++) 
				if(!visited.get(mstE[src].get(i).dest) && !foundDest) {
					dfs(mstE[src].get(i).dest, dest);
					if(foundDest) minEdge = Math.min(minEdge, mstE[src].get(i).weight);
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
		int weight;
		
		public Edge(int s, int d, int w) {
			src = s;
			dest = d;
			weight = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(o.weight, weight);
		}
	}
}
