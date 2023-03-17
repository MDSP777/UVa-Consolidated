import java.util.Arrays;
import java.util.Scanner;

public class UVa_11456 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int n = sc.nextInt();
			int[] terms = new int[n];
			int[] dp1 = new int[n];
			int[] dp2 = new int[n];
			for(int i=0; i<n; i++) {
				terms[n-1-i] = sc.nextInt();
				dp1[i] = dp2[i] = 1;
			}
			for(int i=0; i<n; i++)
				for(int j=0; j<i; j++) {
					if(terms[j]<terms[i] && dp1[j]+1>dp1[i]) dp1[i] = dp1[j]+1;
					if(terms[j]>terms[i] && dp2[j]+1>dp2[i]) dp2[i] = dp2[j]+1;
				}
			int ans = 0;
			for(int i=0; i<n; i++) ans = Math.max(ans, dp1[i]+dp2[i]-1);
			System.out.println(ans);
		}
	}
}
