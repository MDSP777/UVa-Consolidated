import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;

public class UVa_168 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			String s = br.readLine();
			if(s.equals("#")) break;
			String[] split = s.split(" ");
			int m = split[1].charAt(0)-'A';
			int t = split[2].charAt(0)-'A';
			int k = Integer.parseInt(split[3]);
			split = split[0].substring(0, split[0].length()-1).split(";");
			ArrayList<Integer>[] e = new ArrayList[26];
			for(int i=0; i<26; i++) e[i] = new ArrayList<>();
			for(int i=0; i<split.length; i++){
				String[] terms = split[i].split(":");
				int src = terms[0].charAt(0)-'A';
				if(terms.length>1) for(int j=0; j<terms[1].length(); j++) e[src].add(terms[1].charAt(j)-'A');
			}
			BitSet safe = new BitSet();
			safe.flip(0, 26);
			int step = 0;
			while(true){
				int choose = -1;
				for(int next : e[m])
					if(next!=t && safe.get(next)){
						choose = next;
						break;
					}
				if(choose!=-1){
					t = m;
					m = choose;
					step++;
					if(step==k){
						step = 0;
						safe.set(t, false);
						sb.append((char)(t+'A')).append(" ");
					}
				} else {
					sb.append("/").append((char)(m+'A')).append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}
}
