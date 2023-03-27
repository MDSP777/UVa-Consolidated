import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_1368 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int l = Integer.parseInt(split[1]);
			int[][] ctr = new int[l][4];
			for(int i=0; i<n; i++) {
				String s = br.readLine();
				for(int j=0; j<s.length(); j++)
					if(s.charAt(j)=='A') ctr[j][0]++;
					else if(s.charAt(j)=='C') ctr[j][1]++;
					else if(s.charAt(j)=='G') ctr[j][2]++;
					else ctr[j][3]++;
			}
			StringBuilder sb = new StringBuilder();
			int total = 0;
			for(int i=0; i<l; i++) {
				int best = 0;
				char bestChar = ' ';
				for(int j=0; j<4; j++)
					if(ctr[i][j]>best) {
						best = ctr[i][j];
						if(j==0) bestChar = 'A';
						else if(j==1) bestChar = 'C';
						else if(j==2) bestChar = 'G';
						else bestChar = 'T';
					}
				sb.append(bestChar);
				total+=n-best;
			}
			System.out.println(sb.toString()+"\n"+total);
		}
	}
}
