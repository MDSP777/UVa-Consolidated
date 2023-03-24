import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;


public class UVa_380 {
	static HashMap<String, TreeMap<Integer, Forward>> map;
	static HashSet<String> visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		System.out.println("CALL FORWARDING OUTPUT");
		for(int t=1; t<=tc; t++){
			map = new HashMap<>();
			while(true){
				String[] split = br.readLine().split(" ");
				if(split.length==1) break;
				String src = split[0], dest = split[3];
				int start = Integer.parseInt(split[1]), dur = Integer.parseInt(split[2]);
				if(!map.containsKey(src)) map.put(src, new TreeMap<>());
				map.get(src).put(start, new Forward(start, dur, dest));
			}
			System.out.println("SYSTEM "+t);
			while(true){
				String[] split = br.readLine().split(" ");
				if(split.length==1) break;
				int time = Integer.parseInt(split[0]);
				visited = new HashSet<>();
				System.out.println("AT "+split[0]+" CALL TO "+split[1]+" RINGS "+bt(split[1], time));
			}
		}
		System.out.println("END OF OUTPUT");
	}
	
	static String bt(String cur, int time){
		visited.add(cur);
		TreeMap<Integer, Forward> f = map.get(cur);
		if(f==null) return cur;
		Integer k = f.floorKey(time);
		if(k==null || f.get(k).end < time) return cur;
		
		if(visited.contains(f.get(k).target)) return "9999";
		return bt(f.get(k).target, time);
	}
	
	static class Forward implements Comparable<Forward> {
		int start, end;
		String target;
		
		Forward(int s, int d, String t){
			start = s;
			end = s+d;
			target = t;
		}

		@Override
		public int compareTo(Forward o) {
			return start-o.start;
		}
	}
}
