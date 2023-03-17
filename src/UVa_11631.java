import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_11631 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int q = Integer.parseInt(split[1]);
			if(n==0 && q==0) break;
			ArrayList<Edge> e = new ArrayList<>();
			int total = 0;
			while(q-->0){
				split = br.readLine().split(" ");
				e.add(new Edge(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
				total+=e.get(e.size()-1).weight;
			}
			Collections.sort(e);
			DisjointSet ds = new DisjointSet(n);
			int mst = 0;
			for(Edge cur : e)
				if(!ds.isSameSet(cur.src, cur.dest)){
					ds.join(cur.src, cur.dest);
					mst+=cur.weight;
				}
			System.out.println(total-mst);
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int src, dest, weight;
		
		Edge(int a, int b, int c){
			src = a;
			dest = b;
			weight = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return weight-o.weight;
		}
	}
	
	static class DisjointSet {
		int[] p, rank;
		
		DisjointSet(int n){
			p = new int[n];
			rank = new int[n];
			for(int i=0; i<n; i++) p[i] = i;
		}
		
		int findSet(int i){
			return p[i]==i ? i : (p[i] = findSet(p[i]));
		}
		
		boolean isSameSet(int i, int j){
			return findSet(i)==findSet(j);
		}
		
		void join(int i, int j){
			int x = findSet(i);
			int y = findSet(j);
			if(x!=y){
				if(rank[x]>rank[y]){
					p[y] = x;
				} else {
					p[x] = y;
					if(rank[x]==rank[y]) rank[y]++;
				}
			}
		}
	}
}
