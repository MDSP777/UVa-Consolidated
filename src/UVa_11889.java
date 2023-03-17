import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;
import java.util.TreeMap;


public class UVa_11889 {
	static ArrayList<Integer> primes;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		BitSet sieve = new BitSet();
		int bound = 20002000;
		sieve.set(2, bound);
		primes = new ArrayList<>();
		for(int i=2; i<bound; i++)
			if(sieve.get(i)){
				primes.add(i);
				for(int j=i+i; j<bound; j+=i) sieve.set(j,false);
			}
		while(tc-->0){
			int a = sc.nextInt();
			int c = sc.nextInt();
			if(c%a!=0) System.out.println("NO SOLUTION");
			else System.out.println(f(a, c)); 
		}
	}
	
	static int f(int a, int c){
		TreeMap<Integer, Integer> f1 = getFactors(a);
		TreeMap<Integer, Integer> f2 = getFactors(c);
		int ans = 1;
		for(int k: f1.keySet()) if(!f2.containsKey(k)) f2.put(k, 0);
		for(int k: f2.keySet())
			if(!f1.containsKey(k) || f2.get(k)>f1.get(k)) ans*=pow(k, f2.get(k));
		return ans;
	}
	
	static int pow(int b, int p){
		int ans = 1;
		while(p-->0) ans*=b;
		return ans;
	}
	
	static TreeMap<Integer, Integer> getFactors(int n){
		TreeMap<Integer, Integer> factors = new TreeMap<>();
		int pIndex = 0;
		int p = primes.get(pIndex);
		while(p*p<=n){
			while(n%p==0){
				factors.put(p, factors.containsKey(p) ? factors.get(p)+1 : 1);
				n/=p;
			}
			p = primes.get(++pIndex);
		}
		if(n!=1) factors.put(n, factors.containsKey(n) ? factors.get(n)+1 : 1);
		return factors;
	}
}
