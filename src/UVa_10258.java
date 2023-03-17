import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UVa_10258 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		br.readLine();
		while(nC-->0) {
			HashMap<String, Contestant> map = new HashMap<>();
			while(true) {
				String s = br.readLine();
				if(s==null || s.isEmpty()) break;
				String[] split = s.split(" ");
				if(!map.containsKey(split[0])) map.put(split[0], new Contestant(split[0]));
				Contestant c = map.get(split[0]);
				if(c.acTime[Integer.parseInt(split[1])-1]==-1)
					if(split[3].equals("C")) {
						c.submissions[Integer.parseInt(split[1])-1]++;
						c.acTime[Integer.parseInt(split[1])-1] = Integer.parseInt(split[2]);
					} else if(split[3].equals("I")) c.submissions[Integer.parseInt(split[1])-1]++;
			}
			ArrayList<Contestant> result = new ArrayList<>();
			for(String cur : map.keySet()) result.add(map.get(cur));
			Collections.sort(result);
			for(int i=0; i<result.size(); i++) sb.append(result.get(i)).append("\n");
			if(nC>0) sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static class Contestant implements Comparable<Contestant> {
		String id;
		int[] acTime;
		int[] submissions;
		
		public Contestant(String id){
			this.id = id;
			acTime = new int[9];
			for(int i=0; i<9; i++) acTime[i] = -1;
			submissions = new int[9];
		}

		@Override
		public int compareTo(Contestant o) {
			if(this.totalSolved()>o.totalSolved()) return -1;
			else if(this.totalSolved()<o.totalSolved()) return 1;
			else return Integer.compare(o.totalPenalty(), this.totalPenalty());
		}
		
		public int totalSolved() {
			int total = 0;
			for(int i=0; i<9; i++) if(acTime[i]>-1) total++; 
			return total;
		}
		
		public int totalPenalty() {
			int total = 0;
			for(int i=0; i<9; i++) if(acTime[i]>-1) total += acTime[i] + 20*(submissions[i]-1);
			return total;
		}
		
		public String toString() {
			return id+" "+totalSolved()+" "+totalPenalty();
		}
	}
}
