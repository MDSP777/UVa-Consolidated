import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class UVa_529 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer>[] best = new ArrayList[10001];
		int[] totals = new int[10001];
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		best[1] = a;
		
		LinkedList<ArrayList<Integer>> q = new LinkedList<>();
		q.add(a);
		int solved = 1;
		while(!q.isEmpty() && solved<10000){
			ArrayList<Integer> cur = q.poll();
			int last = cur.get(cur.size()-1);
			for(int i=0; i<cur.size(); i++){
				int next = last+cur.get(i);
				if(next>10000) continue;
				if(best[next]==null){
					ArrayList<Integer> newArr = new ArrayList<>(cur);
					newArr.add(next);
					best[next] = newArr;
					q.add(newArr);
					solved++;
					totals[next]++;
				} else if(best[next].size()==cur.size()+1 && totals[next]<100){
					ArrayList<Integer> newArr = new ArrayList<>(cur);
					newArr.add(next);
					q.add(newArr);
					totals[next]++;
				}
			}
		}
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			ArrayList<Integer> ans = best[n];
			
			System.out.print(ans.get(0));
			for(int i=1; i<ans.size(); i++)
				System.out.print(" "+ans.get(i));
			System.out.println();
		}
	}
	
	static class State {
		ArrayList<Integer> s;
		int depth;
		
		State(ArrayList<Integer> a, int b){
			s = a;
			depth = b;
		}
	}
}
