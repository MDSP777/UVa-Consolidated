import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_10947 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split("\\s+");
			int l = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			int maxDist = l*m;
			String[] srcInfo = br.readLine().split("\\s+");
			String[] destInfo = br.readLine().split("\\s+");
			int n = Integer.parseInt(br.readLine())+2;
			int[] x = new int[n];
			int[] y = new int[n];
			int[] r = new int[n];
			x[0] = Integer.parseInt(srcInfo[0]);
			y[0] = Integer.parseInt(srcInfo[1]);
			r[0] = Integer.parseInt(srcInfo[2]);
			x[1] = Integer.parseInt(destInfo[0]);
			y[1] = Integer.parseInt(destInfo[1]);
			r[1] = Integer.parseInt(destInfo[2]);
			for(int i=2; i<n; i++) {
				split = br.readLine().split("\\s+");
				x[i] = Integer.parseInt(split[0]);
				y[i] = Integer.parseInt(split[1]);
				r[i] = Integer.parseInt(split[2]);
			}
			double[][] adj = new double[n][n];
			for(int i=0; i<n; i++) 
				for(int j=i+1; j<n; j++) {
					double dist = Math.sqrt(Math.pow(x[i]-x[j], 2)+Math.pow(y[i]-y[j], 2))-r[i]-r[j];
					adj[i][j] = adj[j][i] = dist<=maxDist ? dist : 2000000;
				}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
			System.out.println(adj[0][1]<2000000 ? "Larry and Ryan will escape!" : "Larry and Ryan will be eaten to death.");
		}
	}
}
