import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_202 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int a = sc.nextInt();
			int b = sc.nextInt();
			StringBuilder sb = new StringBuilder().append(a).append("/").append(b).append(" = ").append(a/b).append(".");
			HashMap<Integer, Integer> rep = new HashMap<>();
			ArrayList<Integer> l = new ArrayList<>();
			int ctr = 0;
			a%=b;
			while(true) {
				if(rep.containsKey(a)) {
					int s = rep.get(a);
					for(int i=0; i<s; i++) sb.append(l.get(i));
					sb.append("(");
					for(int i=s; i<ctr; i++) {
						if(i==50) {
							sb.append("...");
							break;
						}
						sb.append(l.get(i));
					}
					sb.append(")\n   ").append(ctr-s).append(" = number of digits in repeating cycle\n\n");
					break;
				}
				rep.put(a, ctr++);
				a*=10;
				l.add((a/b)%10);
				a%=b;
			}
			System.out.print(sb);
		} while(sc.hasNext());
	}
}
