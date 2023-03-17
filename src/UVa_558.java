import java.util.ArrayList;
import java.util.Scanner;

public class UVa_558 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			ArrayList<Edge>[] e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			while(k-->0) e[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
			int[] dist = new int[n];
			for(int i=1; i<n; i++) dist[i] = 2000000;
			for(int v=0; v<n-1; v++)
				for(int i=0; i<n; i++) 	
					for(Edge j : e[i]) dist[j.dest] = Math.min(dist[j.dest], dist[i]+j.weight);
			boolean s = false;
			for(int i=0; !s && i<n; i++) 	
				for(Edge j : e[i]) 
					if(dist[i]+j.weight<dist[j.dest]) {
						s = true;
						break;
					}
			System.out.println(s ? "possible" : "not possible");
		}
	}
	
	static class Edge {
		int dest;
		int weight;
		
		public Edge(int d, int w) {
			dest = d;
			weight = w;
		}
	}
}
