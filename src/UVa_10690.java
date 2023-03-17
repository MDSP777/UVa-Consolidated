import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_10690 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			String[] split = s.split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			int total = n+m;
			if(n>m) {
				int temp = n;
				n = m;
				m = temp;
			}
			int[] terms = new int[total];
			int sum = 0;
			split = br.readLine().split(" ");
			for(int i=0; i<total; i++) {
				terms[i] = Integer.parseInt(split[i])+50;
				sum+=terms[i];
			}
			boolean[][] reachable = new boolean[55][5050];
			reachable[0][0] = true;
			for(int k=0; k<total; k++){
				ArrayList<Pair> toAdd = new ArrayList<>();
				for(int i=0; i<=k && i<n; i++)
					for(int j=0; j<5050; j++){
						if(reachable[i][j]) toAdd.add(new Pair(i+1, j+terms[k]));
					}
				for(Pair p: toAdd) reachable[p.i][p.j] = true;
			}
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for(int i=0; i<=5000; i++)
				if(reachable[n][i]){
					int val = i-(50*n);
					int right = sum-i-(50*m);
					int ans = val*right;
					min = Math.min(min, ans);
					max = Math.max(max, ans);
				}
			sb.append(max).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
	}
	
	static class Pair{
		int i, j;
		
		Pair(int a, int b){
			i = a;
			j = b;
		}
	}
}
