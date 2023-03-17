import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UVa_123 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> ignore = new HashSet<>();
		while(true) {
			String s = br.readLine();
			if(s.equals("::")) break;
			ignore.add(s);
		}
		ArrayList<Sentence> l = new ArrayList<>();
		int index = 0;
		while(true) {
			String orig = br.readLine();
			if(orig==null) break;
			String s = orig.toLowerCase();
			String[] split = s.split(" ");
			for(int i=0; i<split.length; i++) if(!split[i].isEmpty() && !ignore.contains(split[i])) l.add(new Sentence(orig, split[i], i, index));
			index++;
		}
		Collections.sort(l);
		for(Sentence s: l) System.out.println(s);
	}
	
	static class Sentence implements Comparable<Sentence> {
		String orig;
		String keyword;
		int keywordIndex;
		int orig_index;
		String res;
		
		public Sentence(String orig, String keyword, int index, int orig_index) {
			this.orig = orig.toLowerCase();
			this.keyword = keyword;
			this.keywordIndex = index;
			this.orig_index = orig_index;
		}

		@Override
		public int compareTo(Sentence o) {
			if(this.keyword.equals(o.keyword)) {
				if(this.orig_index==o.orig_index) return Integer.compare(this.keywordIndex, o.keywordIndex);
				return Integer.compare(this.orig_index, o.orig_index);
			}
			return this.keyword.compareTo(o.keyword);
		}
		
		public String toString() {
			String[] split = orig.split(" ");
			split[keywordIndex] = split[keywordIndex].toUpperCase();
			StringBuilder sb = new StringBuilder(split[0]);
			for(int i=1; i<split.length; i++) sb.append(" ").append(split[i]);
			return sb.toString();
		}
	}
}
