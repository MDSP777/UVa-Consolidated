import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class UVa_11331 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			String[] split = br.readLine().split(" ");
			int b = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			int n = b+c;
			int x = Integer.parseInt(split[2]);
			ArrayList<Integer>[] adj = new ArrayList[n];
			for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
			while(x-->0) {
				split = br.readLine().split(" ");
				int u = Integer.parseInt(split[0])-1;
				int v = Integer.parseInt(split[1])-1;
				adj[u].add(v);
				adj[v].add(u);
			}
			boolean bipartite = true;
			int[] color = new int[n];
			Arrays.fill(color, -1);
			ArrayList<Integer> black = new ArrayList<>();
			ArrayList<Integer> white = new ArrayList<>();
			
			for(int i=0; bipartite && i<n; i++) {
				if(color[i]!=-1) continue;
				
				color[i] = 0;
				LinkedList<Integer> q = new LinkedList<>();
				q.add(i);
				int nBlack = 0, nWhite = 0;
				while(bipartite && !q.isEmpty()) {
					int cur = q.poll();
					int flip = 1-color[cur];
					if(color[cur]==0) nWhite++;
					else nBlack++;
					for(int next : adj[cur]) {
						if(color[cur]==color[next]) {
							bipartite = false;
							break;
						} else {
							if(color[next]==-1) q.add(next);
							color[next] = flip;
						}
					}
				}
				black.add(nBlack);
				white.add(nWhite);
			}
			
			if(!bipartite) {
				System.out.println("no");
				continue;
			}
			
			int nGraphs = black.size();
			int targetWeight = Math.min(b, c);
			boolean[][] memo = new boolean[nGraphs+1][targetWeight+1];
			if(black.get(0)<=targetWeight) memo[1][black.get(0)] = true;
			if(white.get(0)<=targetWeight) memo[1][white.get(0)] = true;
			
			for(int i=1; i<nGraphs; i++)
				for(int j=0; j<=targetWeight; j++)
					if(memo[i][j]) {
						if(j+black.get(i)<=targetWeight) memo[i+1][j+black.get(i)] = true;
						if(j+white.get(i)<=targetWeight) memo[i+1][j+white.get(i)] = true;
					}
			System.out.println(memo[nGraphs][targetWeight] ? "yes" : "no");
		}
	}
}
