import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class UVa_10419 {
	static int[][][] memo;
	static ArrayList<Integer> primes;
	static BitSet sieve;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		primes = new ArrayList<>();
		sieve = new BitSet();
		sieve.set(2, 310);
		for(int i=2; i<=300; i++)
			if(sieve.get(i)){
				primes.add(i);
				for(int j=i+i; j<=300; j+=i) sieve.set(j, false);
			}
		Collections.sort(primes, new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				return x.toString().compareTo( y.toString() );
			}
		});
		int nPrimes = primes.size();
		memo = new int[15][1010][nPrimes];
		int tc = 1;
		for(int i=0; i<15; i++) 
			for(int j=0; j<1010; j++)
				Arrays.fill(memo[i][j], -1);
		while(true){
			int n = sc.nextInt();
			int t = sc.nextInt();
			if(n==0 && t==0) break;
			System.out.println("CASE "+tc+++":");
			if(dp(n, t, 0)<0) System.out.println("No Solution.");
			else {
				int cur = dp(n, t, 0);
				int val = n;
				int count = 0;
				StringBuilder sb = new StringBuilder();
				while(val>0 && count++<100){
					val-=cur;
					int nTerms = (cur>2 && cur%2==0) ? 2 : 1;
					if(nTerms==2) cur/=2;
					t-=nTerms;
					sb.append(cur).append("+");
					if(nTerms==2) sb.append(cur).append("+");
					cur = dp(val, t, primes.indexOf(cur)+1);
				}
				System.out.println(sb.toString().substring(0, sb.length()-1));
			}
		}
	}
	
	static int dp(int n, int t, int pIndex){
		if(pIndex==primes.size() || n<0 || t<1) return -2;
		if(t==1 && primes.get(pIndex)==n) return n;
		if(t==2 && primes.get(pIndex)*2==n && primes.get(pIndex)!=2) return n;
		if(memo[t][n][pIndex]!=-1) return memo[t][n][pIndex];
		if(primes.get(pIndex)!=2 && dp(n-primes.get(pIndex)*2, t-2, pIndex+1)>0){
			memo[t][n][pIndex] = 2*primes.get(pIndex);
		} else if(dp(n-primes.get(pIndex), t-1, pIndex+1)>0){
			memo[t][n][pIndex] = primes.get(pIndex);
		} else if(dp(n, t, pIndex+1)>0){
			memo[t][n][pIndex] = dp(n, t, pIndex+1);
		} else {
			memo[t][n][pIndex] = -2;
		}
		return memo[t][n][pIndex];
	}
}
