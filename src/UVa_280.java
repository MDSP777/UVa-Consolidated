import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;

public class UVa_280 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			HashSet<Integer>[] e = new HashSet[n];
			for(int i=0; i<n; i++) e[i] = new HashSet<>();
			while(true) {
				String[] split = br.readLine().split("\\s+");
				if(split[0].equals("0")) break;
				int src = Integer.parseInt(split[0])-1;
				for(int i=1; i<split.length-1; i++) e[src].add(Integer.parseInt(split[i])-1);
			}
			String[] split = br.readLine().split("\\s+");
			for(int i=1; i<split.length; i++) {
				BitSet visited = new BitSet();
				LinkedList<Integer> q = new LinkedList<>();
				q.add(Integer.parseInt(split[i])-1);
				while(!q.isEmpty()) {
					int cur = q.poll();
					for(int next: e[cur])
						if(!visited.get(next)) {
							visited.set(next);
							q.add(next);
						}
				}
				ArrayList<Integer> ans = new ArrayList<>();
				for(int j=0; j<n; j++) if(!visited.get(j)) ans.add(j+1);
				sb.append(ans.size());
				for(int j=0; j<ans.size(); j++) sb.append(" ").append(ans.get(j));
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
