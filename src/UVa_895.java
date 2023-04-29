import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_895 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> d = new ArrayList<>();
		while(true) {
			String s = br.readLine();
			if(s.equals("#")) break;
			int[] f = new int[26];
			for(char c : s.toCharArray())
				f[c-'a']++;
			d.add(f);
		}
		
		while(true) {
			String s = br.readLine();
			if(s.equals("#")) break;
			String[] split = s.split(" ");
			int[] f = new int[26];
			for(String x : split)
				f[x.charAt(0)-'a']++;
			
			int total = 0;
			for(int[] x : d) {
				boolean can = true;
				for(int i=0; can && i<26; i++)
					can&=x[i]<=f[i];
				if(can) total++;
			}
			System.out.println(total);
		}
	}
}
