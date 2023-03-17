import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UVa_10905 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			String[] split = br.readLine().split("\\s+");
			ArrayList<String> s = new ArrayList<>();
			for(int i=0; i<n; i++) s.add(split[i]);
			Collections.sort(s, new Comparator<String>() {
				public int compare(String a, String b) {
					return (a+b).compareTo(b+a);
				}
			});
			for(int i=n-1; i>=0; i--) sb.append(s.get(i));
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
