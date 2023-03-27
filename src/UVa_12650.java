import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class UVa_12650 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			String[] split = s.split(" ");
			int n = Integer.parseInt(split[0]);
			BitSet r = new BitSet();
			split = br.readLine().split(" ");
			for(String st : split) {
				int x = Integer.parseInt(st);
				r.set(x);
			}
			if(r.cardinality()==n) sb.append("*\n");
			else {
				for(int i=1; i<=n; i++)
					if(!r.get(i)) {
						sb.append(i).append(" ");
					}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
