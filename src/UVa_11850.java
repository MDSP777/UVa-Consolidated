import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_11850 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			ArrayList<Integer> s = new ArrayList<>();
			while(n-->0) s.add(Integer.parseInt(br.readLine()));
			Collections.sort(s);
			boolean yes = true;
			for(int i=1; i<s.size(); i++) yes&=s.get(i)-s.get(i-1)<=200;
			yes&=(1422-s.get(s.size()-1))*2<=200;
			System.out.println(yes ? "POSSIBLE" : "IMPOSSIBLE");
		}
	}
}
