import java.util.Scanner;


public class UVa_10751 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] tri = new int[301];
		tri[1] = 1;
		for(int i=2; i<=300; i++) tri[i] = i+tri[i-1];
		while(tc-->0){
			int n = sc.nextInt();
			int diag = n<=2 ? 0 : n-2 + 2*tri[n-3];
			double steps = n==1 ? 0 : n==2 ? 4 : Math.sqrt(2)*(diag) + n*n - diag;
			System.out.printf("%.3f\n", steps);
			if(tc>0) System.out.println();
		}
	}
}
