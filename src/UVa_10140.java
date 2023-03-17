import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;

public class UVa_10140 {
	static BitSet sieve;
	static int bound = 20002000;
	static ArrayList<Integer> primes;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sieve = new BitSet();
		sieve.set(2, bound);
		primes = new ArrayList<>();
		for(int i=2; i<bound; i++)
			if(sieve.get(i)){
				primes.add(i);
				for(int j=i+i; j<bound; j+=i) sieve.set(j, false);
			}
		do{
			String x = br.readLine();
			if(x==null) break;
			String[] split = x.split(" ");
			int l = Integer.parseInt(split[0]);
			int r = Integer.parseInt(split[1]);
			ArrayList<Integer> p = new ArrayList<>();
			for(long i=l; i<=r; i++) if(isPrime((int)i)) p.add((int)i);
			int s1 = 0, s2 = 0;
			int min = 10000000, max = 0;
			for(int i=1; i<p.size(); i++){
				int diff = p.get(i)-p.get(i-1);
				if(diff<min){
					min = diff;
					s1 = i-1;
				}
				if(diff>max){
					max = diff;
					s2 = i-1;
				}
			}
			if(p.size()<2) System.out.println("There are no adjacent primes.");
			else System.out.println(p.get(s1)+","+p.get(s1+1)+" are closest, "+p.get(s2)+","+p.get(s2+1)+" are most distant.");
		}while(true);
	}
	
	static boolean isPrime(int n){
		if(n<bound) return sieve.get(n);
		int sq = (int)Math.sqrt(n);
		for(int i=0; i<primes.size() && primes.get(i)<=sq; i++) if(n%primes.get(i)==0) return false;
		return true;
	}
}
