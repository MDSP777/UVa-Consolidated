import java.util.BitSet;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_11832 {
	static int[] terms;
	static HashMap<State, Boolean> memo;
	static BitSet plus;
	static BitSet minus;
	static int n;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			int k = sc.nextInt();
			if(n==0 && k==0) break;
			terms = new int[n];
			memo = new HashMap<>();
			plus = new BitSet();
			minus = new BitSet();
			for(int i=0; i<n; i++) terms[i] = sc.nextInt();
			if(!dp(0, k)) System.out.println("*");
			else {
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<n; i++) 
					if(plus.get(i) && minus.get(i)) sb.append("?");
					else if(plus.get(i)) sb.append("+");
					else sb.append("-");
				System.out.println(sb);
			}
		}
	}
	
	static boolean dp(int index, int sum){
		if(index==n-1){
			boolean can = false;
			if(terms[index]==sum){
				can = true;
				plus.set(index);
			}
			if(-terms[index]==sum){
				can = true;
				minus.set(index);
			}
			return can;
		}
		State s = new State(index, sum);
		if(memo.containsKey(s)) return memo.get(s);
		
		boolean can = false;
		if(dp(index+1, sum-terms[index])){
			can = true;
			plus.set(index);
		}
		if(dp(index+1, sum+terms[index])){
			can = true;
			minus.set(index);
		}
		memo.put(s, can);
		return can;
	}
	
	static class State {
		int index, sum;
		
		State(int a, int b){
			index = a;
			sum = b;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + sum;
			result = prime * result + index;
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
			if (sum != other.sum)
				return false;
			if (index != other.index)
				return false;
			return true;
		}
	}
}
