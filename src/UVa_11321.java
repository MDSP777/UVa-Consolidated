import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UVa_11321 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			System.out.println(s);
			String[] split = s.split("\\s+");
			if(split[0].equals("0")) break;
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			ArrayList<Integer> l = new ArrayList<>();
			for(int i=0; i<n; i++) l.add(Integer.parseInt(br.readLine()));
			Collections.sort(l, new Comparator<Integer>() {
				public int compare(Integer a, Integer b) {
					if(a%m==b%m)
						if(Math.abs(a)%2==1 && Math.abs(b)%2==1) return Integer.compare(b, a);
						else if(Math.abs(a)%2==0 && Math.abs(b)%2==0) return Integer.compare(a, b);
						else 
							if(Math.abs(a)%2==1) return -1;
							else return 1;
					return Integer.compare(a%m, b%m);
				}
			});
			for(int i=0; i<n; i++) System.out.println(l.get(i));
		}
	}
}
