import java.math.BigInteger;
import java.util.Scanner;

public class UVa_10334 {
	public static void main(String[] args) {
		BigInteger[] f = new BigInteger[1001];
		f[0] = BigInteger.ONE;
		f[1] = new BigInteger("2");
		for(int i=2; i<=1000; i++) f[i] = f[i-1].add(f[i-2]);
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(f[sc.nextInt()]);
		} while(sc.hasNext());
	}
}
