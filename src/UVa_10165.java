import java.util.Scanner;


public class UVa_10165 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			int x = sc.nextInt();
			while(n-->1) x^=sc.nextInt();
			System.out.println(x!=0 ? "Yes" : "No");
		}
	}
}
