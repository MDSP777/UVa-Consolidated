import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_10898 {
	static int n;
	static int[] prices;
	static HashMap<Integer, Integer> combo;
	static int[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] pow10 = new int[8];
		pow10[0] = 1;
		for(int i=1; i<8; i++) pow10[i] = pow10[i-1]*10;
		do{
			n = sc.nextInt();
			prices = new int[n];
			for(int i=0; i<n; i++) prices[i] = sc.nextInt();
			combo = new HashMap<>();
			int nCombo = sc.nextInt();
			while(nCombo-->0){
				int val = 0;
				for(int i=0; i<n; i++){
					val*=10;
					val+=sc.nextInt();
				}
				int price = sc.nextInt();
				combo.put(val, combo.containsKey(val) ? Math.min(price, combo.get(val)) : price);
			}
			memo = new int[pow10[n]];
			Arrays.fill(memo, -1);
			int nOrder = sc.nextInt();
			while(nOrder-->0){
				int val = 0;
				for(int i=0; i<n; i++){
					val*=10;
					val+=sc.nextInt();
				}
				System.out.println(dp(val));
			}
		}while(sc.hasNext());
	}
	
	static int dp(int order){
		if(order==0) return 0;
		if(memo[order]!=-1) return memo[order];
		int ans = Integer.MAX_VALUE;
		int oOrder = order;
		int[] orderItems = new int[n];
		for(int i=n-1; i>=0; i--){
			orderItems[i] = order%10;
			order/=10;
		}
		for(int i=0; i<n; i++)
			if(orderItems[i]>=1){
				int newVal = 0;
				for(int j=0; j<n; j++){
					newVal*=10;
					newVal+=j==i ? orderItems[j]-1 : orderItems[j];
				}
				ans = Math.min(ans, prices[i]+dp(newVal));
			}
		for(int cur: combo.keySet()){
			int p = combo.get(cur);
			int[] comboItems = new int[n];
			for(int i=n-1; i>=0; i--){
				comboItems[i] = cur%10;
				cur/=10;
			}
			if(contains(orderItems, comboItems)){
				int newVal = 0;
				for(int j=0; j<n; j++){
					newVal*=10;
					newVal+=orderItems[j]-comboItems[j];
				}
				ans = Math.min(ans, p+dp(newVal));
			}
		}
		memo[oOrder] = ans;
		return ans;
	}

	private static boolean contains(int[] order, int[] comboItems) {
		for(int i=0; i<n; i++) if(comboItems[i]>order[i]) return false;
		return true;
	}
}
