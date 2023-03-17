import java.util.Scanner;


public class UVa_13059 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			long n = sc.nextLong();
			System.out.println((long)Math.ceil(Math.log(n)/Math.log(2)));
		}while(sc.hasNext());
	}
}
