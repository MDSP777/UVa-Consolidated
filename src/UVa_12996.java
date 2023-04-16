import java.util.Scanner;

public class UVa_12996 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt(), l = sc.nextInt();
			int[] m = new int[n];
			for(int i=0; i<n; i++) {
				m[i] = sc.nextInt();
				l-=m[i];
			}
			boolean can = l>=0;
			for(int i=0; i<n; i++)
				can&=sc.nextInt()>=m[i];
			System.out.println("Case "+t+": "+(can ? "Yes" : "No"));
		}
	}
}
