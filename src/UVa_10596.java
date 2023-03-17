import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class UVa_10596 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			String[] split = s.split(" ");
			int n = Integer.parseInt(split[0]);
			int k = Integer.parseInt(split[1]);
			ArrayList<Integer>[] e = new ArrayList[n];
			boolean[] seen = new boolean[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			boolean can = k>0;
			while(k-->0) {
				split = br.readLine().split(" ");
				int u = Integer.parseInt(split[0]);
				int v = Integer.parseInt(split[1]);
				e[u].add(v);
				e[v].add(u);
				seen[u] = seen[v] = true;
			}
			for(int i=0; can && i<n; i++) can&=(e[i].size()&1)==0;
			if(can) {
				int[] tag = new int[n];
				int val = 1;
				for(int i=0; i<n; i++)
					if(tag[i]==0 && seen[i]) {
						LinkedList<Integer> q = new LinkedList<>();
						tag[i] = val;
						q.add(i);
						while(!q.isEmpty()) {
							int cur = q.poll();
							for(int next : e[cur])
								if(tag[next]==0) {
									tag[next] = val;
									q.add(next);
								}
						}
						val++;
					}
				for(int i=0; can && i<n; i++) can&=tag[i]<=1;
			}
			System.out.println(can ? "Possible" : "Not Possible");
		}
	}
}
