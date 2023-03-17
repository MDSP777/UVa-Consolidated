import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;

public class UVa_10687 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			int[] x = new int[n];
			int[] y = new int[n];
			String[] split = br.readLine().split("\\s+");
			for(int i=0; i<n; i++) {
				x[i] = Integer.parseInt(split[i*2]);
				y[i] = Integer.parseInt(split[i*2+1]);
			}
			int[][] e = new int[n][2];
			for(int i=0; i<n; i++) {
				double min1 = Double.MAX_VALUE;
				double min2 = Double.MAX_VALUE;
				int min1x = 100;
				int min1y = 100;
				int min2x = 100;
				int min2y = 100;
				Arrays.fill(e[i], -1);
				for(int j=0; j<n; j++) 
					if(i!=j) {
						double dist = ((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
						if(dist<min1 || (dist==min1 && (x[j]<min1x || (x[j]==min1x && y[j]<min1y)))) {
							if(min1<min2 || (min1==min2 && (min1x<min2x || (min1x==min2x && min1y<min2y)))) {
								min2 = min1;
								e[i][1] = e[i][0];
								min2x = min1x;
								min2y = min1y;
							}
							min1 = dist;
							e[i][0] = j;
							min1x = x[j];
							min1y = y[j];
						} else if(dist<min2 || (dist==min2 && (x[j]<min2x || (x[j]==min2x && y[j]<min2y)))) {
							min2 = dist;
							e[i][1] = j;
							min2x = x[j];
							min2y = y[j];
						}
					}
			}
			BitSet visited = new BitSet();
			LinkedList<Integer> q = new LinkedList<>();
			q.add(0);
			visited.set(0);
			while(!q.isEmpty()) {
				int cur = q.poll();
				if(e[cur][0]!=-1 && !visited.get(e[cur][0])) {
					visited.set(e[cur][0]);
					q.add(e[cur][0]);
				}
				if(e[cur][1]!=-1 && !visited.get(e[cur][1])) {
					visited.set(e[cur][1]);
					q.add(e[cur][1]);
				}
			}
			sb.append(visited.cardinality()==n ? "All stations are reachable.\n" : "There are stations that are unreachable.\n");
		}
		System.out.print(sb);
	}
}
