import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10551 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			BigInteger b = sc.nextBigInteger();
			if(b.equals(BigInteger.ZERO)) break;
			char[] s1 = sc.next().toCharArray();
			char[] s2 = sc.next().toCharArray();
			BigInteger p = new BigInteger(s1[0]+"");
			for(int i=1; i<s1.length; i++) p = p.multiply(b).add(new BigInteger(s1[i]+""));
			BigInteger m = new BigInteger(s2[0]+"");
			for(int i=1; i<s2.length; i++) m = m.multiply(b).add(new BigInteger(s2[i]+""));
			p = p.mod(m);
			StringBuilder sb = new StringBuilder();
			while(!p.equals(BigInteger.ZERO)) {
				sb.append(p.mod(b));
				p = p.divide(b);
			}
			System.out.println(sb.length()==0 ? "0" : sb.reverse());
		}
	}
}
