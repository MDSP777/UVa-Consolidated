import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class UVa_11396 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			ArrayList<Integer>[] e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			while(true) {
				String[] split = br.readLine().split("\\s+");
				int a = Integer.parseInt(split[0]);
				int b = Integer.parseInt(split[1]);
				if(a==0 && b==0) break;
				a--;
				b--;
				e[a].add(b);
				e[b].add(a);
			}
			int[] colors = new int[n];
			Arrays.fill(colors, -1);
			LinkedList<Integer> q = new LinkedList<>();
			q.add(0);
			colors[0] = 0;
			boolean bi = true;
			while(!q.isEmpty()) {
				int cur = q.poll();
				int nextColor = (colors[cur]+1)%2;
				for(int next: e[cur]) 
					if(colors[next]==colors[cur]) {
						bi = false;
						break;
					} else if(colors[next]==-1) {
						colors[next] = nextColor;
						q.add(next);
					}
			}
			System.out.println(bi ? "YES" : "NO");
		}
	}
}
