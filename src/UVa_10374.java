import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// note: according to forums, judge data seems to have leading/trailing spaces, so trim all strings to be safe
public class UVa_10374 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		boolean first = true;
		while(tc-->0) {
			if(first) first = false;
			else System.out.println();
			br.readLine();
			int n = Integer.parseInt(br.readLine().trim());
			HashMap<String, String> party = new HashMap<>(); 
			HashMap<String, Integer> votes = new HashMap<>();
			while(n-->0) {
				String c = br.readLine().trim();
				String p = br.readLine().trim();
				party.put(c, p);
				votes.put(c, 0);
			}
			int v = Integer.parseInt(br.readLine().trim());
			while(v-->0) {
				String c = br.readLine().trim();
				if(votes.containsKey(c)) votes.put(c, votes.get(c)+1);
			}
			
			int maxVotes = 0;
			for(String k : votes.keySet())
				maxVotes = Math.max(maxVotes, votes.get(k));
			
			int mCtr = 0;
			String w = "";
			for(String k : votes.keySet())
				if(votes.get(k)==maxVotes) {
					mCtr++;
					w = party.get(k);
				}
			if(mCtr>1) System.out.println("tie");
			else System.out.println(w);
		}
	}
}
