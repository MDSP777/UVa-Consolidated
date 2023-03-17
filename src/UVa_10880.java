import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10880 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int nC = sc.nextInt();
		for(int x=1; x<=nC; x++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			sb.append("Case #").append(x).append(":");
			if(c==r) sb.append(" 0\n");
			else {
				int diff = c-r;
				ArrayList<Integer> l = new ArrayList<>();
				for(int i=1; i<=Math.sqrt(diff); i++)
					if(diff%i==0) {
						if(i>r) l.add(i);
						if(diff/i>r && diff/i!=i) l.add(diff/i);
					}
				Collections.sort(l);
				for(int i: l) sb.append(" ").append(i);
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
