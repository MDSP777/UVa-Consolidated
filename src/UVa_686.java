import java.util.Scanner;

public class UVa_686 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] sieve = new boolean[40000];
		for(int i=2; i<40000; i++) sieve[i] = true;
		for(int i=2; i<40000; i++)
			if(sieve[i])
				for(int j=i*2; j<40000; j+=i) sieve[j] = false;
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			int total = 0;
			for(int i=n-1; i>=n/2; i--) 
				if(sieve[i] && sieve[n-i]) total++;
			System.out.println(total);
		}
	}
}
