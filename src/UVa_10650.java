import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class UVa_10650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] sieve = new boolean[32100];
		ArrayList<Integer> p = new ArrayList<>();
		for(int i=2; i<32100; i++)
			if(!sieve[i]){
				p.add(i);
				for(int j=i+i; j<32100; j+=i) sieve[j] = true;
			}
		TreeMap<Integer, String> dp = new TreeMap<>();
		TreeMap<Integer, Integer> ends = new TreeMap<>();
		int idx = 0;
		while(idx<p.size()){
			if(idx+2<p.size() && p.get(idx+1)-p.get(idx)==p.get(idx+2)-p.get(idx+1)){
				int cur = p.get(idx);
				StringBuilder sb = new StringBuilder(p.get(idx)+" "+p.get(idx+1)+" "+p.get(idx+2));
				int diff = p.get(idx+1)-p.get(idx);
				idx+=2;
				int end = p.get(idx);
				while(idx+1<p.size()){
					if(p.get(idx+1)-p.get(idx)==diff){
						sb.append(" ").append(p.get(idx+1));
						end = p.get(idx+1);
					}
					else {
						idx--;
						break;
					}
					idx++;
				}
				dp.put(cur, sb.toString());
				ends.put(cur, end);
			}
			idx++;
		}
		
		while(true){
			int u = sc.nextInt();
			int v = sc.nextInt();
			int a = Math.min(u, v);
			int b = Math.max(u, v);
			if(a==0 && b==0) break;
			
			int x = dp.ceilingKey(a);
			while(x<=b && ends.get(x)<=b){
				System.out.println(dp.get(x));
				if(dp.higherKey(x)==null) break;
				x = dp.higherKey(x);
				if(x>b) break;
 			}
		}
	}
}
