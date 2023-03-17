import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;

public class UVa_11080 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int nE = Integer.parseInt(split[1]);
			ArrayList<Integer>[] e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			while(nE-->0) {
				split = br.readLine().split(" ");
				int a = Integer.parseInt(split[0]);
				int b = Integer.parseInt(split[1]);
				e[a].add(b);
				e[b].add(a);
			}
			int[] colors = new int[n];
			BitSet visited = new BitSet();
			boolean bi = true;
			int total = 0;
			for(int i=0; bi && i<n; i++)
				if(!visited.get(i)) {
					Arrays.fill(colors, -1);
					LinkedList<Integer> q = new LinkedList<>();
					colors[i] = 0;
					visited.set(i);
					q.add(i);
					while(!q.isEmpty()) {
						int cur = q.poll();
						int nextColor = (colors[cur]+1)%2;
						for(int next: e[cur])
							if(colors[next]==colors[cur]) {
								bi = false;
								break;
							} else if(colors[next]==-1 && !visited.get(next)) {
								colors[next] = nextColor;
								q.add(next);
								visited.set(next);
							}
						if(!bi) break;
					}
					int a = 0;
					int b = 0;
					for(int j=0; j<n; j++) if(colors[j]==0) a++; else if(colors[j]==1) b++;
					if(a==0) a = Integer.MAX_VALUE;
					if(b==0) b = Integer.MAX_VALUE;
					total+=Math.min(a, b);
				}
			System.out.println(bi ? total : "-1");
		}
	}
}
