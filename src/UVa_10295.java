import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;

public class UVa_10295 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("\\s+");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		HashMap<String, BigDecimal> map = new HashMap<>();
		while(n-->0) {
			split = br.readLine().split("\\s+");
			map.put(split[0], new BigDecimal(split[1]));
		}
		while(m-->0) {
			BigDecimal total = BigDecimal.ZERO;
			while(true) {
				String s = br.readLine();
				if(s.equals(".")) break;
				split = s.split(" ");
				for(String cur: split) if(map.containsKey(cur)) total = total.add(map.get(cur));
			}
			System.out.println(total);
		}
	}
}
