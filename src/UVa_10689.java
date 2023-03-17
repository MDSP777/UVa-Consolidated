import java.util.Scanner;


public class UVa_10689 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] cycles = {60, 300, 1500, 15000};
		while(tc-->0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			int mod = (int)Math.pow(10, m);
			n%=cycles[m-1];
			if(n==0) System.out.println(a%mod);
			else if(n==1) System.out.println(b%mod);
			else {
				for(int i=2; i<=n; i++){
					int temp = b;
					b = (a+b)%mod;
					a = temp;
				}
				System.out.println(b);
			}
		}
	}
}
