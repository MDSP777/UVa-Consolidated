import java.util.ArrayList;
import java.util.Collections;

public class UVa_386 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		ArrayList<Triple> t = new ArrayList<>();
		int cap = cube(200);
		
		for(int b=2; b<=200; b++)
			for(int c=b+1; c<=200; c++)
				for(int d=c+1; d<=200; d++) {
					int a = cube(b)+cube(c)+cube(d);
					if(a>cap) break;
					int cbrt = (int) Math.cbrt(a);
					if(cube(cbrt)==a) t.add(new Triple(cbrt, b, c, d));
				}
		
		Collections.sort(t);
		for(Triple cur : t) sb.append(cur);
		System.out.print(sb);
	}
	
	static int cube(int x) {
		return x*x*x;
	}
	
	static class Triple implements Comparable<Triple> {
		int a, b, c, d;
		
		Triple(int w, int x, int y, int z){
			a = w;
			b = x;
			c = y;
			d = z;
		}

		@Override
		public int compareTo(Triple o) {
			if(a==o.a) return b-o.b;
			return a-o.a;
		}
		
		public String toString() {
			return String.format("Cube = %d, Triple = (%d,%d,%d)\n", a, b, c, d);
		}
	}
}
