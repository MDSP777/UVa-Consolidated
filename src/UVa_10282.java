import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVa_10282 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, String> map = new HashMap<>();
		while(true) {
			String[] split = br.readLine().split("\\s+");
			if(split.length!=2) break;
			map.put(split[1], split[0]);
		}
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			System.out.println(map.containsKey(s) ? map.get(s) : "eh");
		}
	}
}
