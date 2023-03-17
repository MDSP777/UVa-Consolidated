import java.util.HashMap;
import java.util.Scanner;

public class UVa_10009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int r = sc.nextInt();
			int q = sc.nextInt();
			HashMap<String, Integer> map = new HashMap<>();
			HashMap<Integer, String> map2 = new HashMap<>();
			int index = 1;
			map.put("Rome", 0);
			map2.put(0, "Rome");
			int[] x = new int[r];
			int[] y = new int[r];
			for(int i=0; i<r; i++) {
				String s1 = sc.next();
				String s2 = sc.next();
				if(!map.containsKey(s1)) {
					map.put(s1, index);
					map2.put(index++, s1);
				}
				if(!map.containsKey(s2)) {
					map.put(s2, index);
					map2.put(index++, s2);
				}
				x[i] = map.get(s1);
				y[i] = map.get(s2);
			}
			int[][] adj = new int[index][index];
			int[][] next = new int[index][index];
			for(int i=0; i<index; i++)
				for(int j=i+1; j<index; j++) adj[i][j] = adj[j][i] = 2000000;
			for(int i=0; i<r; i++) {
				adj[x[i]][y[i]] = adj[y[i]][x[i]] = 1;
				next[x[i]][y[i]] = y[i];
				next[y[i]][x[i]] = x[i];
			}
			for(int k=0; k<index; k++)
				for(int i=0; i<index; i++)
					for(int j=0; j<index; j++)
						if(adj[i][k]+adj[k][j]<adj[i][j]) {
							adj[i][j] = adj[i][k]+adj[k][j];
							next[i][j] = next[i][k];
						}
			while(q-->0) {
				int s = map.get(sc.next());
				int d = map.get(sc.next());
				StringBuilder sb = new StringBuilder();
				sb.append(map2.get(s).charAt(0));
				while(next[s][d]!=d) {
					s = next[s][d];
					sb.append(map2.get(s).charAt(0));
				}
				sb.append(map2.get(d).charAt(0));
				System.out.println(sb);
			}
			if(nC>0) System.out.println();
		}
	}
}
