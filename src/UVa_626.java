import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_626 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			int size = Integer.parseInt(s);
			boolean[][] grid = new boolean[size][size];
			boolean[][][] incVisited = new boolean[105][105][105];
			boolean[][][] decVisited = new boolean[105][105][105];
			for(int i=0; i<size; i++) {
				String[] split = br.readLine().split(" ");
				for(int j=0; j<size; j++) grid[i][j] = Integer.parseInt(split[j])==1;
			}
			ArrayList<Triple> triples = new ArrayList<>();
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					if(grid[i][j]) 
						for(int k=0; k<size; k++) {
							if(grid[j][k] && grid[k][i]) {
								if(i==j || j==k || k==i) continue;
								int nIncs = 0;
								if(i<j) nIncs++;
								if(j<k) nIncs++;
								if(k<i) nIncs++;
								Triple t = nIncs==2 ? new Triple(i+1, j+1, k+1, true) : new Triple(i+1, j+1, k+1, false);
								if(nIncs==2) {
									if(!incVisited[t.terms.get(0)][t.terms.get(1)][t.terms.get(2)]) {
										incVisited[t.terms.get(0)][t.terms.get(1)][t.terms.get(2)] = true;
										triples.add(t);
									}
								} else {
									if(!decVisited[t.terms.get(0)][t.terms.get(1)][t.terms.get(2)]) {
										decVisited[t.terms.get(0)][t.terms.get(1)][t.terms.get(2)] = true;
										triples.add(t);
									}
								}
							}
						}
				}
			}
			Collections.sort(triples);
			for(int i=0; i<triples.size(); i++) sb.append(triples.get(i)).append("\n");
			sb.append("total:").append(triples.size()).append("\n\n");
		} 
		System.out.print(sb);
	}
	
	static class Triple implements Comparable<Triple> {
		ArrayList<Integer> terms;
		
		public Triple(int a, int b, int c, boolean ascending) {
			terms = new ArrayList<>();
			terms.add(a);
			terms.add(b);
			terms.add(c);
			if(ascending) Collections.sort(terms);
			else Collections.sort(terms, Collections.reverseOrder());
		}

		@Override
		public int compareTo(Triple o) {
			for(int i=0; i<3; i++)
				if(this.terms.get(i)<o.terms.get(i)) return -1;
				else if(this.terms.get(i)>o.terms.get(i)) return 1;
			return 0;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder().append(terms.get(0));
			for(int i=1; i<3; i++) sb.append(" ").append(terms.get(i));
			return sb.toString();
		}
	}
}

/*
	Code snippet to generate a random 100x100 matrix for testing program efficiency
	int size = 100;
	System.out.println(size);
	Random r = new Random();
	for(int i=0; i<size; i++) {
		System.out.print(r.nextInt(2));
		for(int j=0; j<size-1; j++) System.out.print(" "+r.nextInt(2));
		System.out.println();
	}
*/
