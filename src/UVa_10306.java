import java.util.HashMap;
import java.util.Scanner;

public class UVa_10306 {
	static int[] a, b;
	static int n, goal;
	static HashMap<State, Integer> memo;
	static int FAIL = 100000000;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		a = new int[41];
		b = new int[41];
		while(tc-->0){
			n = sc.nextInt();
			memo = new HashMap<>();
			goal = sc.nextInt();
			goal*=goal;
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			int ans = dp(0, 0);
			sb.append(ans>=FAIL ? "not possible" : ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static int dp(int x, int y){
		if(add(x, y)==goal) return 0;
		State cur = new State(x, y);
		if(memo.containsKey(cur)) return memo.get(cur);
		int count = FAIL;
		for(int i=0; i<n; i++) if(add(x+a[i], y+b[i])<=goal) count = Math.min(count, 1+dp(x+a[i], y+b[i]));
		memo.put(cur, count);
		return count;
	}
	
	static int add(int a, int b){
		return a*a+b*b;
	}
	
	static class State {
		int a, b;
		
		State(int x, int y){
			a = x;
			b = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
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
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			return true;
		}
		
	}
}

/*
Alt solution

import java.util.HashMap;
import java.util.Scanner;

public class UVa_10306 {
	static int[] a, b;
	static int n, goal;
	static HashMap<State, Integer> memo;
	static int FAIL = 100000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		a = new int[41];
		b = new int[41];
		while(tc-->0){
			n = sc.nextInt();
			memo = new HashMap<>();
			goal = sc.nextInt();
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			int ans = FAIL;
			for(int i=0; i<=goal; i++){
				int diff = goal*goal-i*i;
				int sq = (int) Math.sqrt(diff);
				if(i*i+sq*sq==goal*goal) ans = Math.min(ans, dp(i, sq));
			}
			sb.append(ans>=FAIL ? "not possible" : ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static int dp(int x, int y){
		if(x==0 && y==0) return 0;
		State cur = new State(x, y);
		if(memo.containsKey(cur)) return memo.get(cur);
		int count = FAIL;
		for(int i=0; i<n; i++) if(x>=a[i] && y>=b[i]) count = Math.min(count, 1+dp(x-a[i], y-b[i]));
		memo.put(cur, count);
		return count;
	}
	
	static class State {
		int a, b;
		
		State(int x, int y){
			a = x;
			b = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
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
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			return true;
		}
	}
}


*/