import java.util.Scanner;


public class UVa_12611 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++){
			float r = sc.nextFloat();
			int w = (int) (r*3/2);
			int u = (int) (r*2.25);
			int v = (int) (r*2.75);
			System.out.println("Case "+t+":");
			System.out.println(-u+" "+w);
			System.out.println(v+" "+w);
			System.out.println(v+" "+-w);
			System.out.println(-u+" "+-w);
		}
	}
}
