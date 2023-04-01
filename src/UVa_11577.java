import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_11577 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			char[] c = br.readLine().toCharArray();
			int[] f = new int[26];
			for(int i=0; i<c.length; i++)
				if(c[i]>='A' && c[i]<='Z') f[c[i]-'A']++;
				else if(c[i]>='a' && c[i]<='z') f[c[i]-'a']++;
			StringBuilder sb = new StringBuilder();
			int max = 0;
			for(int i=0; i<26; i++) max = Math.max(max, f[i]);
			for(int i=0; i<26; i++) 
				if(f[i]==max) sb.append((char) (i+'a'));
			System.out.println(sb);
		}
	}
}
