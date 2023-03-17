import java.util.Scanner;

public class UVa_900 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] f = new long[55];
		f[1] = 1;
		f[2] = 2;
		for(int i=3; i<55; i++) f[i] = f[i-1]+f[i-2];
		while(true) {
			int l = sc.nextInt();
			if(l==0) break;
			System.out.println(f[l]);
		}
	}
}
