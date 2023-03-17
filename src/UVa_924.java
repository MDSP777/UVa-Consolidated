import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class UVa_924 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nEmps = Integer.parseInt(br.readLine());
		Employee[] emps = new Employee[nEmps];
		for(int i=0; i<nEmps; i++) {
			Employee e = new Employee(i);
			String[] split = br.readLine().split(" ");
			if(Integer.parseInt(split[0])>0) for(int j=1; j<split.length; j++) e.friends.add(Integer.parseInt(split[j]));
			emps[i] = e;
		}
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			LinkedList<Employee> q = new LinkedList<>();
			int src = Integer.parseInt(br.readLine());
			boolean[] visited = new boolean[nEmps];
			visited[src] = true;
			for(int i=0; i<nEmps; i++) emps[i].depth = -1;
			emps[src].depth = 0;
			q.add(emps[src]);
			int maxBoom = 0;
			int boomDay = -1;
			int curBoom = 0;
			int curDay = 1;	
			while(!q.isEmpty()) {
				Employee cur = q.poll();
				if(cur.depth==curDay) {
					if(curBoom>maxBoom) {
						maxBoom = curBoom;
						boomDay = curDay;
					}
					curBoom = 0;
					curDay++;
				}
				for(int i=0; i<cur.friends.size(); i++) {
					if(!visited[cur.friends.get(i)]) {
						Employee toAdd = emps[cur.friends.get(i)];
						toAdd.depth = cur.depth+1;
						q.add(toAdd);
						visited[toAdd.id] = true;
						curBoom++;
					}
				}
			}
			sb.append(maxBoom).append(maxBoom==0 ? "" : " "+boomDay).append("\n");
		}
		System.out.print(sb);
	}
	
	static class Employee {
		int id;
		ArrayList<Integer> friends;
		int depth;
		
		public Employee(int id) {
			this.id = id;
			this.friends = new ArrayList<>();
			this.depth = -1;
		}
	}
}
