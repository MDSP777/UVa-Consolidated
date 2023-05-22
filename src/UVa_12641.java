import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class UVa_12641 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			String[] split = br.readLine().split(" ");
			TreeSet<String>[][] d = new TreeSet[26][26];
			for(int i=0; i<26; i++)
				for(int j=0; j<26; j++)
					d[i][j] = new TreeSet<>();
			for(String s : split)
				d[s.charAt(0)-'a'][s.charAt(s.length()-1)-'a'].add(s);
			
			split = br.readLine().split(" ");
			StringBuilder sb = new StringBuilder();
			for(String s : split){
				String ans = s;
				for(String s2 : d[s.charAt(0)-'a'][s.charAt(s.length()-1)-'a'])
					if(s.length()==s2.length() && equal(s, s2)){
						ans = s2;
						break;
					}
				sb.append(ans).append(" ");
			}
			System.out.println(sb.toString().trim());
		}
	}
	
	static boolean equal(String a, String b){
		char[] u = a.toCharArray();
		char[] v = b.toCharArray();
		Arrays.sort(u);
		Arrays.sort(v);
		for(int i=0; i<u.length; i++)
			if(u[i]!=v[i]) return false;
		return true;
	}
}
