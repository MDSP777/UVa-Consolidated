import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10131 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Elephant> e = new ArrayList<>();
		int c = 0;
		do {
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			if(a==-1) break;
//			e.add(new Elephant(a, b, c++));
			e.add(new Elephant(sc.nextInt(), sc.nextInt(), c++));
		} while(sc.hasNext());
		Collections.sort(e);
		int ans = 1;
		int[] left = new int[e.size()];
		int[] dp = new int[e.size()];
		for(int i=0; i<e.size(); i++) {
			dp[i] = 1;
			left[i] = -1;
		}
		int s = 0;
		for(int i=0; i<e.size(); i++) {
			for(int j=i-1; j>=0; j--)
				if(e.get(i).w>e.get(j).w && e.get(i).s<e.get(j).s && dp[j]+1>dp[i]) {
					dp[i] = dp[j]+1;
					ans = Math.max(ans, dp[i]);
					left[i] = j;
				}
			if(dp[i]>dp[s]) s = i;
		}
		System.out.println(ans);
		ArrayList<Integer> out = new ArrayList<>();
		do {
			out.add(e.get(s).o_index);
			s = left[s];
		} while(s>-1);
		for(int i=out.size()-1; i>=0; i--) System.out.println(out.get(i));
	}
	
	static class Elephant implements Comparable<Elephant> {
		int w;
		int s;
		int o_index;
		
		public Elephant(int w, int s, int o) {
			this.w = w;
			this.s = s;
			o_index = o+1;
		}

		@Override
		public int compareTo(Elephant o) {
			if(this.s==o.s) return Integer.compare(this.w, o.w);
			return Integer.compare(o.s, this.s);
		}
	}
}
