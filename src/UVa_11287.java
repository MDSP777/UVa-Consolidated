import java.math.BigInteger;
import java.util.Scanner;

public class UVa_11287 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			BigInteger p = sc.nextBigInteger();
			BigInteger a = sc.nextBigInteger();
			if(a.equals(BigInteger.ZERO) && p.equals(BigInteger.ZERO)) break;
			System.out.println(!p.isProbablePrime(1) && a.modPow(p, p).equals(a) ? "yes" : "no");
		}
	}
}
