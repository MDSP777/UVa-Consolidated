import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UVa_111 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(true) {
			boolean done = false;
			int[] a = new int[n];
			String[] split = br.readLine().split(" ");
			for(int i=0; i<n; i++) a[i] = Integer.parseInt(split[i])-1;
			while(true) {
				String s = br.readLine();
				if(s==null) {
					done = true;
					break;
				}
				split = s.split("\\s+");
				if(split.length==1) {
					n = Integer.parseInt(split[0]);
					break;
				}
				int[] b = new int[n];
				for(int i=0; i<n; i++) b[Integer.parseInt(split[i])-1] = a[i];
				int[] dp = new int[n];
				for(int i=0; i<n; i++) dp[i] = Integer.MAX_VALUE;
				int ans = 0;
				for(int i=0; i<n; i++) {
					int index = Arrays.binarySearch(dp, b[i]);
					if(index<0) index = -(index+1);
					if(b[i]<dp[index]) {
						dp[index] = b[i];
						ans = Math.max(ans, index+1);
					}
				}
				System.out.println(ans);
			}
			if(done) break;
		}
	}
}
