import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_11835 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s.equals("0 0")) break;
			String[] split = s.split("\\s+");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			int[][] grid = new int[r][c];
			for(int i=0; i<r; i++) {
				split = br.readLine().split("\\s+");
				for(int j=0; j<c; j++) grid[i][j] = Integer.parseInt(split[j])-1;
			}
			int q = Integer.parseInt(br.readLine());
			while(q-->0) {
				StringBuilder sb = new StringBuilder();
				int[] scores = new int[c];
				int[] vals = new int[c];
				split = br.readLine().split("\\s+");
				for(int i=1; i<split.length; i++) vals[i-1] = Integer.parseInt(split[i]);
				int max = 0;
				for(int i=0; i<c; i++)
					for(int j=0; j<r; j++) {
						scores[i]+=vals[grid[j][i]];
						max = Math.max(max, scores[i]);
					}
				for(int i=0; i<c; i++) if(scores[i]==max) sb.append(i+1).append(" ");
				System.out.println(sb.toString().trim());
			}
		}
	}
}
