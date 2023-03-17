import java.util.HashMap;
import java.util.Scanner;

public class UVa_907 {
	static int n, k;
	static int[] dist;
	static HashMap<Integer, Integer>[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			n = sc.nextInt()+1;
			k = sc.nextInt();
			dist = new int[n];
			memo = new HashMap[n];
			for(int i=0; i<n; i++) {
				dist[i] = sc.nextInt();
				memo[i] = new HashMap<>();
			}
			System.out.println(dp(0, 0));
		} while(sc.hasNext());
	}
	
	static int dp(int index, int nights) {
		if(index==n) return 0;
		if(memo[index].containsKey(nights)) return memo[index].get(nights);
		int ans = 100000000;
		int w = 0;
		if(nights<k)
			for(int i=index; i<n; i++) {
				w+=dist[i];
				ans = Math.min(ans, Math.max(w, dp(i+1, nights+1)));
			}
		else {
			for(int i=index; i<n; i++) w+=dist[i];
			ans = w;
		}
		memo[index].put(nights, ans);
		return ans;
	}
}
