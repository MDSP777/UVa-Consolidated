import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;

public class UVa_11792 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int s = Integer.parseInt(split[1]);
			ArrayList<Integer>[] e = new ArrayList[n];
			int[] f = new int[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			ArrayList<Integer> important = new ArrayList<>();
			while(s-->0){
				split = br.readLine().split(" ");
				for(int i=0; i<split.length-2; i++){
					int src = Integer.parseInt(split[i])-1;
					int dest = Integer.parseInt(split[i+1])-1;
					e[src].add(dest);
					e[dest].add(src);
					f[src]++;
				}
				f[Integer.parseInt(split[split.length-2])-1]++;
			}
			for(int i=0; i<n; i++) if(f[i]>1) important.add(i);
			int ans = -1;
			int best = 1000000000;
			for(int src : important){
				int dist = 0;
				LinkedList<State> q = new LinkedList<>();
				BitSet visited = new BitSet();
				q.add(new State(src, 0));
				visited.set(src);
				while(!q.isEmpty()){
					State cur = q.poll();
					if(cur.val!=src && f[cur.val]>1) dist+=cur.depth;
					for(int next : e[cur.val])
						if(!visited.get(next)){
							visited.set(next);
							q.add(new State(next, cur.depth+1));
						}
				}
				if(dist<best){
					best = dist;
					ans = src+1;
				}
			}
			sb.append("Krochanska is in: ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static class State{
		int val, depth;
		
		State(int v, int d){
			val = v;
			depth = d;
		}
	}
}
