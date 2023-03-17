import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;
import java.util.TreeMap;


public class UVa_11466 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int bound = 10000000;
		BitSet sieve = new BitSet();
		ArrayList<Long> primes = new ArrayList<>();
		sieve.set(2, bound);
		for(int i=2; i<bound; i++)
			if(sieve.get(i)){
				primes.add((long)i);
				for(int j=i+i; j<bound; j+=i) sieve.set(j, false);
			}
		while(true){
			long n = sc.nextLong();
			if(n==0) break;
			if(n<0) n*=-1;
			TreeMap<Long, Integer> factors = new TreeMap<>();
			int pIndex = 0;
			long p = primes.get(pIndex);
			while(p*p<=n){
				while(n%p==0){
					factors.put(p, factors.containsKey(p) ? factors.get(p)+1 : 1);
					n/=p;
				}
				p = primes.get(++pIndex);
			}
			if(n!=1) factors.put(n, factors.containsKey(n) ? factors.get(n)+1 : 1);
			System.out.println(factors.size()<2 ? -1 : factors.lastKey());
		}
	}
}
