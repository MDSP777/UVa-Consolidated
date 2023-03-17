import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UVa_11658 {
	static int target, n;
	static ArrayList<Integer> vals;
	static int[][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			int x = sc.nextInt()-1;
			if(n==0) break;
			int w = -1;
			vals = new ArrayList<>();
			for(int i=0; i<n; i++) {
				if(i==x) w = Integer.parseInt(sc.next().replaceAll("\\.", ""));
				else vals.add(Integer.parseInt(sc.next().replaceAll("\\.", "")));
			}
			n--;
			target = 5000-w;
			memo = new int[n][5000];
			for(int i=0; i<n; i++) Arrays.fill(memo[i], -1);
			int ans = dp(0, 0);
			System.out.printf("%.2f\n", w*100.0/(ans+w));
		}
	}
	
	static int dp(int index, int curVal){
		if(curVal>target) return curVal;
		if(index==n) return -10000;
		if(memo[index][curVal]!=-1) return memo[index][curVal];
		int ans = dp(index+1, curVal);
		int ans2 = dp(index+1, curVal+vals.get(index));
		int r = -10000;
		if(ans>=target) r = ans;
		if(ans2>=target && (ans2<r || r<0)) r = ans2;
		memo[index][curVal] = r;
		return r;
	}
}
