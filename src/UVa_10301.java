import java.util.Scanner;


public class UVa_10301 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==-1) break;
			double[] x = new double[n];
			double[] y = new double[n];
			double[] r = new double[n];
			DisjointSet ds = new DisjointSet(n);
			for(int i=0; i<n; i++){
				x[i] = sc.nextDouble();
				y[i] = sc.nextDouble();
				r[i] = sc.nextDouble();
			}
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++)
					if(intersect(x[i], y[i], r[i], x[j], y[j], r[j]))
						ds.union(i, j);
			int s = 0;
			for(int i=0; i<n; i++) s = Math.max(s, ds.size[i]);
			System.out.print("The largest component contains "+s);
			System.out.println(s==1 ? " ring." : " rings.");
		}
	}
	
	static boolean intersect(double x1, double y1, double r1, double x2, double y2, double r2){
		double centerdx = x1 - x2;
		double centerdy = y1 - y2;
		double R = Math.sqrt(centerdx * centerdx + centerdy * centerdy);
		return Math.abs(r1 - r2) <= R && R <= r1 + r2;
	}
	
	static class DisjointSet {
		int[] p;
		int[] rank;
		int[] size;
		
		public DisjointSet(int n){
			p = new int[n];
			rank = new int[n];
			size = new int[n];
			for(int i=0; i<n; i++){
				p[i] = i;
				size[i] = 1;
			}
		}
		
		public int findSet(int i){
			return p[i]==i ? i : (p[i] = findSet(p[i]));
		}
		
		public boolean isSameSet(int i, int j){
			return findSet(i)==findSet(j);
		}
		
		public void union(int i, int j){
			if(!isSameSet(i, j)){
				int x = findSet(i);
				int y = findSet(j);
				if(rank[x]>rank[y]){
					p[y] = x;
				} else{
					p[x] = y;
					if(rank[x]==rank[y]) rank[x]++;
				}
				size[x]+=size[y];
				size[y] = size[x];
			}
		}
	}
}
