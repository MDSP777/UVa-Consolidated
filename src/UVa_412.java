import java.math.BigInteger;
import java.util.Scanner;

public class UVa_412 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			BigInteger[] nums = new BigInteger[n];
			for(int i=0; i<n; i++) nums[i] = new BigInteger(sc.next());
			int a = 0;
			int b = 0;
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++) {
					b++;
					if(nums[i].gcd(nums[j]).equals(BigInteger.ONE)) a++;
				}
			if(a==0) System.out.println("No estimate for this data set.");
			else System.out.printf("%.6f\n", Math.sqrt(6.0*b/a));
		}
	}
}
