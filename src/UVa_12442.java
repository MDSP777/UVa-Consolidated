import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class UVa_12442 {
	static int[] next;
	static int[] ans;
	static BitSet visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		for(int x=1; x<=nC; x++) {
			int n = Integer.parseInt(br.readLine());
			next = new int[n];
			ans = new int[n];
			visited = new BitSet();
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split("\\s+");
				next[Integer.parseInt(split[0])-1] = Integer.parseInt(split[1])-1;
				ans[i] = -1;
			}
			int max = 0;
			int out = 0;
			for(int i=0; i<n; i++) 
				if(ans[i]==-1 && dfs(i)>max) {
					max = ans[i];
					out = i+1;
				}
			sb.append("Case ").append(x).append(": ").append(out).append("\n");
		}
		System.out.print(sb);
	}
	
	
	// note: if lines 2 and 3 of this function are changed to:
	//		 ans[i] = 1;
	//		 if(!visited.get(next[i])) ans[i] += dfs(next[i]);
	//       verdict is TLE. Current implementation is AC. Weird.
	static int dfs(int i) {
		visited.set(i);
		ans[i] = 0;
		if(!visited.get(next[i])) ans[i] = 1+dfs(next[i]);
		visited.clear(i);
		return ans[i];
	}
}
