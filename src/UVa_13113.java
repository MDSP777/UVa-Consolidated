import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_13113 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int s = Integer.parseInt(split[1]);
			ArrayList<Candidate> votes = new ArrayList<>();
			for(int i=0; i<n; i++) votes.add(new Candidate(i+1));
			long total = 0;
			while(s-->0){
				split = br.readLine().split(" ");
				int v = Integer.parseInt(split[n]);
				total+=v;
				
				for(int i=0; i<n; i++){
					double d = Double.parseDouble(split[i]);
					int r = (int) Math.round(v*d/100);
					votes.get(i).votes+=r;
				}
			}
			Collections.sort(votes);
			if(votes.get(0).votes>=0.501*total){
				System.out.println(votes.get(0));
			} else {
				System.out.println(votes.get(0));
				System.out.println(votes.get(1));
			}
			
			if(tc>0) System.out.println();
		}
	}
	
	static class Candidate implements Comparable<Candidate>{
		int id;
		long votes;
		
		Candidate(int a){
			id = a;
			votes = 0;
		}

		@Override
		public int compareTo(Candidate o) {
			if(votes==o.votes) return id-o.id;
			return Long.compare(o.votes, votes);
		}
		
		public String toString() {
			return id+" "+votes;
		}
	}
}
