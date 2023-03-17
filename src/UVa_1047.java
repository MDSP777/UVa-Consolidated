import java.util.Arrays;
import java.util.Scanner;

public class UVa_1047 {
	static int[] towers;
	static Intersection[] ints;
	static int[] memo;
	static int n, build;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(true){
			n = sc.nextInt();
			build = sc.nextInt();
			if(n==0 && build==0) break;
			towers = new int[n];
			for(int i=0; i<n; i++) towers[i] = sc.nextInt();
			int x = sc.nextInt();
			ints = new Intersection[x];
			for(int i=0; i<x; i++){
				int m = sc.nextInt();
				int[] mem = new int[m];
				for(int j=0; j<m; j++) mem[j] = sc.nextInt()-1;
				ints[i] = new Intersection(mem, sc.nextInt());
			}
			memo = new int[1<<n];
			Arrays.fill(memo, -1);
			System.out.println("Case Number  "+t++);
			int ans = dp(0);
			System.out.println("Number of Customers: "+ans);
			int comb = -1;
			for(int i=0; i<(1<<n); i++) 
				if(dp(i)==ans && card(i)==build) {
					comb = i;
					break;
				}
			System.out.print("Locations recommended:");
			int ctr = 1;
			while(comb>0){
				if((comb&1)==1) System.out.print(" "+ctr);
				comb>>=1;
				ctr++;
			}
			System.out.println("\n");
		}
	}
	
	static int dp(int cur){
		if(card(cur)==build) return calc(cur);
		if(memo[cur]!=-1) return memo[cur];
		int ans = 0;
		for(int i=0; i<n; i++)
			if((cur&(1<<i))==0)
				ans = Math.max(ans, dp(cur|(1<<i)));
		return memo[cur] = ans;
	}
	
	static int calc(int cur){
		int total = 0;
		for(int i=0; i<n; i++) if((cur&(1<<i))!=0) total+=towers[i];
		for(int i=0; i<ints.length; i++){
			int used = 0;
			for(int j=0; j<ints[i].members.length; j++)
				if((cur & (1 << (ints[i].members[j]) ))!=0) used++;
			if(used>1) total-=ints[i].size*(used-1);
		}
		return total;
	}
	
	static int card(int cur){
		int total = 0;
		while(cur>0){
			total+=cur&1;
			cur>>=1;
		}
		return total;
	}
	
	static class Intersection{
		int[] members;
		int size;
		
		Intersection(int[] a, int b){
			members = a;
			size = b;
		}
	}
}
