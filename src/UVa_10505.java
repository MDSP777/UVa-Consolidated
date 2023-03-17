import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_10505 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int n = sc.nextInt();
			ArrayList<Integer>[] e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			for(int i=0; i<n; i++) {
				int nE = sc.nextInt();
				while(nE-->0) {
					int x = sc.nextInt();
					if(x<=n) {
						e[i].add(x-1);
						e[x-1].add(i);
					}
				}
			}
			int[] colors = new int[n];
			BitSet visited = new BitSet();
			int total = 0;
			for(int i=0; i<n; i++)
				if(!visited.get(i)) {
					boolean bi = true;
					Arrays.fill(colors, -1);
					LinkedList<Integer> q = new LinkedList<>();
					colors[i] = 0;
					visited.set(i);
					q.add(i);
					while(!q.isEmpty()) {
						int cur = q.poll();
						int nextColor = (colors[cur]+1)%2;
						for(int next: e[cur]) {
							if(colors[next]==colors[cur]) {
								bi = false;
							} else if(colors[next]==-1 && !visited.get(next)) {
								colors[next] = nextColor;
								q.add(next);
							}
							visited.set(next);
						}
					}
					if(bi) {
						int a = 0;
						int b = 0;
						for(int j=0; j<n; j++) if(colors[j]==0) a++; else if(colors[j]==1) b++;
						total+=Math.max(a, b);
					}
				}
			System.out.println(total);
		}
	}
}
