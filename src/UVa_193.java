import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class UVa_193 {
	static boolean[] black;
	static ArrayList<Integer>[] e;
	static int n, best;
	static String config;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			String[] split = br.readLine().split(" ");
			n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			e = new ArrayList[n];
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			while(m-->0){
				split = br.readLine().split(" ");
				int a = Integer.parseInt(split[0])-1;
				int b = Integer.parseInt(split[1])-1;
				e[a].add(b);
				e[b].add(a);
			}
			best = -1;
			config = "";
			black = new boolean[n];
			System.out.println(backtrack(0, 0));
			System.out.println(config);
		}
	}
	
	static int backtrack(int index, int curScore){
		if(index==n) {
			if(curScore>best){
				best = curScore;
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<n; i++) if(black[i]) sb.append(i+1).append(" ");
				config = sb.toString().trim();
			}
			return curScore;
		}
		boolean isBlack = true;
		int ans = backtrack(index+1, curScore);
		for(int next : e[index]) isBlack &= !black[next];
		if(isBlack){
			black[index] = true;
			ans = Math.max(ans, backtrack(index+1, curScore+1));
			black[index]= false;
		}
		return ans;
	}
}
