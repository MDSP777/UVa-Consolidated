import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_11391 {
	static int r, c;
	static int[][] memo;
	static int bound;
	static int[] rOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] cOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++){
			String[] split = br.readLine().split(" ");
			r = Integer.parseInt(split[0]);
			c = Integer.parseInt(split[1]);
			int n = Integer.parseInt(split[2]);
			int mask = 0;
			for(int i=0; i<n; i++) {
				split = br.readLine().split(" ");
				mask|=1<<((Integer.parseInt(split[0])-1)*c+Integer.parseInt(split[1])-1);
			}
			bound = 1<<(r*c);
			memo = new int[n][bound];
			for(int i=0; i<n; i++)
				for(int j=0; j<bound; j++) memo[i][j] = -1;
			sb.append("Case ").append(t).append(": ").append(dp(n-1, mask)).append("\n");
		}
		System.out.print(sb);
	}
	
	static int dp(int steps, int mask){
		if(steps==0) return (mask==1 || mask%2==0) ? 1 : 0;
		if(memo[steps][mask]!=-1) return memo[steps][mask];
		int ans = 0;
		for(int i=0; i<r; i++)
			for(int j=0; j<c; j++)
				if((mask&(1<<(i*c+j)))!=0){
					for(int k=0; k<8; k++){
						int destR = i+rOffsets[k]*2;
						int destC = j+cOffsets[k]*2;
						int tempR = i+rOffsets[k];
						int tempC = j+cOffsets[k];
						if(destR>=0 && destR<r && destC>=0 && destC<c && (mask&(1<<(tempR*c+tempC)))!=0 && (mask&(1<<(destR*c+destC)))==0){
							int newMask = mask;
							newMask&=~(1<<(i*c+j));
							newMask&=~(1<<(tempR*c+tempC));
							newMask|=(1<<(destR*c+destC));
							ans+=dp(steps-1, newMask);
						}
					}
				}
		memo[steps][mask] = ans;
		return ans;
	}
}
