import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class UVa_729 {
	static ArrayList<String> ans;
	static char[] arr;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(tc-->0) {
			n = sc.nextInt();
			int r = sc.nextInt();
			ans = new ArrayList<>();
			arr = new char[n];
			Arrays.fill(arr, '0');
			for(int i=0; i<n; i++) {
				arr[i] = '1';
				bt(i+1, r-1);
				arr[i] = '0';
			}
			Collections.sort(ans);
			for(String s : ans) sb.append(s).append("\n");
			
			if(tc>0) sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static void bt(int i, int r) {
		if(r==0) {
			StringBuilder sb = new StringBuilder();
			for(int x=n-1; x>=0; x--) sb.append(arr[x]);
			ans.add(sb.toString());
			return;
		}
		if(i==n) return;
		bt(i+1, r);
		arr[i] = '1';
		bt(i+1, r-1);
		arr[i] = '0';
	}
}
