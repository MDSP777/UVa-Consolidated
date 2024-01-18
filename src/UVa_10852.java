import java.util.Scanner;
import java.util.TreeSet;

public class UVa_10852 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		boolean[] sieve = new boolean[10100];
		TreeSet<Integer> primes = new TreeSet<>();
		for(int i=2; i<=10000; i++){
			if(!sieve[i]){
				sieve[i] = true;
				for(int j=i+i; j<=10000; j+=i)
					sieve[j] = true;
				primes.add(i);
			}
		}
		
		while(tc-->0){
			System.out.println(primes.higher(sc.nextInt()/2));
		}
	}
}
