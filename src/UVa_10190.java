import java.util.Scanner;

public class UVa_10190 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n<=1 || m<=1 || n<m) {
				System.out.println("Boring!");
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(n);
				while(n%m==0&& n>1){
					n/=m;
					sb.append(" ").append(n);
				}
				if(n!=1) System.out.println("Boring!");
				else System.out.println(sb);
			}
		}while(sc.hasNext());
	}
}
