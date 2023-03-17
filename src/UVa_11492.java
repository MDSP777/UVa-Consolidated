import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class UVa_11492 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			HashMap<String, Integer> map = new HashMap<>();
			String[] split = br.readLine().split(" ");
			String src = split[0];
			String dest = split[1];
			String[] s = new String[n];
			String[] d = new String[n];
			String[] w = new String[n];
			HashSet<Integer> srcWords = new HashSet<>();
			HashSet<Integer> destWords = new HashSet<>();
			for(int i=0; i<n; i++){
				split = br.readLine().split(" ");
				s[i] = split[0];
				d[i]  = split[1];
				w[i] = split[2];
				map.put(w[i], i);
				if(s[i].equals(src) || d[i].equals(src)) srcWords.add(i);
				if(s[i].equals(dest) || d[i].equals(dest)) destWords.add(i);
			}
			ArrayList<Integer>[] e = new ArrayList[n];
			for(int i=0; i<n; i++){
				e[i] = new ArrayList<>();
				for(int j=0; j<n; j++)
					if(i!=j && w[i].charAt(0)!=w[j].charAt(0))
						if(s[i].equals(d[j]) || d[i].equals(s[j]) || s[i].equals(s[j]) || d[i].equals(d[j])) e[i].add(j);
			}
			int[] dist = new int[n];
			PriorityQueue<State> q = new PriorityQueue<>();
			for(int i=0; i<n; i++) {
				dist[i] = srcWords.contains(i) ? w[i].length() : 20000000;
				if(srcWords.contains(i)) q.add(new State(i, w[i].length()));
			}
			HashSet<Integer> destCopy = new HashSet<>(destWords);
			while(!q.isEmpty()){
				State cur = q.poll();
				if(destCopy.contains(cur.val)) destCopy.remove(cur.val);
				if(destCopy.isEmpty()) break;
				if(cur.weight>dist[cur.val]) continue;
				for(int next: e[cur.val]){
					int weight = dist[cur.val]+w[next].length();
					if(weight<dist[next]){
						dist[next] = weight;
						q.add(new State(next, dist[next]));
					}
				}
			}
			int ans = 20000000;
			for(int i=0; i<n; i++) if(destWords.contains(i)) ans = Math.min(ans, dist[i]);
			sb.append(ans==20000000 || src.equals(dest) ? "impossivel" : ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static class State implements Comparable<State> {
		int val;
		int weight;
		
		public State(int v, int w){
			val = v;
			weight = w;
		}

		@Override
		public int compareTo(State o) {
			return Integer.compare(weight, o.weight);
		}
	}
}
