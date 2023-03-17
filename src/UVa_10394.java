import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UVa_10394 {
	public static void main(String[] args){
		int bound = 20002000;
		Scanner sc = new Scanner(System.in);
		boolean[] sieve = new boolean[bound];
		Arrays.fill(sieve, true);
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i=2; i<bound; i++)
			if(sieve[i]){
				primes.add(i);
				for(int j=i+i; j<bound; j+=i) sieve[j] = false;
			}
		System.out.println(primes.size());
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		for(int i=1; i<primes.size(); i++)
			if(primes.get(i)-primes.get(i-1)==2){
				x.add(primes.get(i-1));
				y.add(primes.get(i));
			}
		do{
			int n = sc.nextInt()-1;
			System.out.println("("+x.get(n)+", "+y.get(n)+")");
		}while(sc.hasNext());
	}
}
