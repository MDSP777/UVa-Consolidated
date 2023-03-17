import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_10557 {
	static ArrayList<Integer>[] e;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			if(n<0) break;
			int[] energy = new int[n];
			e = new ArrayList[n];
			for(int i=0; i<n; i++) {
				e[i] = new ArrayList<>();
				energy[i] = sc.nextInt()*-1;
				int x = sc.nextInt();
				while(x-->0) e[i].add(sc.nextInt()-1);
			}
			int[] dist = new int[n];
			for(int i=1; i<n; i++) dist[i] = 2000000;
			for(int v=0; v<n-1; v++) {
				for(int i=0; i<n; i++) {
					if(dist[i]==2000000) continue;
					for(int next : e[i]) if(dist[i]+energy[next]<100) dist[next] = Math.min(dist[next], dist[i]+energy[next]);
				}
			}
			if(dist[n-1]<100) System.out.println("winnable");
			else {
				boolean hasNegCycle = false;
				for(int i=0; !hasNegCycle && i<n; i++) {
					if(dist[i]==2000000) continue;
					for(int next : e[i]) 
						if(dist[i]+energy[next]<100 && dist[i]+energy[next]<dist[next] && canReachEnd(i)) {
							hasNegCycle = true;
							break;
						}
				}
				System.out.println(hasNegCycle ? "winnable" : "hopeless");
			}
		}
	}

	private static boolean canReachEnd(int i) {
		BitSet bs = new BitSet();
		LinkedList<Integer> q = new LinkedList<>();
		q.add(i);
		bs.set(i);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : e[cur])
				if(!bs.get(next)) {
					bs.set(next);
					if(next==n-1) return true;
					q.add(next);
				}
		}
		return false;
	}
}
