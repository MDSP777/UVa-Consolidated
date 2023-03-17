import java.util.Scanner;

public class UVa_11530 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		sc.nextLine();
		int[] vals = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4};
		for(int x=1; x<=nC; x++) {
			String s = sc.nextLine();
			int total = 0;
			for(int i=0; i<s.length(); i++) total += s.charAt(i)==' ' ? 1 : vals[s.charAt(i)-'a'];
			System.out.println("Case #"+x+": "+total);
		}
	}
}
