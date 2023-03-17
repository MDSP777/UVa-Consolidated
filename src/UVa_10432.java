import java.util.Scanner;

public class UVa_10432 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			double r = sc.nextDouble();
			double nSides = sc.nextDouble();
			double angle = 360/nSides;
			double a = r*Math.sin((90.0-angle/2)*Math.PI/180);
			double b = r*Math.cos((90.0-angle/2)*Math.PI/180);
			double area = a*b*nSides;
			System.out.printf("%.3f\n", area);
		}while(sc.hasNext());
	}
}
