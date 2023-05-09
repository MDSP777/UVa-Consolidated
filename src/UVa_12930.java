import java.math.BigDecimal;
import java.util.Scanner;


public class UVa_12930 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		do{
			BigDecimal a = new BigDecimal(sc.next());
			BigDecimal b = new BigDecimal(sc.next());
			int x = a.compareTo(b);
			System.out.println("Case "+t+++": "+(x==0 ? "Same" : (x<0 ? "Smaller" : "Bigger")));
		}while(sc.hasNext());
	}
}
