import java.util.ArrayList;
import java.util.Scanner;

public class UVa_12376 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] vals = new int[n];
			ArrayList<Integer>[] e = new ArrayList[n];
			for(int i=0; i<n; i++){
				vals[i] = sc.nextInt();
				e[i] = new ArrayList<>();
			}
			while(m-->0){
				e[sc.nextInt()].add(sc.nextInt());
			}
			int cur = 0;
			int total = 0;
			while(true){
				int choose = -1;
				int v = -1;
				for(int next: e[cur])
					if(vals[next]>v){
						v = vals[next];
						choose = next;
					}
				if(choose==-1) break;
				total+=v;
				cur = choose;
			}
			System.out.println("Case "+t+": "+total+" "+cur);
		}
	}
}
