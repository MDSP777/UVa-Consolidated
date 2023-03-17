import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class UVa_10069 {
	static char[] s;
	static char[] z;
	static BigInteger[][] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			s = br.readLine().toCharArray();
			z = br.readLine().toCharArray();
			memo = new BigInteger[s.length+1][z.length+1];
			for(int i=0; i<=s.length; i++)
				for(int j=0; j<=z.length; j++) memo[i][j] = new BigInteger("-1");
			System.out.println(dp(0, 0));
		}
	}
	
	static BigInteger dp(int sIndex, int zIndex){
		if(zIndex==z.length) return BigInteger.ONE;
		if(sIndex==s.length) return BigInteger.ZERO;
		if(!memo[sIndex][zIndex].equals(new BigInteger("-1"))) return memo[sIndex][zIndex];
		BigInteger ans = dp(sIndex+1, zIndex);
		if(s[sIndex]==z[zIndex]) ans = ans.add(dp(sIndex+1, zIndex+1));
		memo[sIndex][zIndex] = ans;
		return ans;
	}
}
