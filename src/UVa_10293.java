import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_10293 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			if(s.equals("#")) {
				System.out.println();
				continue;
			}
			
			StringBuilder sb = new StringBuilder(s);
			if(!s.endsWith("-")) sb.append(" ");
			while(true) {
				s = br.readLine();
				if(s.equals("#")) break;
				sb.append(s);
				if(!s.endsWith("-")) sb.append(" ");
			}
			
			s = sb.toString();
			String[] split = s.split("[\\s?!,.]+");
			int[] f = new int[100];
			
			for(String x : split) {
				int t = 0;
				for(char c : x.toCharArray())
					if(Character.isLetter(c)) t++;
				f[t]++;
			}
			for(int i=1; i<100; i++)
				if(f[i]>0)
					System.out.println(i+" "+f[i]);
			
			System.out.println();
		}
	}
}
