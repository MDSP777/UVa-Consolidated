import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;

public class UVa_11902 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		for(int x=1; x<=nC; x++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer>[] e = new ArrayList[n];
			boolean[][] dominates = new boolean[n][n];
			dominates[0][0] = true;
			for(int i=0; i<n; i++) {
				e[i] = new ArrayList<>();
				String[] split = br.readLine().split("\\s+");
				for(int j=0; j<n; j++) if(split[j].equals("1")) e[i].add(j);
			}
			BitSet origReach = new BitSet();
			LinkedList<Integer> q = new LinkedList<>();
			q.add(0);
			origReach.set(0);
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int next: e[cur])
					if(!origReach.get(next)) {
						origReach.set(next);
						q.add(next);
						dominates[0][next] = true;
						dominates[next][next] = true;
					}
			}
			for(int i=1; i<n; i++) {
				q = new LinkedList<>();
				BitSet reach = new BitSet();
				q.add(0);
				reach.set(0);
				while(!q.isEmpty()) {
					int cur = q.poll();
					if(cur!=i)
						for(int next: e[cur])
							if(!reach.get(next)) {
								reach.set(next);
								q.add(next);
							}
				}
				for(int j=0; j<n; j++)
					if(origReach.get(j) && !reach.get(j)) dominates[i][j] = true;
			}
			sb.append("Case ").append(x).append(":\n");
			sb.append("+-");
			for(int i=1; i<n; i++) sb.append("--");
			sb.append("+\n");
			for(int i=0; i<n; i++) {
				sb.append("|");
				sb.append(dominates[i][0] ? "Y" : "N");
				for(int j=1; j<n; j++) sb.append("|").append(dominates[i][j] ? "Y" : "N");
				sb.append("|\n");
				sb.append("+-");
				for(int j=1; j<n; j++) sb.append("--");
				sb.append("+\n");
			}
		}
		System.out.print(sb);
	}
}
