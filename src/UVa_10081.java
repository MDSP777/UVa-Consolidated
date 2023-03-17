import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class UVa_10081 {
	static int k;
	static int n;
	static BigInteger[][] memo;
	static BigInteger NEG_ONE = new BigInteger("-1");
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		do{
			k = sc.nextInt();
			n = sc.nextInt();
			BigDecimal p = new BigDecimal(k+1).pow(n);
			memo = new BigInteger[k+1][n+1];
			for(int i=0; i<=k; i++)
				for(int j=0; j<=n; j++) memo[i][j] = NEG_ONE;
			BigInteger total = BigInteger.ZERO;
			for(int i=0; i<=k; i++) total = total.add(dp(i, 1));
			BigDecimal ans = new BigDecimal(total).divide(p, MathContext.DECIMAL64).multiply(new BigDecimal(100)).setScale(5, RoundingMode.HALF_UP);
			System.out.println(ans);
		}while(sc.hasNext());
	}
	
	static BigInteger dp(int lastDigit, int length){
		if(length==n) return BigInteger.ONE;
		if(!memo[lastDigit][length].equals(NEG_ONE)) return memo[lastDigit][length];
		BigInteger ans = dp(lastDigit, length+1);
		if(lastDigit>=1) ans = ans.add(dp(lastDigit-1, length+1));
		if(lastDigit<k) ans = ans.add(dp(lastDigit+1, length+1));
		memo[lastDigit][length] = ans;
		return ans;
	}
}
