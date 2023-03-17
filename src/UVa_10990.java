import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class UVa_10990 {
	static ArrayList<Integer> primes;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		BitSet sieve = new BitSet();
		primes = new ArrayList<>();
		int bound = 2000200;
		sieve.set(2, bound);
		for(int i=2; i<bound; i++)
			if(sieve.get(i)){
				primes.add(i);
				for(int j=i+i; j<bound; j+=i) sieve.set(j, false);
			}
		long[] depth = new long[bound];
		long[] sum = new long[bound];
		for(int i=2; i<bound; i++){
			int e = euler(i);
			depth[i] = 1+depth[e];
			sum[i] = depth[i]+sum[i-1];
		}
		int tc = sc.nextInt();
		while(tc-->0){
			int l = sc.nextInt();
			int r = sc.nextInt();
			System.out.println(sum[r]-sum[l-1]);
		}
	}
	
	static int euler(int n){
		int pIndex = 0;
		int p = primes.get(pIndex);
		int ans = n;
		while(p*p<=n){
			if(n%p==0) ans-=ans/p;
			while(n%p==0) n/=p;
			p = primes.get(++pIndex);
		}
		if(n!=1) ans-=ans/n;
		return ans;
	}
}
