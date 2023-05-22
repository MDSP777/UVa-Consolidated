import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class UVa_13150 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int q = Integer.parseInt(split[1]);
			if(n==0 && q==0) break;
			
			int[] x = new int[4000];
			int[] y = new int[4000];
			for(int i=0; i<n; i++){
				split = br.readLine().split(" ");
				x[i] = Integer.parseInt(split[0]);
				y[i] = Integer.parseInt(split[1]);
			}
			
			int[] dist = new int[40000];
			dist[0] = n;
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++){
					// using Math.hypot() will TLE
					int d = (int)Math.ceil(Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j])));
					dist[d]+=2;
				}
			
			for(int i=1; i<40000; i++)
				dist[i]+=dist[i-1];
			
			while(q-->0){
				int r = Integer.parseInt(br.readLine());
				sb.append(String.format("%.2f\n", dist[r]*1.0/n));
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
