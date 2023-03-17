import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class UVa_10895 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split("\\s+");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			TreeMap<Integer, Integer>[] t = new TreeMap[c];
			for(int i=0; i<c; i++) t[i] = new TreeMap<>();
			for(int i=0; i<r; i++) {
				split = br.readLine().split("\\s+");
				String[] split2 = br.readLine().split("\\s+");
				int nTerms = Integer.parseInt(split[0]);
				for(int j=0; j<nTerms; j++) t[Integer.parseInt(split[j+1])-1].put(i, Integer.parseInt(split2[j]));
			}
			System.out.println(c+" "+r);
			for(int i=0; i<c; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(t[i].size());
				for(int j : t[i].keySet()) sb.append(" ").append(j+1);
				System.out.println(sb);
				sb = new StringBuilder();
				for(int j : t[i].values()) sb.append(j).append(" ");
				System.out.println(sb.toString().trim());
			}
		}
	}
}
