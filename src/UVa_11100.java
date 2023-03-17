import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class UVa_11100 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean first = true;
		while(true){
			int n = sc.nextInt();
			if(first) first = false;
			else System.out.println();
			if(n==0) break;
			int max = 0;
			int[] freq = new int[1000100];
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i=0; i<n; i++){
				int cur = sc.nextInt();
				freq[cur]++;
				max = Math.max(max, freq[cur]);
				arr.add(cur);
			}
			Collections.sort(arr);
			ArrayList<Integer>[] ans = new ArrayList[max];
			for(int i=0; i<max; i++) ans[i] = new ArrayList<>();
			for(int i=n-1, m=0; i>=0; i--, m++){
				ans[m%max].add(arr.get(i));
			}
			System.out.println(max);
			for(int i=0; i<max; i++){
				StringBuilder sb = new StringBuilder();
				for(int j=0; j<ans[i].size(); j++) sb.append(ans[i].get(j)).append(" ");
				System.out.println(sb.toString().trim());
			}
		}
	}
}
