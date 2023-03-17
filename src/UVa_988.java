import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class UVa_988 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		do {
			int n = sc.nextInt();
			ArrayList<Integer>[] e = new ArrayList[n];
			int[] inD = new int[n];
			int[] outD = new int[n];
			for(int i=0; i<n; i++){
				outD[i] = sc.nextInt();
				e[i] = new ArrayList<>();
				for(int j=0; j<outD[i]; j++) {
					int x = sc.nextInt();
					e[i].add(x);
					inD[x]++;
				}
			}
			LinkedList<Integer> q = new LinkedList<>();
			ArrayList<Integer> ts = new ArrayList<>();
			q.add(0);
			while(!q.isEmpty()){
				int cur = q.poll();
				ts.add(cur);
				for(int next: e[cur]){
					inD[next]--;
					if(inD[next]==0) q.add(next);
				}
			}
			int[] paths = new int[n];
			paths[0] = 1;
			for(int i=0; i<ts.size(); i++)
				for(int next: e[ts.get(i)]) paths[next]+=paths[ts.get(i)];
			int total = 0;
			for(int i=0; i<n; i++) if(outD[i]==0) total+=paths[i];
			System.out.println(total);
			if(sc.hasNext()) System.out.println();
		} while(sc.hasNext());
	}
}
