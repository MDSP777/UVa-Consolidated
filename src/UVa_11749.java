import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_11749 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int k = Integer.parseInt(split[1]);
			if(n==0 && k==0) break;
			ArrayList<Edge> e = new ArrayList<>();
			while(k-->0){
				split = br.readLine().split(" ");
				e.add(new Edge(Integer.parseInt(split[0])-1, Integer.parseInt(split[1])-1, Integer.parseInt(split[2])));
			}
			Collections.sort(e);
			DisjointSet ds = new DisjointSet(n);
			for(int i=0; i<e.size() && e.get(i).weight==e.get(0).weight; i++) ds.union(e.get(i).src, e.get(i).dest);
			int max = 0;
			for(int i=0; i<n; i++) max = Math.max(max, ds.size[i]);
			System.out.println(max);
		}
	}
	
	static class DisjointSet {
		int[] p;
		int[] rank;
		int[] size;
		
		public DisjointSet(int n) {
			p = new int[n];
			rank = new int[n];
			size = new int[n];
			for(int i=0; i<n; i++){
				p[i] = i;
				size[i] = 1;
			}
		}
		
		int findSet(int i){
			return p[i]==i ? i : (p[i] = findSet(p[i]));
		}
		
		boolean isSameSet(int i, int j){
			return findSet(i)==findSet(j);
		}
		
		void union(int i, int j){
			if(!isSameSet(i, j)){
				int x = findSet(i);
				int y = findSet(j);
				if(rank[y]>rank[x]){
					p[x] = y;
				} else {
					p[y] = x;
					if(rank[x]==rank[y]) rank[x]++;
				}
				size[y]+=size[x];
				size[x] = size[y];
			}
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int src, dest, weight;
		
		Edge(int s, int d, int w){
			src = s;
			dest = d;
			weight = w;
		}

		@Override
		public int compareTo(Edge o) {
			return o.weight-weight;
		}
	}
}
