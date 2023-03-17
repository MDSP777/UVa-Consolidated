import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class UVa_10054 {
	static ArrayList<Integer> path;
	static HashMap<Integer, ArrayList<Edge>> e;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int start = -1;
			e = new HashMap<>();
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split(" ");
				int s = Integer.parseInt(split[0]);
				int d = Integer.parseInt(split[1]);
				if(start==-1) start = s;
				if(!e.containsKey(s)) e.put(s, new ArrayList<>());
				if(!e.containsKey(d)) e.put(d, new ArrayList<>());
				e.get(s).add(new Edge(s, d));
				e.get(d).add(new Edge(d, s));
			}
			boolean hasTour = true;
			for(int cur : e.keySet()) {
				if(!hasTour) break;
				hasTour&=(e.get(cur).size()&1)==0;
			}
			sb.append("Case #").append(t).append("\n");
			if(hasTour) {
				path = new ArrayList<>();
				dfs(start);
				if(path.size()!=n+1) sb.append("some beads may be lost\n");
				else for(int i=1; i<path.size(); i++) sb.append(path.get(i-1)).append(" ").append(path.get(i)).append("\n");
			} else sb.append("some beads may be lost\n");
			if(t<tc) sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static void dfs(int cur) {
		for(Edge ed : e.get(cur)) {
			if(!ed.used) {
				ed.used = true;
				for(Edge ed2 : e.get(ed.dest))
					if(ed2.dest==ed.src && !ed2.used) {
						ed2.used = true;
						break;
					}
				dfs(ed.dest);
			}
		}
		path.add(cur);
	}
	
	static class Edge{
		int src, dest;
		boolean used;
		
		Edge(int a, int b){
			src = a;
			dest = b;
			used = false;
		}
	}
}
