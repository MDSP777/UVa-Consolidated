import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UVa_10449 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int c = 1;
			do {
				int n = sc.nextInt();
				int[] b = new int[n];
				ArrayList<Integer>[] e = new ArrayList[n];
				for(int i=0; i<n; i++) {
					b[i] = sc.nextInt();
					e[i] = new ArrayList<>();
				}
				int r = sc.nextInt();
				while(r-->0) e[sc.nextInt()-1].add(sc.nextInt()-1);
				long[] dist = new long[n];
				for(int i=1; i<n; i++) dist[i] = Long.MAX_VALUE/2;
				for(int v=0; v<n-1; v++) {
					for(int i=0; i<n; i++) {
	//					System.out.println(Arrays.toString(dist));
						if(dist[i]==Long.MAX_VALUE/2) continue;
						for(int next : e[i]) dist[next] = (long) Math.min(dist[next], dist[i]+Math.pow(b[next]-b[i], 3));
					}
	//				System.out.println(Arrays.toString(dist)+"\n");
				}
				long[] oDist = new long[n];
				for(int i=0; i<n; i++) oDist[i] = dist[i];
				System.out.println("Set #"+c++);
				for(int v=0; v<n-1; v++) {
					for(int i=0; i<n; i++) {
	//					System.out.println(Arrays.toString(dist));
						if(dist[i]==Long.MAX_VALUE/2) continue;
						for(int next : e[i]) dist[next] = (long) Math.min(dist[next], dist[i]+Math.pow(b[next]-b[i], 3));
					}
				}
				int q = sc.nextInt();
				while(q-->0) {
					int s = sc.nextInt()-1;
					boolean hasNegCycle = dist[s]<oDist[s];
					System.out.println(dist[s]==Long.MAX_VALUE/2 || hasNegCycle  || dist[s]<3 ? "?" : dist[s]);
				}
			} while(sc.hasNext());
		} catch(Exception e) {}
	}
}
