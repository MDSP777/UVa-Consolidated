import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class UVa_10534 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		do {
			int n = sc.nextInt();
			int[] arr1 = new int[n];
			int[] arr2 = new int[n];
			int[] dp1 = new int[n];
			int[] dp2 = new int[n];
			int[] L1 = new int[n];
			int[] L2 = new int[n];
			for(int i=0; i<n; i++) {
				arr1[i] = arr2[n-1-i] = sc.nextInt();
				dp1[i] = dp2[i] = Integer.MAX_VALUE;
				L1[i] = L2[i] = 1;
			}
			for(int i=0; i<n; i++) {
				int index = Arrays.binarySearch(dp1, arr1[i]);
				if(index<0) index = -(index+1);
				if(dp1[index]>arr1[i]) {
					dp1[index] = arr1[i];
					L1[i] = index+1;
				}
				index = Arrays.binarySearch(dp2, arr2[i]);
				if(index<0) index = -(index+1);
				if(dp2[index]>arr2[i]) {
					dp2[index] = arr2[i];
					L2[i] = index+1;
				}
			}
			int ans = 0;
			for(int i=0; i<n; i++) ans = Math.max(ans, Math.min(L1[i], L2[n-1-i])*2-1);
			System.out.println(ans);
		} while(sc.hasNext());
	}
}
