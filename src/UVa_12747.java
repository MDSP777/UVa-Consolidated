import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UVa_12747 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		for(int c=1; c<=nC; c++) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			int[] b = new int[n];
			String[] split = br.readLine().split(" ");
			for(int i=0; i<n; i++) a[Integer.parseInt(split[i])-1] = i;
			split = br.readLine().split(" ");
			for(int i=0; i<n; i++) b[i] = a[Integer.parseInt(split[i])-1];
			int[] I = new int[n];
			int ans = 0;
			for(int i=0; i<n; i++) I[i] = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				int index = Arrays.binarySearch(I, b[i]);
				if(index<0) index = -(index+1);
				if(b[i]<I[index]) {
					I[index] = b[i];
					ans = Math.max(ans, index+1);
				}
			}
			sb.append("Case ").append(c).append(": ").append((n-ans)*2).append("\n");
		}
		System.out.print(sb);
	}
}
