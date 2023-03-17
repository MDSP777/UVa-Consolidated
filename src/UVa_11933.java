import java.util.Scanner;

public class UVa_11933 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			int a = 0;
			int b = 0;
			int index = 0;
			boolean odd = true;
			while(n>0) {
				if(n%2==1) {
					if(odd) a|=1<<index;
					else b|=1<<index;
					odd = !odd;
				}
				n>>=1;
				index++;
			}
			System.out.println(a+" "+b);
		}
	}
}
