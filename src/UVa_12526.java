import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVa_12526 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			int n = Integer.parseInt(s);
			char[][] terms = new char[n][];
			Trie[] dict = new Trie[26];
			
			for(int i=0; i<n; i++) {
				terms[i] = br.readLine().toCharArray();
				if(dict[terms[i][0]-'a']==null) 
					dict[terms[i][0]-'a'] = new Trie(terms[i][0]);
				Trie cur = dict[terms[i][0]-'a'];
				for(int j=1; j<terms[i].length; j++) {
					if(!cur.next.containsKey(terms[i][j]))
						cur.next.put(terms[i][j], new Trie(terms[i][j]));
					
					cur = cur.next.get(terms[i][j]);
				}
				cur.hasWord = true;
			}
			
			double total = 0;
			for(int i=0; i<n; i++) {
				Trie cur = dict[terms[i][0]-'a'];
				for(int j=1; j<terms[i].length; j++) {
					if(cur.next.size()>1 || cur.hasWord) 
						total++;
					
					cur = cur.next.get(terms[i][j]);
				}
				if(cur.next.size()>1 || cur.hasWord) total++;
			}
			System.out.printf("%.2f\n", total/n);
		}
	}
	
	static class Trie {
		boolean hasWord;
		char val;
		HashMap<Character, Trie> next;
		
		Trie(char v){
			val = v;
			next = new HashMap<>();
		}
	}
}
