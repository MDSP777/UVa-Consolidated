import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_10261 {
	static HashMap<State, Integer> memo;
	static ArrayList<Integer> cars;
	static int len, n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			len = sc.nextInt()*100;
			cars = new ArrayList<>();
			while(true){
				int s = sc.nextInt();
				if(s==0) break;
				cars.add(s);
			}
			n = cars.size();
			memo = new HashMap<>();
			int ans = dp(0, 0, 0);
			System.out.println(ans);
			int c = ans;
			ArrayList<String> res = new ArrayList<>();
			int index = 0, lSize = 0, rSize = 0;
			while(c>0){
				State next = new State(index+1, lSize+cars.get(index), rSize);
				if(lSize+cars.get(index)<=len && memo.containsKey(next) && memo.get(next)==c-1) {
					res.add("port");
					lSize+=cars.get(index);
				} else {
					res.add("starboard");
					rSize+=cars.get(index);
				}
				index++;
				c--;
			}
			for(int i=0; i<ans; i++) System.out.println(res.get(i));
			if(tc>0) System.out.println();
		}
	}
	
	static int dp(int index, int lSize, int rSize){
		if(index==n) return 0;
		boolean canLeft = lSize+cars.get(index)<=len;
		boolean canRight = rSize+cars.get(index)<=len;
		if(!canLeft && !canRight) return 0;
		State cur = new State(index, lSize, rSize);
		if(memo.containsKey(cur)) return memo.get(cur);
		int ans = 0;
		if(canLeft) ans = Math.max(ans, 1+dp(index+1, lSize+cars.get(index), rSize));
		if(canRight) ans = Math.max(ans, 1+dp(index+1, lSize, rSize+cars.get(index)));
		memo.put(cur, ans);
		return ans;
	}
	
	static class State{
		int index, lSize, rSize;
		
		State(int a, int b, int c){
			index = a;
			lSize = b;
			rSize = c;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + lSize;
			result = prime * result + rSize;
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
			if (lSize != other.lSize)
				return false;
			if (rSize != other.rSize)
				return false;
			return true;
		}
	}
}
