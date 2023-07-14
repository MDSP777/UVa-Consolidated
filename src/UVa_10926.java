import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class UVa_10926 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			ArrayList<Integer>[] adj = new ArrayList[n];
			int[] incoming = new int[n];
			for(int i=0; i<n; i++) {
				adj[i] = new ArrayList<>();
			}
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split(" ");
				for(int j=1; j<split.length; j++) {
					int x = Integer.parseInt(split[j])-1;
					adj[x].add(i);
					incoming[i]++;
				}
			}
			
			LinkedList<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[n];
			HashSet<Integer>[] paths = new HashSet[n];
			for(int i=0; i<n; i++) {
				paths[i] = new HashSet<>();
				if(incoming[i]==0) {
					q.add(i);
					visited[i] = true;
				}
			}
			
			while(!q.isEmpty()) {				
				int cur = q.poll();
				for(int next : adj[cur]) {
					paths[next].addAll(paths[cur]);
					paths[next].add(cur);
					incoming[next]--;
					if(incoming[next]==0) {
						visited[next] = true;
						q.add(next);
					}
				}
			}
			int max = 0, maxId = -1;
			for(int i=0; i<n; i++) {
				if(paths[i].size()>max) {
					max = paths[i].size();
					maxId = i;
				}
			}
			
			
			System.out.println(maxId+1);
			
		}
	}
}
