import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class UVa_540 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			LinkedList<Integer>[] teams = new LinkedList[n];
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i=0; i<n; i++) {
				teams[i] = new LinkedList<>();
				String[] split = br.readLine().split("\\s+");
				for(int j=1; j<split.length; j++) map.put(Integer.parseInt(split[j]), i);
			}
			LinkedList<Integer> tq = new LinkedList<>();
			System.out.println("Scenario #"+x++);
			while(true) {
				String s = br.readLine();
				if(s.equals("STOP")) break;
				if(s.startsWith("ENQ")) {
					int elem = Integer.parseInt(s.split("\\s+")[1]);
					if(teams[map.get(elem)].isEmpty()) tq.add(map.get(elem));
					teams[map.get(elem)].add(elem);
				} else {
					System.out.println(teams[tq.peek()].poll());
					if(teams[tq.peek()].isEmpty()) tq.poll();
				}
			}
			System.out.println();
		}
	}
}
