import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class UVa_12036 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++){
			int n = Integer.parseInt(br.readLine());
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i=0; i<n; i++){
				String[] split = br.readLine().split(" ");
				for(int j=0; j<n; j++){
					int x = Integer.parseInt(split[j]);
					if(!map.containsKey(x)) map.put(x, 0);
					map.put(x, map.get(x)+1);
				}
			}
			boolean yes = true;
			for(Integer key : map.keySet())
				yes &= map.get(key)<=n;
			System.out.println("Case "+t+": "+(yes ? "yes" : "no"));
		}
	}
}
