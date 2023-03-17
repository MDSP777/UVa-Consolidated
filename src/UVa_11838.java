import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Stack;


public class UVa_11838 {
	static int[] dfsNum;
	static int[] dfsLow;
	static BitSet visited;
	static Stack<Integer> s;
	static int dfsCtr;
	static int n;
	static int sccCtr;
	static ArrayList<Integer>[] e;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] split = br.readLine().split(" ");
			n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			if(n==0 && m==0) break;
			e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			while(m-->0){
				split = br.readLine().split(" ");
				int s = Integer.parseInt(split[0])-1;
				int t = Integer.parseInt(split[1])-1;
				e[s].add(t);
				if(split[2].equals("2")) e[t].add(s);
			}
			dfsNum = new int[n];
			dfsLow = new int[n];
			visited = new BitSet();
			dfsCtr = sccCtr = 0;
			s = new Stack<>();
			Arrays.fill(dfsNum, -1);
			for(int i=0; i<n; i++)
				if(dfsNum[i]==-1) scc(i);
			System.out.println(sccCtr==1 ? 1 : 0);
		}
	}
	
	static void scc(int u){
		dfsLow[u] = dfsNum[u] = dfsCtr++;
		s.push(u);
		visited.set(u);
		for(int i=0; i<e[u].size(); i++){
			int v = e[u].get(i);
			if(dfsNum[v]==-1) scc(v);
			if(visited.get(v)) dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);
		}
		if(dfsLow[u]==dfsNum[u]){
			while(true){
				int x = s.pop();
				visited.clear(x);
				if(u==x) break;
			}
			sccCtr++;
		}
	}
}
