import java.util.Scanner;

public class UVa_993 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0) {
			int n = sc.nextInt();
			if(n<2) System.out.println(n);
			else {
				StringBuilder sb = new StringBuilder();
				for(int i=9; n>1 && i>=2; i--)
					while(n>1 && n%i==0) {
						n/=i;
						sb.append(i);
					}
				System.out.println(n==1 ? sb.reverse() : -1);
			}
		}
	}
}
