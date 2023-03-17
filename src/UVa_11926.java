import java.util.BitSet;
import java.util.Scanner;

public class UVa_11926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			BitSet bs = new BitSet();
			if(n==0 && m==0) break;
			boolean conflict = false;
			while(n-->0) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				if(conflict) continue;
				int tempStart = start;
				while(tempStart<end) {
					if(bs.get(tempStart)) conflict = true;
					bs.set(tempStart++);
				}
			}
			while(m-->0) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int rep = sc.nextInt();
				if(conflict) continue;
				do {
					int tempStart = start;
					while(tempStart<end) {
						if(bs.get(tempStart)) conflict = true;
						bs.set(tempStart++);
					}
					start+=rep;
					end+=rep;
					if(end>1000000) end = 1000000;
				} while(start<=1000000);
			}
			System.out.println(conflict ? "CONFLICT" : "NO CONFLICT");
		}
	}
}
