import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class UVa_10507 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[] init = sc.next().toCharArray();
			BitSet bs = new BitSet();
			boolean[][] adj = new boolean[26][26];
			for(int i=0; i<init.length; i++) bs.set(init[i]-'A');
			for(int i=0; i<m; i++) {
				init = sc.next().toCharArray();
				adj[init[0]-'A'][init[1]-'A'] = adj[init[1]-'A'][init[0]-'A'] = true;
			}
			int total = 0;
			boolean canWake = true;
			while (bs.cardinality()<n) {
				ArrayList<Integer> newWoke = new ArrayList<>();
				for(int i=0; i<26; i++) 
					if(!bs.get(i)) {
						int wokeNeighbors = 0;
						for(int j=0; j<26; j++)
							if(adj[i][j] && bs.get(j)) wokeNeighbors++;
						if(wokeNeighbors>=3) newWoke.add(i);
					}
				total++;
				if(newWoke.size()==0) {
					canWake = false;
					break;
				} 
				for(int i: newWoke) bs.set(i);
			}
			System.out.println(canWake ? "WAKE UP IN, "+total+", YEARS" : "THIS BRAIN NEVER WAKES UP");
		} while(sc.hasNext());
	}
}
