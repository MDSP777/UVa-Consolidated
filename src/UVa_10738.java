import java.util.BitSet;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_10738 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int bound = 1000100;
		BitSet sieve = new BitSet();
		sieve.set(2, bound);
		BitSet squareFree = new BitSet();
		squareFree.set(1, bound);
		int[] mu = new int[bound];
		int[] m = new int[bound];
		int[] numPF = new int[bound];
		mu[1] = m[1] = 1;
		HashMap<Integer, Integer>[] pf = new HashMap[bound];
		for(int i=0; i<bound; i++) pf[i] = new HashMap<>();
		for(int i=2; i<bound; i++){
			if(sieve.get(i)){
				numPF[i]++;
				for(int j=i+i; j<bound; j+=i) {
					numPF[j]++;
					sieve.set(j, false);
					if(!squareFree.get(j)) continue;
					int test = j;
					if(test%i==0){
						test/=i;
						if(test%i==0) squareFree.set(j, false);
					}
				}
				mu[i] = -1;
			} else {
				mu[i] = !squareFree.get(i) ? 0 : numPF[i]%2==0 ? 1 : -1;
			}
			m[i] = mu[i]+m[i-1];
		}
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			System.out.printf("%8d%8d%8d\n", n, mu[n], m[n]);
		}
	}
}
