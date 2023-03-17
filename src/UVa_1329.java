import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_1329 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(tc-->0){
			int n = Integer.parseInt(br.readLine());
			UFDS u = new UFDS(n+1);
			while(true){
				String s = br.readLine();
				if(s.equals("O")) break;
				String[] split = s.split(" ");
				
				if(split[0].equals("E")){
					int x = Integer.parseInt(split[1]);
					u.findSet(x);
					sb.append(u.pathLength[x]).append("\n");
				} else {
					u.join(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
				}
			}
		}
		System.out.print(sb);
	}
	
	static class UFDS {
		int[] p;
		int[] pathLength;
		
		UFDS(int n){
			p = new int[n];
			pathLength = new int[n];
			for(int i=0; i<n; i++)
				p[i]  = i;
		}
		
		int findSet(int i){
			if(p[i]==i) return i;
			else {
				int newP = findSet(p[i]);
				pathLength[i] += pathLength[p[i]];
				p[i] = newP;
				return p[i];
			}
		}
		
		boolean isSameSet(int i, int j){
			return findSet(i)==findSet(j);
		}
		
		void join(int i, int j){
			int x = findSet(i);
			
			p[x] = j;
			int dist = Math.abs(i-j)%1000;
			pathLength[x]+=dist;
		}
	}
}
