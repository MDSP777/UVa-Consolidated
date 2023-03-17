import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_1196 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			ArrayList<Block> blocks = new ArrayList<>();
			for(int i=0; i<n; i++) blocks.add(new Block(sc.nextInt(), sc.nextInt()));
			Collections.sort(blocks);
			int[] dp = new int[n];
			for(int i=0; i<n; i++) dp[i] = 1;
			int ans = 1;
			for(int i=0; i<n; i++) {
				for(int j=i-1; j>=0; j--)
					if(blocks.get(i).canAttach(blocks.get(j)) && dp[j]+1>dp[i]) {
						dp[i] = dp[j]+1;
						ans = Math.max(ans, dp[i]);
					}
			}
			sb.append(ans).append("\n");
		}
		sb.append("*");
		System.out.println(sb);
	}
	
	static class Block implements Comparable<Block> {
		int l;
		int m;
		
		public Block(int l, int m) {
			this.l = l;
			this.m = m;
		}

		@Override
		public int compareTo(Block o) {
			if(this.l==o.l) return Integer.compare(this.m, o.m);
			return Integer.compare(this.l, o.l);
		}
		
		boolean canAttach(Block o) {
			return this.l>=o.l && this.m>=o.m;
		}
	}
}
