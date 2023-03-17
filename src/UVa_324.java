import java.math.BigInteger;
import java.util.Scanner;


public class UVa_324 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		BigInteger[] f = new BigInteger[370];
		f[0] = BigInteger.ONE;
		f[1] = BigInteger.ONE;
		for(int i=2; i<370; i++) f[i] = new BigInteger(i+"").multiply(f[i-1]);
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			int[] count = new int[10];
			String s = f[n].toString();
			for(int i=0; i<s.length(); i++) count[s.charAt(i)-'0']++;
			System.out.println(n+"! --");
			System.out.printf("   (0)%5d    (1)%5d    (2)%5d    (3)%5d    (4)%5d\n", count[0], count[1], count[2], count[3], count[4]);
			System.out.printf("   (5)%5d    (6)%5d    (7)%5d    (8)%5d    (9)%5d\n", count[5], count[6], count[7], count[8], count[9]);
		}
	}
}
