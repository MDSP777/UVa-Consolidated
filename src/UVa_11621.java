import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class UVa_11621 {
	public static void main(String[] args) throws Exception {
		TreeSet<Long> c23 = new TreeSet<>();
		long cap = 1l<<32;
		
		for(long i=1; i<=cap; i*=2)
			for(long j=1; j<=cap; j*=3) {
				long x = i*j;
				if(x>cap) break;
				c23.add(x);
			}
		
		for(long i=1; i<=cap; i*=3)
			for(long j=1; j<=cap; j*=2) {
				long x = i*j;
				if(x>cap) break;
				c23.add(x);
			}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			long x = Long.parseLong(br.readLine());
			if(x==0) break;
			sb.append(c23.ceiling(x)).append("\n");
		}
		System.out.print(sb);
	}
}
