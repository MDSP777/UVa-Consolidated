import java.util.HashMap;
import java.util.Scanner;

public class UVa_12324 {
	static int n;
	static int[] t;
	static int[] s;
	static HashMap<State, Integer> memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n==0) break;
			t = new int[n];
			s = new int[n];
			memo = new HashMap<>();
			for(int i=0; i<n; i++){
				t[i] = sc.nextInt();
				s[i] = sc.nextInt();
			}
			System.out.println(dp(0, 0));
		}
	}
	
	static int dp(int index, int curS){
		if(index==n) return 0;
		State st = new State(index, curS);
		if(memo.containsKey(st)) return memo.get(st);
		int ans = t[index]+dp(index+1, curS+s[index]);
		if(curS>0) ans = Math.min(ans, t[index]/2+dp(index+1, curS-1+s[index]));
		memo.put(st, ans);
		return ans;
	}
	
	static class State{
		int index, s;
		
		State(int a, int b){
			index = a;
			s = b;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + s;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			State other = (State) obj;
			if (index != other.index)
				return false;
			if (s != other.s)
				return false;
			return true;
		}
	}
}
