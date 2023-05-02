import java.math.BigInteger;
import java.util.Scanner;

// sum of first N cubes = (sum of first N numbers)^2
public class UVa_10302 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger FOUR = new BigInteger("4");
		do{
			BigInteger n = new BigInteger(sc.next());
			BigInteger n1 = n.add(BigInteger.ONE);
			System.out.println(n.multiply(n).multiply(n1).multiply(n1).divide(FOUR));
		}while(sc.hasNext());
	}
}
