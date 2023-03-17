import java.util.Scanner;

public class UVa_10209 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			double n = sc.nextDouble();
			double x = Math.sqrt(3*n*n)/2;
			double c = n*(n-x) - Math.PI*n*n/6 + n*x/2;
			double b = n*n - Math.PI*n*n/4 - 2*c;
			double a = n*n - 4*b - 4*c;
			System.out.printf("%.3f %.3f %.3f\n", a, 4*b, 4*c);
		}while(sc.hasNext());
	}
}
