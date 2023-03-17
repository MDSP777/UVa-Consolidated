import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;

public class UVa_11504 {
	static ArrayList<Integer>[] e;
	static ArrayList<Integer> ts;
	static BitSet down;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			down = new BitSet();
			ts = new ArrayList<>();
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			while(m-->0) {
				split = br.readLine().split(" ");
				int s = Integer.parseInt(split[0])-1;
				int t = Integer.parseInt(split[1])-1;
				e[s].add(t);
			}
			int total = 0;
			for(int i=0; i<n; i++)
				if(!down.get(i)){
					dfs(i);
				}
			Collections.reverse(ts);
			down.clear();
			for(int i=0; i<n; i++)
				if(!down.get(ts.get(i))){
					dfs(ts.get(i));
					total++;
				}
			System.out.println(total);
		}
	}
	
	static void dfs(int s) {
		down.set(s);
		for(int i: e[s])
			if(!down.get(i)) dfs(i);
		ts.add(s);
	}
}