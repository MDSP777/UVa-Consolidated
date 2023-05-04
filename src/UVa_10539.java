import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10539 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cap = 2000000;
		long cap2 = (long) 2e12;
		boolean[] sieve = new boolean[cap];
		ArrayList<Long> almostPrimes = new ArrayList<>(); 
		for(int i=2; i<cap; i++)
			if(!sieve[i]){
				for(int j=i+i; j<cap; j+=i)
					sieve[j] = true;
				for(long j=i*1l*i; j<cap2; j*=i)
					almostPrimes.add(j);
			}
		Collections.sort(almostPrimes);
		
		int tc = sc.nextInt();
		while(tc-->0){
			long a = sc.nextLong();
			long b = sc.nextLong();
			int i = Collections.binarySearch(almostPrimes, a);
			if(i<0) i = -(i+1);
			int j = Collections.binarySearch(almostPrimes, b);
			if(j<0) j = -(j+1);
			else j++;
			System.out.println(j-i);
		}
	}
}
