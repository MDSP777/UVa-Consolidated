import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_11824 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			ArrayList<Long> a = new ArrayList<>();
			while(true) {
				long n = Long.parseLong(br.readLine());
				if(n==0) break;
				a.add(n);
			}
			Collections.sort(a, Collections.reverseOrder());
			long total = 0;
			for(int i=0; i<a.size(); i++) {
				total+=2*Math.pow(a.get(i), i+1);
				if(total>5000000) break;
			}
			System.out.println(total>5000000 ? "Too expensive" : total);
		}
	}
}
