import java.math.BigInteger;
import java.util.Scanner;

public class UVa_11952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			String s1 = sc.next();
			sc.next();
			String s2 = sc.next();
			sc.next();
			String a = sc.next();
			if(a.equals(s1+s2) && allOnes(a+s1+s2)) {
				System.out.println(1);
				continue;
			}
			int b = 2;
			while(true) {
				try {
					BigInteger b1 = new BigInteger(s1, b);
					BigInteger b2 = new BigInteger(s2, b);
					BigInteger sum = b1.add(b2);
					if(sum.toString(b).equals(a)) break;
					b++;
				} catch (Exception e) {
					if(b>1 && e.getMessage().contains("Radix out of range")) {
						b = 0;
						break;
					}
					b++;
				}
			}
			System.out.println(b);
		}
	}
	
	static boolean allOnes(String s) {
		for(int i=0; i<s.length(); i++) if(s.charAt(i)!='1') return false;
		return true;
	}
}
