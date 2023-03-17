import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class UVa_10029 {
	static ArrayList<String> arr;
	static HashMap<String, Integer> memo;
	static HashSet<String> set;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new ArrayList<>();
		memo = new HashMap<>();
		set = new HashSet<>();
		while(true){
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			set.add(s);
			arr.add(s);
		}
		Collections.sort(arr);
		int ans = 0;
		for(int i=0; i<arr.size(); i++) ans = Math.max(ans, dp(arr.get(i)));
		System.out.println(ans+1);
	}
	
	static int dp(String s){
		if(memo.containsKey(s)) return memo.get(s);
		int ans = 0;
		for(int i=0; i<s.length(); i++){
			for(char j='a'; j<='z'; j++){
				String st = s.substring(0, i)+j+s.substring(i+1);
				if(set.contains(st) && st.compareTo(s)>0) ans = Math.max(ans, 1+dp(st));
				st = s.substring(0, i)+j+s.substring(i);
				if(set.contains(st) && st.compareTo(s)>0) ans = Math.max(ans, 1+dp(st));
			}
			String st = s.substring(0, i)+s.substring(i+1);
			if(set.contains(st) && st.compareTo(s)>0) ans = Math.max(ans, 1+dp(st));
		}
		for(char j='a'; j<='z'; j++){
			String st = s+j;
			if(set.contains(st) && st.compareTo(s)>0) ans = Math.max(ans, 1+dp(st));
		}
		memo.put(s, ans);
		return ans;
	}
}
