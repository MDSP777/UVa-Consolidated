import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class UVa_10669 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger[] pows = new BigInteger[70];
		BigInteger t = new BigInteger("3");
		pows[0] = BigInteger.ONE;
		for(int i=1; i<70; i++) pows[i] = pows[i-1].multiply(t);
		StringBuilder sb = new StringBuilder();
		BigInteger two = new BigInteger("2");
		while(true) {
			BigInteger n = sc.nextBigInteger();
			if(n.equals(BigInteger.ZERO)) break;
			n = n.subtract(BigInteger.ONE);
			ArrayList<Integer> ans = new ArrayList<>();
			int c = 0;
			while(!n.equals(BigInteger.ZERO)) {
				BigInteger m = n.mod(two);
				if(m.equals(BigInteger.ONE)) ans.add(c);
				n = n.divide(two);
				c++;
			}
			if(ans.isEmpty()) sb.append("{ }\n");
			else {
				sb.append("{ ");
				sb.append(pows[ans.get(0)]);
				for(int i=1; i<ans.size(); i++) sb.append(", ").append(pows[ans.get(i)]);
				sb.append(" }\n");
			}
		}
		System.out.print(sb);
	}
}
