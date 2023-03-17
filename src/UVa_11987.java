import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_11987 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			DisjointSet ds = new DisjointSet(n);
			while(m-->0){
				split = br.readLine().split(" ");
				if(split[0].equals("1")) ds.union(Integer.parseInt(split[1])-1, Integer.parseInt(split[2])-1);
				else if(split[0].equals("2")) ds.move(Integer.parseInt(split[1])-1, Integer.parseInt(split[2])-1);
				else {
					int x = ds.findSet(Integer.parseInt(split[1])-1);
					sb.append(ds.size[x]).append(" ").append(ds.sum[x]).append("\n");
				}
			}
		}
		System.out.print(sb);
	}
	
	static class DisjointSet {
		int[] p;
		int[] rank;
		int[] size;
		int[] sum;
		
		public DisjointSet(int n) {
			p = new int[n*2];
			rank = new int[n*2];
			size = new int[n*2];
			sum = new int[n*2];
			for(int i=0, j=n; i<n; i++, j++) {
				sum[j] = i+1;
				p[i] = p[j] = j;
				size[j] = 1;
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
				if(rank[y]>rank[x]) p[x] = y;
				else{
					p[y] = x;
					if(rank[x]==rank[y]) rank[x]++;
				}
				size[x]+=size[y];
				size[y] = size[x];
				sum[x]+=sum[y];
				sum[y] = sum[x];
			}
		}
		
		void move(int a, int s){
			if(!isSameSet(a, s)){
				int x = findSet(a);
				size[x]--;
				sum[x]-=a+1;
				int y = findSet(s);
				p[a] = y;
				sum[y]+=a+1;
				size[y]++;
			}
		}
	}
}
