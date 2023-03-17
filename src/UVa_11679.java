import java.util.Scanner;

public class UVa_11679 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int b = sc.nextInt();
			int n = sc.nextInt();
			if(b==0 && n==0) break;
			int[] banks = new int[b];
			for(int i=0; i<b; i++) banks[i] = sc.nextInt();
			for(int i=0; i<n; i++) {
				int d = sc.nextInt()-1;
				int c = sc.nextInt()-1;
				int v = sc.nextInt();
				banks[d] -= v;
				banks[c] += v;
			}
			boolean success = true;
			for(int i=0; i<b; i++) 
				if(banks[i]<0) {
					success = false;
					break;
				}
			System.out.println(success ? "S" : "N");
		}
	}
}
