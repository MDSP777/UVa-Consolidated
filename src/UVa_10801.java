import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UVa_10801 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] speed = new int[n];
			for(int i=0; i<n; i++) speed[i] = sc.nextInt();
			sc.nextLine();
			HashSet<Integer>[] stops = new HashSet[n];
			for(int i=0; i<n; i++) {
				stops[i] = new HashSet<>();
				String[] split = sc.nextLine().split(" ");
				for(int j=0; j<split.length; j++) stops[i].add(Integer.parseInt(split[j]));
			}
			PriorityQueue<Edge> q = new PriorityQueue<>();
			int[] dist = new int[100];
			for(int i=1; i<100; i++) dist[i] = 2000000;
			for(int i=0; i<n; i++)
				if(stops[i].contains(0))
					for(int s: stops[i]) 
						if(s!=0) {
							int time = speed[i]*s;
							dist[s] = time;
							q.add(new Edge(time, s, i));
						}
			while(!q.isEmpty()) {
				Edge cur = q.poll();
				if(cur.dist>dist[cur.floor]) continue;
				for(int i=0; i<n; i++)
					if(i!=cur.elev && stops[i].contains(cur.floor))
						for(int s: stops[i]) 
							if(s!=cur.floor) {
								int time = speed[i]*Math.abs(cur.floor-s)+60;
								if(cur.dist+time<dist[s]) {
									dist[s] = cur.dist+time;
									q.add(new Edge(dist[s], s, i));
								}
							}
			}
			System.out.println(dist[k]==2000000 ? "IMPOSSIBLE" : dist[k]);
		} while(sc.hasNext());
	}
	
	static class Edge implements Comparable<Edge> {
		int dist;
		int floor;
		int elev;
		
		public Edge(int d, int f, int el) {
			dist = d;
			floor = f;
			elev = el;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(dist, o.dist);
		}
		
		public String toString() {
			return "To "+floor+" using "+elev+" with time "+dist;
		}
	}
}
