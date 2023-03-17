import java.util.Scanner;


public class UVa_847 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			long n = sc.nextLong();
			long l = (long) (Math.log10(n)/Math.log10(18));
			long p = pow(18, l);
			System.out.println(n<=p*9 && n!=p ? "Stan wins." : "Ollie wins.");
		}while(sc.hasNext());
	}
	
	static long pow(long x, long p){
		long ans = 1;
		while(p-->0) ans*=x;
		return ans;
	}
}
