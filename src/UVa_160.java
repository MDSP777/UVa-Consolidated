import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;


public class UVa_160 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] sieve = new boolean[101];
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i=2; i<101; i++)
			if(!sieve[i]){
				primes.add(i);
				for(int j=i+i; j<101; j+=i) sieve[j] = true;
			}
		
		HashMap<Integer, Integer>[] primeFactors = new HashMap[105];
		for(int i=2; i<101; i++){
			int curN = i;
			primeFactors[i] = new HashMap<>();
			HashMap<Integer, Integer> curMap = primeFactors[i];
			for(int j=0; curN>0 && j<primes.size(); j++){
				int p = primes.get(j);
				while(curN%p==0 && curN>0){
					curN/=p;
					if(!curMap.containsKey(p)) curMap.put(p, 0);
					curMap.put(p, curMap.get(p)+1);
				}
			}
		}
		
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			TreeMap<Integer, Integer> ans = new TreeMap<>();
			for(int i=2; i<=n; i++){
				HashMap<Integer, Integer> curMap = primeFactors[i];
				for(int key : curMap.keySet()){
					if(!ans.containsKey(key)) ans.put(key, 0);
					ans.put(key, ans.get(key)+curMap.get(key));
				}
			}
			System.out.printf("%3s! =", n);
			int ctr = 0;
			for(int key : ans.keySet()){
				System.out.printf("%3s", ans.get(key));
				ctr++;
				if(ctr%15==0) System.out.printf("%s", ctr==ans.size() ? "\n" : "\n      ");
			}
			if(ctr%15!=0) System.out.println();
		}
	}
}
