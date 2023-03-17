import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_11349 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		for(int x=1; x<=nC; x++) {
			int n = Integer.parseInt(br.readLine().split("\\s+")[2]);
			long[][] arr = new long[n][n];
			boolean sym = true;
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split("\\s+");
				for(int j=0; j<n; j++) {
					arr[i][j] = Long.parseLong(split[j]);
					sym &= arr[i][j]>=0;
				}
			}
			if(sym)
				for(int i=0; i<n; i++)
					for(int j=0; j<n/2; j++)
						sym &= arr[i][j]==arr[n-i-1][n-j-1];
			System.out.println("Test #"+x+": "+ (sym ? "Symmetric." : "Non-symmetric."));
		}
	}
}
