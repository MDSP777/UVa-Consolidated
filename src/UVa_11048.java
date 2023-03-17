import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class UVa_11048 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		ArrayList<String> arr = new ArrayList<>();
		while(n-->0) {
			String s = br.readLine();
			arr.add(s);
			set.add(s);
		}
		int q = Integer.parseInt(br.readLine());
		while(q-->0){
			String s = br.readLine();
			if(set.contains(s)) sb.append(s).append(" is correct\n");
			else{
				boolean found = false;
				for(String cur: arr)
					if(Math.abs(cur.length()-s.length())<=1 && misspell(cur, s)){
						sb.append(s).append(" is a misspelling of ").append(cur).append("\n");
						found = true;
						break;
					}	
				if(!found) sb.append(s).append(" is unknown\n");
			}
		}
		System.out.print(sb);
	}
	
	static boolean misspell(String orig, String mod){
		for(int i=0; i<orig.length(); i++)
			if(mod.equals(orig.substring(0, i)+orig.substring(i+1)) || mod.equals(orig.substring(0, i+1)+orig.charAt(i)+orig.substring(i+1))) return true;
		for(int i=0; i<mod.length(); i++)
			if(orig.equals(mod.substring(0, i)+mod.substring(i+1)) || orig.equals(mod.substring(0, i+1)+mod.charAt(i)+mod.substring(i+1))) return true;
		if(orig.length()==mod.length()){
			int same = 0;
			for(int i=0; i<orig.length(); i++) if(orig.charAt(i)==mod.charAt(i)) same++;
			if(same==orig.length()-1) return true;
			if(same==orig.length()-2)
				for(int i=0; i<orig.length(); i++)
					if(orig.charAt(i)!=mod.charAt(i)){
						if(orig.charAt(i+1)==mod.charAt(i) && orig.charAt(i)==mod.charAt(i+1)) return true;
						break;
					}
		}
		return false;
	}
}
