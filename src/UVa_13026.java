import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_13026 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			char[][] nums = new char[n][];
			for(int i=0; i<n; i++) nums[i] = br.readLine().toCharArray();
			char[] c = br.readLine().toCharArray();
			sb.append("Case ").append(t).append(":\n");
			for(int i=0; i<n; i++) {
				int diff = 0;
				for(int j=0; j<nums[i].length; j++)
					if(c[j]!=nums[i][j]) diff++;
				if(diff<=1) sb.append(nums[i]).append("\n");
			}
		}
		System.out.print(sb);
	}
}
