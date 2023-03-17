import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_793 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		br.readLine();
		while(tc-->0){
			int n = Integer.parseInt(br.readLine());
			DisjointSet ds = new DisjointSet(n);
			int yes = 0, no = 0;
			while(true){
				String s = br.readLine();
				if(s==null || s.isEmpty()) break;
				String[] split = s.split(" ");
				int x = Integer.parseInt(split[1])-1;
				int y = Integer.parseInt(split[2])-1;
				if(split[0].equals("c")) ds.join(x, y);
				else {
					if(ds.isSameSet(x, y)) yes++;
					else no++;
				}
			}
			System.out.println(yes+","+no);
			if(tc>0) System.out.println();
		}
	}
	
	static class DisjointSet {
		int[] p;
		int[] rank;
		
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
