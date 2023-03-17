import java.util.Scanner;

public class UVa_543 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] sieve = new boolean[1000500];
		for(int i=2; i<1000500; i++) sieve[i] = true;
		for(int i=2; i<1000500; i++)
			if(sieve[i])
				for(int j=i*2; j<1000500; j+=i) sieve[j] = false;
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			int ans = -1;
			for(int i=n-3; i>=n/2; i--) 
				if(sieve[i] && i%2==1 && sieve[n-i]) {
					ans = i;
					break;
				}
			System.out.println(ans==-1 ? "Goldbach's conjecture is wrong." : (n+" = "+(n-ans)+" + "+ans));
		}
	}
}
