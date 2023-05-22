import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_12608 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			String[] split = br.readLine().split(" ");
			int w = Integer.parseInt(split[0]);
			int n = Integer.parseInt(split[1]);
			int dist, weight;
			int curW = 0;
			long total = 0;
			
			for(int i=0; i<n; i++) {
				split = br.readLine().split(" ");
				dist = Integer.parseInt(split[0]);
				weight = Integer.parseInt(split[1]);
				if(curW+weight<=w) curW+=weight;
				else {
					total+=dist<<1;
					curW = weight;
				}
				
				if(curW==w) {
					total+=dist<<1;
					curW = 0;
				} else if(i==n-1) total+=dist<<1;
			}
			
			System.out.println(total);
		}
	}
}
