import java.util.Scanner;


public class UVa_10055 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println(Math.abs(sc.nextLong()-sc.nextLong()));
		}while(sc.hasNext());
	}
}
