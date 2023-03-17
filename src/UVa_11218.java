import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;


public class UVa_11218 {
	static int[] memo;
	static TreeMap<Triple, Integer> map;
	static int bound = 1<<9;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			map = new TreeMap<>();
			while(n-->0){
				int[] x = new int[3];
				for(int i=0; i<3; i++) x[i] = sc.nextInt()-1;
				Arrays.sort(x);
				map.put(new Triple(x[0], x[1], x[2]), sc.nextInt());
			}
			memo = new int[bound];
			Arrays.fill(memo, -1);
			int ans = dp(0);
			if(ans<0) ans = -1;
			System.out.println("Case "+t+++": "+ans);
		}
	}
	
	static int dp(int mask){
		if(mask==bound-1) return 0;
		if(memo[mask]!=-1) return memo[mask];
		int ans = -1000000000;
		for(int i=0; i<9; i++)
			for(int j=i+1; j<9; j++)
				for(int k=j+1; k<9; k++)
					if((mask&(1<<i))==0 && (mask&(1<<j))==0 && (mask&(1<<k))==0){
						Triple t = new Triple(i, j, k);
						if(map.containsKey(t)) {
							int newMask = mask;
							newMask|=1<<i;
							newMask|=1<<j;
							newMask|=1<<k;
							ans = Math.max(ans, map.get(t)+dp(newMask));
						}
					}
		memo[mask] = ans;
		return ans;
	}
	
	static class Triple implements Comparable<Triple>{
		int a, b, c;
		
		Triple(int x, int y, int z){
			a = x;
			b = y;
			c = z;
		}

		@Override
		public int compareTo(Triple o) {
			if(a==o.a){
				if(b==o.b) return c-o.c;
				return b-o.b;
			}
			return a-o.a;
		}
	}
}
