import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_10662 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			String[] split = s.split(" ");
			int t = Integer.parseInt(split[0]);
			int r = Integer.parseInt(split[1]);
			int h = Integer.parseInt(split[2]);
			int[] tPrices = new int[t];
			boolean[][] tr = new boolean[t][r];
			for(int i=0; i<t; i++){
				split = br.readLine().split(" ");
				tPrices[i] = Integer.parseInt(split[0]);
				for(int j=1; j<=r; j++) tr[i][j-1] = split[j].equals("0");
			}
			int[] rPrices = new int[r];
			boolean[][] rh = new boolean[r][h];
			for(int i=0; i<r; i++){
				split = br.readLine().split(" ");
				rPrices[i] = Integer.parseInt(split[0]);
				for(int j=1; j<=h; j++) rh[i][j-1] = split[j].equals("0");
			}
			int[] hPrices = new int[h];
			boolean[][] ht = new boolean[h][t];
			for(int i=0; i<h; i++){
				split = br.readLine().split(" ");
				hPrices[i] = Integer.parseInt(split[0]);
				for(int j=1; j<=t; j++) ht[i][j-1] = split[j].equals("0");
			}
			int best = 1000000000, outT = -1, outR = -1, outH = -1;
			for(int i=0; i<t; i++)
				for(int j=0; j<r; j++)
					for(int k=0; k<h; k++)
						if(tPrices[i]+rPrices[j]+hPrices[k]<best && tr[i][j] && rh[j][k] && ht[k][i]) {
							best = tPrices[i]+rPrices[j]+hPrices[k];
							outT = i;
							outR = j;
							outH = k;
						}
			System.out.println(best==1000000000 ? "Don't get married!" : (outT+" "+outR+" "+outH+":"+best));
		}
	}
}
