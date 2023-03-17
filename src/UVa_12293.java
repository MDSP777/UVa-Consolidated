import java.util.HashSet;
import java.util.Scanner;


public class UVa_12293 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long ans = 1;
		HashSet<Long> lose = new HashSet<>();
		long jump = 2;
		while(true){
			lose.add(ans);
			ans+=jump;
			jump*=2;
			if(ans>10e9) break;
		}
		while(true){
			long n = sc.nextLong();
			if(n==0) break;
			System.out.println(lose.contains(n) ? "Bob" : "Alice");
		}
	}
}
