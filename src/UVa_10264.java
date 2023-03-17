import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_10264 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			int n = Integer.parseInt(s);
			int len = (int)Math.pow(2, n);
			int[] terms = new int[len];
			int[] sums = new int[len];
			for(int i=0; i<len; i++) {
				terms[i] = Integer.parseInt(br.readLine());
				sums[i] = terms[i];
			}
			for(int i=0; i<len; i++) 
				for(int j=0; j<n; j++) sums[i]+=terms[i^(1<<j)];
			int max = 0;
			for(int i=0; i<len; i++) 
				for(int j=0; j<n; j++) {
					int cur = sums[i]+sums[i^(1<<j)]-terms[i]-terms[i^(1<<j)];
					max = Math.max(max, cur);
				}
			System.out.println(max);
		}
	}
}
