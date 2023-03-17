import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVa_1261 {
	static HashMap<String, Boolean> memo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		memo = new HashMap<>();
		while(tc-->0){
			String s = br.readLine();
			System.out.println(dp(s) ? 1 : 0);
		}
	}
	
	static boolean dp(String s){
		if(memo.containsKey(s)) return memo.get(s);
		if(s.length()==1) return false;
		if(allSame(s)) return true;
		boolean can = false;
		int start = 0;
		while(!can && start<s.length()){
			int end = start;
			while(end<s.length() && s.charAt(end)==s.charAt(start)) end++;
			if(end>start+1){
				can|=dp(s.substring(0, start)+s.substring(end));
			}
			start = end;
		}
		memo.put(s, can);
		return can;
	}
	
	static boolean allSame(String s){
		for(int i=1; i<s.length(); i++)
			if(s.charAt(i)!=s.charAt(0)) return false;
		return true;
	}
}
