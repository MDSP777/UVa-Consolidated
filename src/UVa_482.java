import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_482 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			br.readLine();
			String[] indices = br.readLine().split(" ");
			String[] vals = br.readLine().split(" ");
			ArrayList<Term> terms = new ArrayList<>();
			for(int i=0; i<vals.length; i++) terms.add(new Term(vals[i], Integer.parseInt(indices[i])));
			Collections.sort(terms);
			for(int i=0; i<vals.length; i++)
				System.out.println(terms.get(i).val);
			if(nC>0) System.out.println();
		}
	}
	
	static class Term implements Comparable<Term> {
		String val;
		int index;
		
		public Term(String v, int i) {
			val = v;
			index = i;
		}

		@Override
		public int compareTo(Term o) {
			return Integer.compare(this.index, o.index);
		}	
	}
}
