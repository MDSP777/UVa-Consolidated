import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class UVa_13190 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int k = Integer.parseInt(split[1]);
			int[] times = new int[n];
			int[] prio = new int[n];
			PriorityQueue<Drug> q = new PriorityQueue<>();
			for(int i=0; i<n; i++){
				split = br.readLine().split(" ");
				times[i] = Integer.parseInt(split[1]);
				prio[i] = i;
				q.add(new Drug(prio[i], times[i], split[0]));
			}
			while(k-->0){
				Drug d = q.poll();
				sb.append(d.time).append(" ").append(d.name).append("\n");
				d.time+=times[d.priority];
				q.add(d);
			}
		}
		System.out.print(sb);
	}
	
	static class Drug implements Comparable<Drug> {
		int priority, time;
		String name;
		
		Drug(int a, int b, String c){
			priority = a;
			time = b;
			name = c;
		}

		@Override
		public int compareTo(Drug o) {
			if(time==o.time) return priority-o.priority;
			return time-o.time;
		}
	}
}
