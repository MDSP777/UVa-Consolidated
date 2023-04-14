import java.util.HashMap;
import java.util.Scanner;

// solution summary:
// 1. greedily use 10s to buy as much coke as possible at first
// 2. DP the min coins using the remaining 5 and 1 coins (cannot DP with 10, 5, 1, too slow)
// 3. in the DP, track how many times 8x 1 is used as part of the optimal solution
// 4. after DP finishes, offset as many 8x 1s as you can using 10s
//    idea: buying 2 coke
//    option 1: using 1x 10 gives 2x 1 change, and then 8x 1 for a total of 9 coins
//    option 2: using 1x 10 + 3x 1 gives 1x 5 change, then use the 1x 5 and 3x 1 for a total of 8 coins
//    using option 2 saves us 1 coin
// 5. to offset, subtract min(nTen, ans.nEightOnes) from initial DP answer
public class UVa_10626 {
	static HashMap<State, Answer> memo;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
        	memo = new HashMap<>();
            int coke = sc.nextInt();
            int nOne = sc.nextInt();
            int nFive = sc.nextInt();
            int nTen = sc.nextInt();
            if(nTen>=coke) System.out.println(coke);
            else {
            	Answer ans = dp(coke-nTen, nOne+nTen*2, nFive);
            	System.out.println(nTen+ans.total()-Math.min(nTen, ans.nEightOnes));
            }
        }
    }
    
    static Answer dp(int coke, int nOne, int nFive){
    	if(coke==1){
    		if(nFive>1) return new Answer(0, 2);
    		if(nFive>0 && nOne>2) return new Answer(3, 1);
    		return new Answer(8, 0);
    	}
    	State cur = new State(coke, nOne, nFive);
    	if(memo.containsKey(cur)) return memo.get(cur);
    	
    	Answer best = new Answer(10000000, 0);
    	if(nFive>1) best = min(best, new Answer(0, 2).add(dp(coke-1, nOne+2, nFive-2)));
    	if(nFive>=1 && nOne>=3) best = min(best, new Answer(3, 1).add(dp(coke-1, nOne-3, nFive-1)));
    	if(nOne>7) best = min(best, new Answer(8, 0).add(dp(coke-1, nOne-8, nFive)));
    	
    	memo.put(cur, best);
    	return best;
    }
    
    static Answer min(Answer a, Answer b){
    	return a.total()<=b.total() ? a : b; 
    }
    
    static class Answer{
    	int one, five;
    	int nEightOnes;
    	
    	Answer(int a, int b){
    		one = a;
    		five = b;
    		nEightOnes = a==8 ? 1 : 0;
    	}
    	
    	Answer add(Answer o){
    		one+=o.one;
    		five+=o.five;
    		nEightOnes+=o.nEightOnes;
    		return this;
    	}
    	
    	int total(){
    		return one+five;
    	}
    }
    
    static class State {
    	int coke, nOne, nFive;
    	
    	State(int a, int b, int c){
    		coke = a;
    		nOne = b;
    		nFive = c;
    	}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + coke;
			result = prime * result + nFive;
			result = prime * result + nOne;
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
			if (coke != other.coke)
				return false;
			if (nFive != other.nFive)
				return false;
			if (nOne != other.nOne)
				return false;
			return true;
		}
    }
}
