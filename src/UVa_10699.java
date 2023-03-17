import java.util.BitSet;
import java.util.Scanner;

public class UVa_10699 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		BitSet sieve = new BitSet();
		int bound = 1000000;
		sieve.set(2, bound);
		int[] numPF = new int[bound];
		for(int i=2; i<bound; i++)
			if(sieve.get(i)){
				if(numPF[i]==0) for(int j=i; j<bound; j+=i) numPF[j]++;
				for(int j=i+i; j<bound; j+=i) sieve.set(j, false);
			}
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			System.out.println(n+" : "+numPF[n]);
		}
	}
}
