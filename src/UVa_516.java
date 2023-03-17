import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class UVa_516 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] sieve = new boolean[40000];
		ArrayList<Integer> primes = new ArrayList<>();
		Arrays.fill(sieve, true);
		sieve[0] = sieve[1] = false;
		for(int i=2; i<40000; i++)
			if(sieve[i]){
				primes.add(i);
				for(int j=i+i; j<40000; j+=i) sieve[j] = false;
			}
		while(true){
			String s = br.readLine();
			if(s.equals("0")) break;
			String[] split = s.split(" ");
			int n = 1;
			for(int i=0; i<split.length; i+=2) n*=pow(Integer.parseInt(split[i]), Integer.parseInt(split[i+1]));
			n--;
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
			StringBuilder sb = new StringBuilder();
			for(int k : factors.descendingKeySet()) sb.append(k).append(" ").append(factors.get(k)).append(" ");
			System.out.println(sb.toString().trim());
		}
	}
	
	static int pow(int b, int e){
		int ans = 1;
		while(e-->0) ans*=b;
		return ans;
	}
}
