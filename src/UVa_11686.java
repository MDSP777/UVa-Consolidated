import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;

public class UVa_11686 {
	static ArrayList<Integer>[] e;
	static BitSet visited;
	static BitSet inUse;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			if(n==0 && m==0) break;
			int[] inD = new int[n];
			e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			while(m-->0){
				split = br.readLine().split(" ");
				int a = Integer.parseInt(split[0])-1;
				int b = Integer.parseInt(split[1])-1;
				inD[b]++;
				e[a].add(b);
			}
			visited = new BitSet();
			inUse = new BitSet();
			boolean hasCycle = false;
			for(int i=0; !hasCycle && i<n; i++)
				if(!visited.get(i)) hasCycle|=dfs(i);
			if(hasCycle) System.out.println("IMPOSSIBLE");
			else {
				LinkedList<Integer> q = new LinkedList<>();
				for(int i=0; i<n; i++) if(inD[i]==0) q.add(i);
				while(!q.isEmpty()){
					int cur = q.poll();
					System.out.println(cur+1);
					for(int next: e[cur]){
						inD[next]--;
						if(inD[next]==0) q.add(next);
					}
				}
			}
		}
	}
	
	static boolean dfs(int cur){
		boolean hasCycle = false;
		visited.set(cur);
		inUse.set(cur);
		for(int next: e[cur])
			if(inUse.get(next)) return true;
			else if(!visited.get(next)) hasCycle|=dfs(next);
		inUse.set(cur, false);
		return hasCycle;
	}
}
