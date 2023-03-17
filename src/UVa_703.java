import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_703 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s==null) break;
			int n = Integer.parseInt(s);
			int[][] grid = new int[n][n];
			for(int i=0; i<n; i++){
				String[] split = br.readLine().split(" ");
				for(int j=0; j<n; j++) grid[i][j] = Integer.parseInt(split[j]);
			}
			ArrayList<Triple> ans = new ArrayList<>();
			for(int i=0; i<n; i++)
				for(int j=i+1; j<n; j++)
					for(int k=j+1; k<n; k++){
						if(grid[i][j]==0 && grid[j][i]==0 && grid[i][k]==0 && grid[k][i]==0 && grid[j][k]==0 && grid[k][j]==0){
							ArrayList<Integer> a = new ArrayList<>();
							a.add(i+1);
							a.add(j+1);
							a.add(k+1);
							Collections.sort(a);
							ans.add(new Triple(a.get(0), a.get(1), a.get(2)));
						} else if(grid[i][j]==1 && grid[j][k]==1 && grid[k][i]==1){
							ArrayList<Integer> a = new ArrayList<>();
							a.add(i+1);
							a.add(j+1);
							a.add(k+1);
							while(!isSorted(a)){
								a.add(a.get(0));
								a.remove(0);
							}
							ans.add(new Triple(a.get(0), a.get(1), a.get(2)));
						} else if(grid[i][k]==1 && grid[k][j]==1 && grid[j][i]==1){
							ArrayList<Integer> a = new ArrayList<>();
							a.add(i+1);
							a.add(k+1);
							a.add(j+1);
							while(!isSorted(a)){
								a.add(a.get(0));
								a.remove(0);
							}
							ans.add(new Triple(a.get(0), a.get(1), a.get(2)));
						}
					}
			Collections.sort(ans);
			System.out.println(ans.size());
			for(Triple cur : ans) System.out.println(cur.a+" "+cur.b+" "+cur.c);
		}
	}
	
	static class Triple implements Comparable<Triple> {
		int a;
		int b;
		int c;
		
		Triple(int x, int y, int z){
			a = x;
			b = y;
			c = z;
		}

		@Override
		public int compareTo(Triple o) {
			if(a==o.a) {
				if(b==o.b) return c-o.c;
				return b-o.b;
			}
			return a-o.a;
		}
	}

	private static boolean isSorted(ArrayList<Integer> a) {
		return a.get(0)<a.get(1) && a.get(1)<a.get(2) || a.get(0)>a.get(1) && a.get(1)>a.get(2);
	}
}
