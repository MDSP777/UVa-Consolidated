import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_10928 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			int p = Integer.parseInt(br.readLine());
			int[] neighbors = new int[p];
			int min = Integer.MAX_VALUE;
			for(int i=0; i<p; i++) {
				neighbors[i] = br.readLine().split("\\s+").length;
				min = Math.min(min, neighbors[i]);
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<p; i++) if(neighbors[i]==min) sb.append(i+1).append(" ");
			System.out.println(sb.toString().trim());
			if(nC>0) br.readLine();
		}
	}
}
