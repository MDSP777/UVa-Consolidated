import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class UVa_812 {
	static int n;
	static int[][] vals;
	static int[][] sums;
	static int[] maxI;
	static int[] maxVals;
	static TreeSet<Integer> ts;
	static HashSet<State> visited;
	static ArrayList<Integer>[] next;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		int t = 1;
		while(true){
			n = sc.nextInt();
			if(n==0) break;
			if(first) first = false;
			else sb.append("\n");
			vals = new int[n][];
			sums = new int[n][];
			maxI = new int[n];
			maxVals = new int[n];
			next = new ArrayList[n];
			int ans = 0, sum = 0;
			for(int i=0; i<n; i++){
				int s = sc.nextInt();
				vals[i] = new int[s];
				sums[i] = new int[s];
				next[i] = new ArrayList<>();
				int max = 0;
				int mi = -1;
				for(int j=0; j<s; j++) {
					vals[i][j] = -(sc.nextInt()-10);
					sums[i][j] = j==0 ? vals[i][j] : sums[i][j-1]+vals[i][j];
					if(sums[i][j]>max){
						max = sums[i][j];
						mi = j;
					}
				}
				maxI[i] = mi;
				maxVals[i] = max;
				ans+=max;
				sum+=mi+1;
				for(int j=mi+1; j<s; j++) if(sums[i][j]==maxVals[i]) next[i].add(j-mi);
			}
			ts = new TreeSet<>();
			visited = new HashSet<>();
			dp(0, 0);
			sb.append("Workyards ").append(t++).append("\nMaximum profit is ").append(ans).append(".\nNumber of pruls to buy:");
			int x = Math.min(ts.size(), 10);
			for(int i=0; i<x; i++) {
				sb.append(" ").append(sum+ts.first());
				ts.remove(ts.first());
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static void dp(int index, int sum){
		if(index==n) ts.add(sum);
		else {
			State s = new State(index, sum);
			if(visited.contains(s)) return;
			visited.add(s);
			dp(index+1, sum);
			for(int i=0; i<next[index].size(); i++) dp(index+1, sum+next[index].get(i));
		}
	}
	
	static class State{
		int index, sum;
		
		State(int a, int b){
			index = a;
			sum = b;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + sum;
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
			if (sum != other.sum)
				return false;
			return true;
		}
	}
}
