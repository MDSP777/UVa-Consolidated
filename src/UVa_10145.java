import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class UVa_10145 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			br.readLine();
			HashMap<Integer, Integer> xLocks = new HashMap<>();
			HashMap<Integer, HashSet<Integer>> sLocks = new HashMap<>();
			HashSet<Integer> denied = new HashSet<>();
			while(true){
				String[] split = br.readLine().split(" ");
				if(split[0].equals("#")) break;
				int tId = Integer.parseInt(split[1]);
				int dId = Integer.parseInt(split[2]);
				
				if(denied.contains(tId)){
					sb.append("IGNORED\n");
					continue;
				}
				if(split[0].equals("S")) {
					if(!xLocks.containsKey(dId) || xLocks.get(dId)==tId){
						sb.append("GRANTED\n");
						if(!sLocks.containsKey(dId)) sLocks.put(dId, new HashSet<Integer>());
						sLocks.get(dId).add(tId);
					} else {
						sb.append("DENIED\n");
						denied.add(tId);
					}
				} else {
					if((xLocks.containsKey(dId) && xLocks.get(dId)!=tId) || 
							(sLocks.containsKey(dId) && (sLocks.get(dId).size()>1 || (sLocks.get(dId).size()==1 && !sLocks.get(dId).contains(tId))))){
						sb.append("DENIED\n");
						denied.add(tId);
					} else {
						sb.append("GRANTED\n");
						xLocks.put(dId, tId);
					}
				}
			}
			if(tc>0) sb.append("\n");
		}
		System.out.print(sb);
	}
}
