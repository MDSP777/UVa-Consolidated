import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class UVa_200 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> lines = new ArrayList<>();
		HashSet<Character> c = new HashSet<>();
		while(true){
			String s = br.readLine();
			if(s.equals("#")) break;
			lines.add(s);
			for(int i=0; i<s.length(); i++) c.add(s.charAt(i));
		}
		int n = 0;
		HashMap<Character, Integer> index = new HashMap<>();
		char[] letters = new char[26];
		for(char cur: c) {
			index.put(cur, n);
			letters[n++] = cur; 
		}
		ArrayList<Integer>[] e = new ArrayList[n];
		for(int i=0; i<n; i++) e[i] = new ArrayList<>();
		int[] in = new int[n];
		for(int i=0; i<20; i++)
			for(int j=1; j<lines.size(); j++){
				String a = lines.get(j-1);
				String b = lines.get(j);
				if(a.length()>i && b.length()>i && a.substring(0, i).equals(b.substring(0, i)) && a.charAt(i)!=b.charAt(i)){
					in[index.get(b.charAt(i))]++;
					e[index.get(a.charAt(i))].add(index.get(b.charAt(i)));
				}
			}
		LinkedList<Integer> q = new LinkedList<>();
		for(int i=0; i<n; i++) if(in[i]==0) q.add(i);
		StringBuilder out = new StringBuilder();
		while(!q.isEmpty()){
			int cur = q.poll();
			out.append(letters[cur]);
			for(int next: e[cur]){
				in[next]--;
				if(in[next]==0) q.add(next);
			}
		}
		System.out.println(out);
	}
}
