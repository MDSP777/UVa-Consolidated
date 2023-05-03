import java.util.Scanner;

public class UVa_11408 {
	public static void main(String[] args) {
		int cap = 5000500;
		Scanner sc = new Scanner(System.in);
		boolean[] sieve = new boolean[cap];
		int[] pfSum = new int[cap];
		for(int i=2; i<cap; i++)
			if(!sieve[i]){
				pfSum[i]+=i;
				for(int j=i+i; j<cap; j+=i){
					pfSum[j]+=i;
					sieve[j] = true;
				}
			}
		int[] count = new int[cap];
		count[2] = 1;
		for(int i=3; i<cap; i++)
			count[i] = count[i-1]+(sieve[pfSum[i]] ? 0 : 1);
		
		while(true){
			int a = sc.nextInt();
			if(a==0) break;
			int b = sc.nextInt();
			System.out.println(count[b]-count[a-1]);
		}
	}
}
