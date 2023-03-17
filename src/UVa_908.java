import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class UVa_908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean first = true;
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			if(s.isEmpty()) s = br.readLine();
			if(first) first = false;
			else System.out.println();
			long n = Long.parseLong(s);
			long o_total = 0;
			ArrayList<Edge>[] e = new ArrayList[(int) n];
			e[0] = new ArrayList<>();
			for(int i=1; i<n; i++) {
				String[] split = br.readLine().split("\\s+");
				o_total+=Long.parseLong(split[2]);
				e[i] = new ArrayList<>();
			}
			long k = Long.parseLong(br.readLine());
			for(int i=0; i<k; i++) {
				String[] split = br.readLine().split("\\s+");
				int a = Integer.parseInt(split[0])-1;
				int b = Integer.parseInt(split[1])-1;
				int w = Integer.parseInt(split[2]);
				e[a].add(new Edge(a, b, w));
				e[b].add(new Edge(b, a, w));
			}
			long m = Long.parseLong(br.readLine());
			for(int i=0; i<m; i++) {
				String[] split = br.readLine().split("\\s+");
				int a = Integer.parseInt(split[0])-1;
				int b = Integer.parseInt(split[1])-1;
				int w = Integer.parseInt(split[2]);
				e[a].add(new Edge(a, b, w));
				e[b].add(new Edge(b, a, w));
			}
			HashSet<Integer> visited = new HashSet<>();
			visited.add(0);
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for(Edge ed: e[0]) pq.add(ed);
			long total = 0;
			while(visited.size()<n) {
				Edge cur = pq.poll();
				if(!visited.contains(cur.src)) {
					total+=cur.weight;
					for(Edge ed: e[cur.src]) if(!visited.contains(ed.dest)) pq.add(ed);
					visited.add(cur.src);
				} else if(!visited.contains(cur.dest)) {
					total+=cur.weight;
					for(Edge ed: e[cur.dest]) if(!visited.contains(ed.dest)) pq.add(ed);
					visited.add(cur.dest);
				}
			}
			System.out.println(o_total);
			System.out.println(total);
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;
		
		public Edge(int s, int d, int w) {
			src = s;
			dest = d;
			weight = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
