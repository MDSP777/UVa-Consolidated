import java.util.BitSet;
import java.util.Scanner;

public class UVa_10503 {
	static int n, m;
	static Domino[] dominoes;
	static BitSet used;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n==0) break;
			m = sc.nextInt();
			Domino l = new Domino(sc.nextInt(), sc.nextInt());
			Domino r = new Domino(sc.nextInt(), sc.nextInt());
			dominoes = new Domino[m];
			used = new BitSet();
			for(int i=0; i<m; i++) dominoes[i] = new Domino(sc.nextInt(), sc.nextInt());
			System.out.println(backtrack(l.b, r.a, 0) ? "YES" : "NO");
		}
	}
	
	static boolean backtrack(int left, int right, int index){
		if(index==n-1){
			for(int i=0; i<m; i++)
				if(!used.get(i))
					if((dominoes[i].a==left && dominoes[i].b==right) ||
						(dominoes[i].b==left && dominoes[i].a==right)){
						return true;
					}
			return false;
		}
		for(int i=0; i<m; i++)
			if(!used.get(i)){
				if(dominoes[i].a==left){
					used.set(i);
					if(backtrack(dominoes[i].b, right, index+1)) return true;
					used.set(i, false);
				}
				if(dominoes[i].b==left){
					used.set(i);
					if(backtrack(dominoes[i].a, right, index+1)) return true;
					used.set(i, false);
				}
			}
		return false;
	}
	
	static class Domino {
		int a, b;
		
		Domino(int l, int r){
			a = l;
			b = r;
		}
	}
}

/*
Alternative DP w/ Bitmasking solution
import java.util.BitSet;
import java.util.HashMap;
import java.util.Scanner;


public class UVa_10503 {
	static int n, m;
	static Domino[] dominoes;
	static HashMap<State, Boolean> memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n==0) break;
			m = sc.nextInt();
			Domino l = new Domino(sc.nextInt(), sc.nextInt());
			Domino r = new Domino(sc.nextInt(), sc.nextInt());
			dominoes = new Domino[m];
			memo = new HashMap<>();
			for(int i=0; i<m; i++) dominoes[i] = new Domino(sc.nextInt(), sc.nextInt());
			System.out.println(backtrack(l.b, r.a, 0) ? "YES" : "NO");
		}
	}
	
	static boolean backtrack(int left, int right, int used){
		if(card(used)==n-1){
			for(int i=0; i<m; i++)
				if((used & (1<<i))==0)
					if((dominoes[i].a==left && dominoes[i].b==right) ||
						(dominoes[i].b==left && dominoes[i].a==right)){
						return true;
					}
			return false;
		}
		State cur = new State(left, right, used);
		if(memo.containsKey(cur)) return memo.get(cur);
		boolean ans = false;
		for(int i=0; !ans && i<m; i++)
			if((used & (1<<i))==0){
				if(!ans && dominoes[i].a==left){
					ans|=backtrack(dominoes[i].b, right, used | (1<<i));
				}
				if(!ans && dominoes[i].b==left){
					ans|=backtrack(dominoes[i].a, right, used | (1<<i));
				}
				if(!ans && dominoes[i].a==right){
					ans|=backtrack(left, dominoes[i].b, used | (1<<i));
				}
				if(!ans && dominoes[i].b==right){
					ans|=backtrack(left, dominoes[i].a, used | (1<<i));
				}
			}
		memo.put(cur, ans);
		return ans;
	}
	
	static int card(int x){
		int total = 0;
		while(x>0){
			total+=x&1;
			x>>=1;
		}
		return total;
	}
	
	static class State {
		int left, right, used;
		
		State(int a, int b, int c){
			left = a;
			right = b;
			used = c;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + left;
			result = prime * result + right;
			result = prime * result + used;
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
			if (left != other.left)
				return false;
			if (right != other.right)
				return false;
			if (used != other.used)
				return false;
			return true;
		}
	}
	
	static class Domino {
		int a, b;
		
		Domino(int l, int r){
			a = l;
			b = r;
		}
	}
}

*/