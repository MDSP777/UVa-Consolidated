import java.util.Scanner;

public class UVa_927 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int s = sc.nextInt();
			long[] c = new long[s+1];
			for(int i=0; i<=s; i++) c[i] = sc.nextLong();
			int d = sc.nextInt();
			int k = sc.nextInt();
			long total = 0;
			long n = 1;
			while(true) {
				long val = c[0];
				for(int i=1; i<=s; i++) val+=c[i]*Math.pow(n, i);
				total+=d*n;
				if(total>=k) {
					System.out.println(val);
					break;
				}
				n++;
			}
		}
	}
}
