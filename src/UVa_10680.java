import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class UVa_10680 {
	static int[] sieve;
	static BitSet primePower;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int bound = 1000100;
		sieve = new int[bound];
		primePower = new BitSet();
		Arrays.fill(sieve, 1);
		for(int i=2; i<bound; i++)
			if(sieve[i]==1){
				for(int j=i+i; j<bound; j+=i) sieve[j] = i;
				for(long j=1l*i*i; j<bound && j>i; j*=i) {
					primePower.set((int)j);
				}
			}
		
		long[] lcm = new long[bound];
		lcm[1] = 1;
		for(int i=2; i<1000001; i++){
			if(sieve[i]==1) lcm[i] = lcm[i-1]*i;
			else if(primePower.get(i)) lcm[i] = lcm[i-1]*sieve[i];
			else lcm[i] = lcm[i-1];
			while(lcm[i]%10==0) lcm[i]/=10;
			lcm[i]%=1000000;
		}
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			System.out.println(lcm[n]%10);
		}
	}
}
