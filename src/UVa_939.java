import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class UVa_939 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> map = new TreeMap<>();
		HashMap<String, ArrayList<String>> parents = new HashMap<>();
		while(nC-->0) {
			String[] split = br.readLine().split("\\s+");
			if(split[1].equals("non-existent") || split[1].equals("recessive") || split[1].equals("dominant")) 
				map.put(split[0], split[1].equals("dominant") ? 1 : split[1].equals("recessive") ? 0 : -1);
			else {
				if(!parents.containsKey(split[1])) parents.put(split[1], new ArrayList<>());
				parents.get(split[1]).add(split[0]);
			}
		}
		while(!parents.isEmpty()) {
			ArrayList<String> toRemove = new ArrayList<>();
			for(String child : parents.keySet()) {
				ArrayList<String> p = parents.get(child);
				if(map.containsKey(p.get(0)) && map.containsKey(p.get(1))) {
					if(map.get(p.get(0))==1 || map.get(p.get(1))==1 || (map.get(p.get(0))>-1 && map.get(p.get(1))>-1)) {
						map.put(child, map.get(p.get(0))+map.get(p.get(1))>0 ? 1 : 0);
					} else map.put(child, -1);
					toRemove.add(child);
				}
			}
			for(String r: toRemove) parents.remove(r);
		}
		for(String s: map.keySet()) System.out.println(s+" "+(map.get(s)== 1 ? "dominant" : map.get(s)==0 ? "recessive" : "non-existent"));
	}
}
