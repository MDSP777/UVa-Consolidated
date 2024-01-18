import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class UVa_10113 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> idMap = new HashMap<>();
		LinkedList<Edge>[] adj = new LinkedList[100];
		for(int i=0; i<100; i++) adj[i] = new LinkedList<>();
		
		int curId = 0;
		while(true){
			String s = br.readLine();
			if(s.startsWith(".")) break;
			
			String[] split = s.split(" ");
			if(s.startsWith("!")){
				if(!idMap.containsKey(split[2])) 
					idMap.put(split[2], curId++);
				if(!idMap.containsKey(split[5])) 
					idMap.put(split[5], curId++);
				
				int a = idMap.get(split[2]);
				int b = idMap.get(split[5]);
				long l = Long.parseLong(split[1]);
				long r = Long.parseLong(split[4]);
				
				adj[a].add(new Edge(a, b, l, r));
				adj[b].add(new Edge(b, a, r, l));
			} else {
				if(!idMap.containsKey(split[1]) || !idMap.containsKey(split[3])){
					sb.append(String.format("? %s = ? %s\n", split[1], split[3]));
				} else {
					int src = idMap.get(split[1]);
					int dest = idMap.get(split[3]);
					LinkedList<State> q = new LinkedList<>();
					boolean[] visited = new boolean[100];
					visited[src] = true;
					for(Edge next : adj[src]){
						visited[next.dest] = true;
						q.add(new State(next.dest, next.lCost, next.rCost));
					}
					State ans = null;
					while(!q.isEmpty()){
						State cur = q.poll();
						if(cur.id==dest) {
							ans = cur;
							break;
						}
						
						for(Edge next : adj[cur.id]){
							if(!visited[next.dest]){
								long x = cur.srcCnt*next.lCost, y = cur.destCnt*next.rCost;
								long gcd = gcd(Math.max(x, y), Math.min(x, y));
								q.add(new State(next.dest, x/gcd, y/gcd));
								visited[next.dest] = true;
							}
						}
					}
					
					if(!visited[dest]){
						sb.append(String.format("? %s = ? %s\n", split[1], split[3]));
					} else {
						long gcd = gcd(Math.max(ans.srcCnt, ans.destCnt), Math.min(ans.srcCnt, ans.destCnt));
						sb.append(String.format("%d %s = %d %s\n", ans.srcCnt/gcd, split[1], ans.destCnt/gcd, split[3]));
					}
				}
			}
		}
		System.out.print(sb);
	}
	
	static class State {
		int id;
		long srcCnt, destCnt;
		
		State(int a, long l, long r){
			id = a;
			srcCnt = l;
			destCnt = r;
		}
	}
	
	static long gcd(long a, long b){
		if(b==0) return a;
		
		return gcd(b, a%b);
	}
	
	static class Edge {
		int src, dest;
		long lCost, rCost;
		
		Edge(int a, int b, long l, long r){
			src = a;
			dest = b;
			lCost = l;
			rCost = r;
		}
	}
}
