import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class UVa_10430 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Dear GOD, Pardon Me");
		boolean first = true;
		while(true){
			String s = br.readLine();
			if(s==null) break;
			if(first) first = false;
			else System.out.println();
			String[] split = s.split(" ");
			BigInteger t = new BigInteger(split[0]);
			int n = Integer.parseInt(split[1]);
			BigInteger k = t.pow(n);
			BigInteger x = BigInteger.ZERO;
			while(n-->0){
				x = x.add(k);
				x = x.divide(t);
			}
			System.out.println("X = "+x);
			System.out.println("K = "+k);
		}
	}
}
