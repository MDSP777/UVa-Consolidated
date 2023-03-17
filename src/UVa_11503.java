	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.HashMap;
	
	public class UVa_11503 {
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int nC = Integer.parseInt(br.readLine());
			while(nC-->0) {
				int nF = Integer.parseInt(br.readLine());
				int index = 0;
				int[] x = new int[nF];
				int[] y = new int[nF];
				HashMap<String, Integer> map = new HashMap<>();
				for(int i=0; i<nF; i++) {
					String[] split = br.readLine().split(" ");
					if(!map.containsKey(split[0])) map.put(split[0], index++);
					if(!map.containsKey(split[1])) map.put(split[1], index++);
					x[i] = map.get(split[0]);
					y[i] = map.get(split[1]);
				}
				DisjointSet ds = new DisjointSet(index);
				for(int i=0; i<nF; i++) {
					ds.union(x[i], y[i]);
					System.out.println(Math.max(ds.size[ds.findSet(x[i])], ds.size[ds.findSet(y[i])]));
				}
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
				for(int i=0; i<n; i++) {
					p[i] = i;
					size[i] = 1;
				}
			}
			
			int findSet(int i) {
				return i==p[i] ? i : (p[i] = findSet(p[i]));
			}
			
			boolean isSameSet(int i, int j) {
				return findSet(i)==findSet(j);
			}
			
			void union(int i, int j) {
				if(!isSameSet(i, j)) {
					int x = findSet(i);
					int y = findSet(j);
					if(rank[x]>rank[y]) {
						p[y] = x;
					} else {
						p[x] = y;
						if(rank[x]==rank[y]) rank[y]++;
					}
					size[x]+=size[y];
					size[y] = size[x];
				}
			}
		}
	}
