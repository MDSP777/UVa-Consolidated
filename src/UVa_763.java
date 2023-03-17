import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class UVa_763 {
	static BigInteger[] f;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		f = new BigInteger[110];
		f[0] = BigInteger.ONE;
		f[1] = new BigInteger("2");
		for(int i=2; i<110; i++) f[i] = f[i-1].add(f[i-2]);
		do {
			String s1 = sc.next();
			String s2 = sc.next();
			
			BigInteger b1 = convert(s1);
			BigInteger b2 = convert(s2);
			
			System.out.println(output(b1.add(b2)));
			if(sc.hasNext()) System.out.println();
		} while(sc.hasNext());
	}

	static BigInteger convert(String s) {
		int index = 0;
		BigInteger result = new BigInteger("0");
		for(int i=s.length()-1; i>=0; i--) 
			result = result.add(new BigInteger(s.charAt(i)+"").multiply(f[index++]));
		return result;
	}
	
	static String output(BigInteger b) {
		if(b.equals(BigInteger.ZERO)) return "0";
		int index = Arrays.binarySearch(f, b);
		StringBuilder s = new StringBuilder();
		if(index<0) index = index*-1-1;
		while(index>=0) {
			if(b.compareTo(f[index])>=0) {
				s.append("1");
				b = b.subtract(f[index]);
			} else if(s.length()>0) s.append("0");
			index--;
		}
		return s.toString();
	}
}