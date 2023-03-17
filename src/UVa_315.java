import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class UVa_315 {
	static ArrayList<Integer>[] e;
	static int[] dfsLow;
	static int[] dfsNum;
	static int dfsCtr;
	static int[] dfsParent;
	static int dfsRoot;
	static int rootChildren;
	static boolean[] articulation;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			while(true){
				String[] split = br.readLine().split(" ");
				int src = Integer.parseInt(split[0]);
				if(src==0) break;
				src--;
				for(int i=1; i<split.length; i++){
					int dest = Integer.parseInt(split[i])-1;
					e[src].add(dest);
					e[dest].add(src);
				}
			}
			dfsCtr = 0;
			dfsNum = new int[n];
			Arrays.fill(dfsNum, -1);
			dfsLow = new int[n];
			dfsParent = new int[n];
			articulation = new boolean[n];
			for(int i=0; i<n; i++)
				if(dfsNum[i]==-1){
					dfsRoot = i;
					rootChildren = 0;
					f(i);
					articulation[dfsRoot] = (rootChildren>1);
				}
			int total = 0;
			for(int i=0; i<n; i++) if(articulation[i]) total++;
			System.out.println(total);
		}
	}
	
	static void f(int u){
		dfsLow[u] = dfsNum[u] = dfsCtr++;
		for(int j=0; j<e[u].size(); j++){
			int v = e[u].get(j);
			if(dfsNum[v]==-1){
				dfsParent[v] = u;
				if(u==dfsRoot) rootChildren++;
				f(v);
				if(dfsLow[v]>=dfsNum[u]) articulation[u] = true;
				dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);
			} else if(v!=dfsParent[u]) dfsLow[u] = Math.min(dfsLow[u], dfsNum[v]);
		}
	}
}
