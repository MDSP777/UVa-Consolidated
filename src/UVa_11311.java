import java.util.Scanner;


public class UVa_11311 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			int r = sc.nextInt();
			int c = sc.nextInt();
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = j;
			x^=c-1-j;
			x^=i;
			x^=r-1-i;
			System.out.println(x==0 ? "Hansel" : "Gretel");
		}
	}
}
