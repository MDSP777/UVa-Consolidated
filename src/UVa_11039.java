import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class UVa_11039 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			int n = Integer.parseInt(br.readLine());
			LinkedList<Integer> a = new LinkedList<>();
			LinkedList<Integer> b = new LinkedList<>();
			while(n-->0) {
				int cur = Integer.parseInt(br.readLine());
				if(cur>0) a.add(cur);
				else b.add(-cur);
			}
			Collections.sort(a, Collections.reverseOrder());
			Collections.sort(b, Collections.reverseOrder());
			int total = 0;
			int cur = 0;
			boolean pos = true;
			if(!a.isEmpty() && !b.isEmpty() && a.peek()>b.peek()) {
				cur = a.poll();
				total++;
			} else if(!b.isEmpty()){
				cur = b.poll();
				pos = false;
				total++;
			}
			while(true) {
				if(pos) {
					while(!b.isEmpty() && b.peek()>=cur) b.poll();
					if(b.isEmpty()) break;
					cur = b.poll();
				} else {
					while(!a.isEmpty() && a.peek()>=cur) a.poll();
					if(a.isEmpty()) break;
					cur = a.poll();
				}
				pos = !pos;
				total++;
			}
			System.out.println(total);
		}
	}
}
