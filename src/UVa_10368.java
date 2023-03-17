import java.util.HashMap;
import java.util.Scanner;


public class UVa_10368 {
	static HashMap<State, Boolean> memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		memo = new HashMap<>();
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0 && m==0) break;
			System.out.println(win(Math.max(n, m), Math.min(n, m)) ? "Stan wins" : "Ollie wins");
		}
	}
	
	static boolean win(int a, int b){
		if(a%b==0) return true;
		State s = new State(a, b);
		if(memo.containsKey(s)) return memo.get(s);
		boolean win = false;
		int bound = a/b;
		for(int i=bound; !win && i>0; i--){
			int x = a-b*i;
			win|=!win(Math.max(b, x), Math.min(b, x));
		}
		return win;
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
