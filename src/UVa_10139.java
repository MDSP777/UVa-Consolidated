import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;
import java.util.TreeMap;


public class UVa_10139 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int bound = 20002000;
		BitSet sieve = new BitSet(bound);
		sieve.set(2, bound);
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i=2; i<bound; i++)
			if(sieve.get(i)){
				primes.add(i);
				for(int j=i+i; j<bound; j+=i) sieve.set(j, false);
			}
		do{
			long n = sc.nextLong();
			long m = sc.nextLong();
			if(m==0) System.out.println(m+" does not divide "+n+"!");
			else if(n>=m) System.out.println(m+" divides "+n+"!");
			else {
				TreeMap<Long, Integer> factors = new TreeMap<>();
				int pIndex = 0;
				long p = primes.get(pIndex);
				long cur = m;
				while(p*p<=cur){
					while(cur%p==0){
						factors.put(p, factors.containsKey(p) ? factors.get(p)+1 : 1);
						cur/=p;
					}
					p = primes.get(++pIndex);
				}
				if(cur!=1) factors.put(cur, factors.containsKey(cur) ? factors.get(cur)+1 : 1);
				pIndex = 0;
				boolean yes = true;
				for(long f : factors.keySet()){
					if(getPower(n, f)<factors.get(f)) {
						yes = false;
						break;
					}
				}
				if(yes) System.out.println(m+" divides "+n+"!");
				else System.out.println(m+" does not divide "+n+"!");
			}
		}while(sc.hasNext());
	}
	
	static long getPower(long n, long p){
		long res = 0;
	    for (long power = p ; power <= n ; power *= p)
	        res += n/power;
	    return res;
	}
}
