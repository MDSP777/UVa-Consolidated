import java.util.Scanner;

public class UVa_580 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] f = new int[31];
		f[1] = 2;
		f[2] = 4;
		f[3] = 7;
		for(int i=4; i<=30; i++) f[i] = f[i-1]+f[i-2]+f[i-3];
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			System.out.println((int)Math.pow(2, n)-f[n]);
		}
	}
}
