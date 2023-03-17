import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_1244 {
	static int n;
	static char[][] adj;
	static String[][] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			n = Integer.parseInt(br.readLine());
			adj = new char[n][n];
			memo = new String[n][n];
			for(int i=0; i<n; i++){
				char[] cur = br.readLine().toCharArray();
				for(int j=0; j<n; j++) {
					adj[i][j] = cur[j];
					memo[i][j] = "FAIL";
				}
			}
			String ans = dp(0, n-1);
			if(ans.equals("FAIL")) System.out.println("NO PALINDROMIC PATH");
			else System.out.println(ans);
		}
	}
	
	static String dp(int start, int end){
		if(start==end) return "";
		if(start>end) return "FAIL";
		if(!memo[start][end].equals("FAIL")) return memo[start][end];
		String ans = adj[start][end]+"";
		for(int i=start+1; i<n; i++){
			for(int j=end-1; j>=0; j--)
				if(adj[start][i]==adj[j][end]){
					String t = dp(i, j);
					if(!t.equals("FAIL")){
						String newAns = adj[start][i]+t+adj[j][end];
						if(newAns.length()>ans.length() || (newAns.length()==ans.length() && newAns.compareTo(ans)<0)){
							ans = newAns;
						}
					}
				}
		}
		memo[start][end] = ans;
		return ans;
	}
}
