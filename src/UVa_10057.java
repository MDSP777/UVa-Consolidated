import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_10057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int n = sc.nextInt();
			HashMap<Integer, Integer> map = new HashMap<>();
			ArrayList<Integer> l = new ArrayList<>();
			for(int i=0; i<n; i++) {
				int cur = sc.nextInt();
				l.add(cur);
				map.put(cur, map.containsKey(cur) ? map.get(cur)+1 : 1);
			}
			Collections.sort(l);
			if(n%2==1) System.out.println(l.get(n/2)+" "+map.get(l.get(n/2))+" 1");
			else {
				int a = l.get(n/2-1);
				int b = l.get(n/2);
				if(a==b) System.out.println(a+" "+map.get(a)+" 1");
				else System.out.println(a+" "+(map.get(a)+map.get(b))+" "+(b-a+1));
			}
		} while(sc.hasNext());
	}
}
