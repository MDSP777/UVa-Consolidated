import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVa_860 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"), 65536);
		while(true) {
			int total = 0;
			HashMap<String, Integer> map = new HashMap<>();
			while(true) {
				String s = br.readLine();
				if(s.equals("****END_OF_TEXT****")) break;
				if(s.equals("****END_OF_INPUT****")) return;
				String[] split = s.toLowerCase().split("[,.:;!?\"() \\t\\n]+");
				for(String cur: split) {
					if(cur.isEmpty()) continue;
					total++;
					map.put(cur, map.containsKey(cur) ? map.get(cur)+1 : 1);
				}
			}
			double et = 0;
			double emax = Math.log10(total);
			for(String s : map.keySet()) et+=(emax-Math.log10(map.get(s)))*map.get(s);
			et/=total;
			System.out.printf("%d %.1f %.0f\n", total, total==0 ? 0 : et, total==0 ? 0 : et*100/emax);
		}
	}
}
