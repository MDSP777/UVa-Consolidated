import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

// alternate (naive) approach using only prime sieve
// still fast enough to pass given bounds of prime range
public class UVa_914v2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int cap = 1000000;
		boolean[] sieve = new boolean[cap+1];
		TreeSet<Integer> primes = new TreeSet<>();
		for(int i=2; i<=cap; i++)
			if(!sieve[i]) {
				primes.add(i);
				for(int j=i+i; j<=cap; j+=i) sieve[j] = true;
			}
		
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			String[] split = br.readLine().split("\\s+");
			int l = Integer.parseInt(split[0]);
			int r = Integer.parseInt(split[1]);
			if(l<2) l = 2;
			if(r<2) r = 2;
			int lPrime = primes.ceiling(l);
			int rPrime = primes.floor(r);
			if(lPrime==rPrime) sb.append("No jumping champion\n");
			else {
				int[] diff = new int[10000];
				int cur = lPrime;
				do {
					int prev = cur;
					cur = primes.higher(cur);
					diff[cur-prev]++;
				} while(cur!=rPrime);
				
				int best = 0, bestIdx = -1;
				for(int i=0; i<10000; i++) 
					if(diff[i]>best) {
						best = diff[i];
						bestIdx = i;
					}
				int maxCount = 0;
				for(int i=0; maxCount<2 && i<10000; i++) 
					if(diff[i]==best) maxCount++;
				if(maxCount==1) sb.append("The jumping champion is ").append(bestIdx).append("\n");
				else sb.append("No jumping champion\n");
			}
		}
		
		System.out.print(sb);
	}
}
