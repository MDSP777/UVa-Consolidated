import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;


public class UVa_10044 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		for(int curC=1; curC<=nC; curC++){
			String[] split = br.readLine().split(" ");
			int p = Integer.parseInt(split[0]);
			HashMap<String, Integer> map = new HashMap<>();
			map.put("Erdos, P.", 0);
			int n = 1;
			String[][] authors = new String[p][];
			for(int i=0; i<p; i++){
				authors[i] = br.readLine().split(": ")[0].split("\\., ");
				for(int j=0; j<authors[i].length; j++) {
					if(!authors[i][j].endsWith(".")) authors[i][j]+=".";
					if(!map.containsKey(authors[i][j])) map.put(authors[i][j], n++);
				}
			}
			ArrayList<Integer>[] e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			for(int i=0; i<p; i++)
				for(int j=0; j<authors[i].length; j++)
					for(int k=j+1; k<authors[i].length; k++){
						e[map.get(authors[i][j])].add(map.get(authors[i][k]));
						e[map.get(authors[i][k])].add(map.get(authors[i][j]));
					}
			int[] num = new int[n];
			for(int i=1; i<n; i++) num[i] = -1;
			LinkedList<State> q = new LinkedList<>();
			BitSet visited = new BitSet();
			q.add(new State(0, 0));
			visited.set(0);
			while(!q.isEmpty()){
				State cur = q.poll();
				num[cur.val] = cur.depth;
				for(int next: e[cur.val])
					if(!visited.get(next)){
						visited.set(next);
						q.add(new State(next, cur.depth+1));
					}
			}
			p = Integer.parseInt(split[1]);
			System.out.println("Scenario "+curC);
			while(p-->0){
				String s = br.readLine();
				System.out.println(s+" "+(map.get(s)==null || num[map.get(s)]==-1 ? "infinity" : num[map.get(s)]));
			}
		}
	}
	
	static class State{
		int val;
		int depth;
		
		public State(int v, int d){
			val = v;
			depth = d;
		}
	}
}
