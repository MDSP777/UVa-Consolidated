import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class UVa_10179 {
	static ArrayList<Integer> primes;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		BitSet sieve = new BitSet();
		int bound = 1000000;
		sieve.set(2, bound);
		primes = new ArrayList<>();
		for(int i=2; i<bound; i++)
			if(sieve.get(i)){
				primes.add(i);
				for(int j=i+i; j<bound; j+=i) sieve.set(j, false);
			}
		while(true){
			long n = sc.nextInt();
			if(n==0) break;
			System.out.println(euler(n));
		}
	}
	
	static long euler(long n){
		int pIndex = 0;
		int p = primes.get(pIndex);
		long ans = n;
		while(p*p<=n){
			if(n%p==0) ans-=ans/p;
			while(n%p==0) n/=p;
			p = primes.get(++pIndex);
		}
		if(n!=1) ans-=ans/n;
		return ans;
	}
}
