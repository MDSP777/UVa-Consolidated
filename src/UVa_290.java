import java.math.BigInteger;
import java.util.Scanner;

public class UVa_290 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			StringBuilder sb = new StringBuilder();
			String s = sc.next();
			for(int i=15; i>=2; i--) {
				try {
					BigInteger n = new BigInteger(s, i);
					BigInteger ctr = BigInteger.ZERO;
					while(!palindrome(n.toString(i))) {
						String rev = new StringBuilder(n.toString(i)).reverse().toString();
						n = n.add(new BigInteger(rev, i));
						ctr = ctr.add(BigInteger.ONE);
					}
					sb.append(ctr).append(" ");
				} catch (NumberFormatException e) {
					sb.append("? ");
				}
			}
			System.out.println(sb.toString().trim());
		} while(sc.hasNext());
	}
	
	static boolean palindrome(String s) {
		for(int i=0; i<s.length()/2; i++)
			if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
		return true;
	}
}
