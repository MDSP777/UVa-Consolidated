import java.util.Scanner;

public class UVa_10940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ans = new int[500001];
		int cap = 2;
		int cur = 2;
		ans[1] = 1;
		for(int i=2; i<=500000; i++){
			ans[i] = cur;
			if(cur==cap){
				cap*=2;
				cur = 2;
			} else cur+=2;
		}
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			System.out.println(ans[n]);
		}
	}
}
