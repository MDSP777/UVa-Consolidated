import java.util.Scanner;

public class UVa_446 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			String hex1 = sc.next();
			String oper = sc.next();
			String hex2 = sc.next();
			System.out.println(toBinary(hex1)+" "+oper+" "+toBinary(hex2)+" = "+(oper.equals("+") ? toDecimal(hex1)+toDecimal(hex2) : toDecimal(hex1)-toDecimal(hex2)));
		}
	}

	static String toBinary(String hex) {
		int n = toDecimal(hex);
		StringBuilder sb = new StringBuilder();
		while(n>0) {
			sb.append(n%2);
			n/=2;
		}
		String s = sb.reverse().toString();
		while(s.length()<13) s = "0"+s;
		return s;
	}
	
	static int toDecimal(String hex) {
		int n = (hex.charAt(0)>='0' && hex.charAt(0)<='9') ? hex.charAt(0)-'0' : hex.charAt(0)-'A'+10;
		for(int i=1; i<hex.length(); i++) {
			n *= 16;
			n += (hex.charAt(i)>='0' && hex.charAt(i)<='9') ? hex.charAt(i)-'0' : hex.charAt(i)-'A'+10;
		}
		return n;
	}
}
