import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_10855 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String[] split = br.readLine().split(" ");
			int s = Integer.parseInt(split[0]);
			int n = Integer.parseInt(split[1]);
			if(s==0 && n==0) break;
			char[][] grid = new char[s][s];
			for(int i=0; i<s; i++) grid[i] = br.readLine().toCharArray();
			char[][][] small = new char[4][n][n];
			for(int i=0; i<n; i++) small[0][i] = br.readLine().toCharArray();
			for(int k=1; k<4; k++) {
				for(int i=0; i<n; i++) {
					int oldI = n-1;
					for(int j=0; j<n; j++) 
						small[k][i][j] = small[k-1][oldI--][i];
				}
			}
			int[] total = new int[4];
			for(int i=0; i<=s-n; i++)
				for(int j=0; j<=s-n; j++) {
					boolean[] success = new boolean[4];
					for(int k=0; k<4; k++) success[k] = true;
					for(int k=0; k<4; k++)
						for(int i2 = i; i2<i+n && success[k]; i2++)
							for(int j2=j; j2<j+n && success[k]; j2++) 
								if(small[k][i2-i][j2-j]!=grid[i2][j2]) success[k] = false;
					for(int k=0; k<4; k++) if(success[k]) total[k]++;
				}
			sb.append(total[0]);
			for(int i=1; i<4; i++) sb.append(" ").append(total[i]);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
