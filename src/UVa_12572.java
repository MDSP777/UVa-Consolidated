import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class UVa_12572 {
	static int MOD = 1000000007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			
			int n = Integer.parseInt(s);
			char[] terms = br.readLine().toCharArray();
			TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
			for(int i=0; i<n; i++) {
				int x = terms[i]-'0';
				if(!map.containsKey(x)) map.put(x, new ArrayList<Integer>());
				map.get(x).add(i);
			}
			
			long total = tri(n);
			long ans = 0;
			TreeSet<Integer> endpoints = new TreeSet<>();
			for(int curMin : map.keySet()){
				ArrayList<Integer> arr = map.get(curMin);
				for(int i : arr) endpoints.add(i);
				int excluded = 0;
				
				int prev = -1;
				for(int i : endpoints){
					if(prev==-1){
						excluded+=tri(i);
					} else {
						excluded+=tri(i-prev-1);
					}
					prev = i;
				}
				excluded+=tri(n-1-prev);
				ans+=((total-excluded)*curMin)%MOD;
				total = excluded;
			}
			
			sb.append(ans%MOD).append("\n");
		}
		System.out.print(sb);
	}
	
	static int tri(int n){
		return n*(n+1)/2;
	}
}
