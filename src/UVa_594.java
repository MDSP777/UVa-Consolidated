import java.util.Scanner;

public class UVa_594 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int n = sc.nextInt();
			String s = Integer.toBinaryString(n);
			while(s.length()<32) s = "0"+s;
			StringBuilder r = new StringBuilder();
			while(s.length()>8) {
				r.append(s.substring(s.length()-8));
				s = s.substring(0, s.length()-8);
			}
			r.append(s);
			int rev = (int) Long.parseLong(r.toString(), 2);
			System.out.println(n+" converts to "+rev);
		} while(sc.hasNext());
	}
}
