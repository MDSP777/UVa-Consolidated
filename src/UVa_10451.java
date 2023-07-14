import java.util.Scanner;

public class UVa_10451 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(true) {
			int n = sc.nextInt();
			if(n<3) break;
			double A = sc.nextDouble();
			double s = Math.sqrt((4*A*Math.tan(Math.PI/n))/n);
			double h = s/(2*Math.tan(Math.PI/n));
			double r = Math.sqrt((s/2*s/2)+h*h);
			
			System.out.printf("Case %d: %.5f %.5f\n", t++, Math.PI*r*r-A, A-Math.PI*h*h);
		}
	}
}
