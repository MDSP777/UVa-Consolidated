import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class UVa_10172 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			String[] split = br.readLine().split("\\s+");
			int n = Integer.parseInt(split[0]);
			int capactiy = Integer.parseInt(split[1]);
			int qSize = Integer.parseInt(split[2]);
			long total = 0;
			LinkedList<Integer>[] stations = new LinkedList[n];
			for(int i=0; i<n; i++) {
				stations[i] = new LinkedList<>();
				split = br.readLine().split("\\s+");
				for(int j=1; j<split.length; j++) {
					stations[i].add(Integer.parseInt(split[j])-1);
					total++;
				}
			}
			int cur = 0;
			long time = -2;
			Stack<Integer> carrier = new Stack<>();
			while(total>0) {
				time+=2;
				while(!carrier.isEmpty()) {
					if(carrier.peek()==cur) {
						carrier.pop();
						total--;
					} else {
						if(stations[cur].size()==qSize) break;
						stations[cur].add(carrier.pop());
					}
					time++;
				}
				while(!stations[cur].isEmpty() && carrier.size()<capactiy) {
					carrier.push(stations[cur].poll());
					time++;
				}
				cur = (cur+1)%n;
			}
			sb.append(time).append("\n");
		}
		System.out.print(sb);
	}
}
