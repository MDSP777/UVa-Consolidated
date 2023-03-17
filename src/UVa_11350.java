import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_11350 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			char[] seq = br.readLine().toCharArray();
			Pair p = new Pair(1, 1);
			Pair lb = new Pair(0, 1);
			Pair rb = new Pair(1, 0);
			Pair lc = mediant(p, lb);
			Pair rc = mediant(p, rb);
			for(int i=0; i<seq.length; i++) {
				if(seq[i]=='L') {
					rb = p;
					p = lc;
				} else {
					lb = p;
					p = rc;
				}
				lc = mediant(p, lb);
				rc = mediant(p, rb);
			}
			System.out.println(p);
		}
	}
	
	static Pair mediant(Pair a, Pair b) {
		return new Pair(a.a+b.a, a.b+b.b);
	}
	
	static class Pair {
		long a;
		long b;
		
		public Pair(long a, long b) {
			this.a = a;
			this.b = b;
		}
		
		public String toString() {
			return a+"/"+b;
		}
	}
}
