import java.util.Scanner;

public class UVa_11185 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n<0) break;
			System.out.println(Integer.toString(n, 3));
		}
	}
}
