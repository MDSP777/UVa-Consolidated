import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class UVa_1233 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			String[] split = br.readLine().split(" ");
			int c = Integer.parseInt(split[0]);
			int n = Integer.parseInt(split[1])+1;
			int[][] adj = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) if(i!=j) adj[i][j] = 2000000;
			split = br.readLine().split(" ");
			HashSet<Integer> usherNext = new HashSet<>();
			for(int i=1; i<split.length; i++) usherNext.add(Integer.parseInt(split[i]));
			for(int i=1; i<n; i++) {
				split = br.readLine().split(" ");
				for(int j=1; j<split.length; j+=2) adj[i][Integer.parseInt(split[j+1])] = Math.min(adj[i][Integer.parseInt(split[j+1])], Integer.parseInt(split[j]));
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++) adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
			int min = 1000000;
			for(int i: usherNext) min = Math.min(min, adj[i][0]);
			int total = 0;
			int box = 0;
			while(box<c) {
				box+=min;
				if(box<c) {
					box--;
					total++;
				}
			}
			sb.append(total).append("\n");
		}
		System.out.print(sb);
	}
}
