import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class UVa_11991 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split("\\s+");
			int q = Integer.parseInt(split[1]);
			HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
			split = br.readLine().split("\\s+");
			for(int i=0; i<split.length; i++) {
				int x = Integer.parseInt(split[i]);
				if(!adj.containsKey(x)) adj.put(x, new ArrayList<>());
				adj.get(x).add(i+1);
			}
			while(q-->0) {
				split = br.readLine().split("\\s+");
				int i = Integer.parseInt(split[0]);
				int x = Integer.parseInt(split[1]);
				if(!adj.containsKey(x) || adj.get(x).size()<i) sb.append("0").append("\n");
				else sb.append(adj.get(x).get(i-1)).append("\n");
			}
		}
		System.out.print(sb);
	}
}
