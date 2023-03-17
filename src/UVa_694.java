import java.util.Scanner;

public class UVa_694 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(true) {
			long a = sc.nextLong();
			long l = sc.nextLong();
			if(a==-1 && l==-1) break;
			System.out.println("Case "+t+++": A = "+a+", limit = "+l+", number of terms = "+collatz(a, l));
		}
	}

	private static int collatz(long a, long l) {
		int total = 1;
		while(a!=1 && a<=l) {
			if(a%2==1) {
				a*=3;
				a++;
			} else a/=2;
			if(a<=l) total++;
		}
		return total;
	}
}
