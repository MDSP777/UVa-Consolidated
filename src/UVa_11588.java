import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVa_11588 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		for(int x=1; x<=nC; x++) {
			String[] split = br.readLine().split("\\s+");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			int n = Integer.parseInt(split[2]);
			int m = Integer.parseInt(split[3]);
			HashMap<Character, Integer> map = new HashMap<>();
			int max = 0;
			for(int i=0; i<r; i++) {
				char[] row = br.readLine().toCharArray();
				for(int j=0; j<c; j++) {
					map.put(row[j], map.containsKey(row[j]) ? map.get(row[j])+1 : 1);
					max = Math.max(max, map.get(row[j]));
				}
			}
			int total = 0;
			for(char cur: map.keySet()) total+=map.get(cur)*(map.get(cur)==max ? n : m);
			System.out.println("Case "+x+": "+total);
		}
	}
}
