import java.util.Scanner;

public class UVa_13244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0) {
			long n = sc.nextLong();
			System.out.println(((n+1)/2)*((n+1)/2) * 2 - n);
		}
	}
}
