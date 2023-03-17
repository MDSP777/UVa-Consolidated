import java.util.Scanner;

public class UVa_10341 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			double p = sc.nextDouble();
			double q = sc.nextDouble();
			double r = sc.nextDouble();
			double s = sc.nextDouble();
			double t = sc.nextDouble();
			double u = sc.nextDouble();
			double l = 0;
			double h = 1;
			double ans = -1;
			double eval = 1;
			for(int i=0; i<30; i++) {
				double mid = (l+h)/2;
				eval = p*Math.pow(Math.E, -mid) + q*Math.sin(mid) + r*Math.cos(mid) + s*Math.tan(mid) + t*mid*mid + u;
				if(eval>0) l = mid;
				else h = mid;
				ans = mid;
			}
			if(Math.abs(eval)>1e-8) System.out.println("No solution");
			else System.out.printf("%.4f\n", ans);
		} while(sc.hasNext());
	}
}
