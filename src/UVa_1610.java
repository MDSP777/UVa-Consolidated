import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVa_1610 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			ArrayList<String> arr = new ArrayList<>();
			for(int i=0; i<n; i++) arr.add(br.readLine());
			Collections.sort(arr);
			
			StringBuilder sb = new StringBuilder();
			String a = arr.get(n/2-1);
			String b = arr.get(n/2);
			int x = Math.min(a.length(), b.length());
			
			boolean matched = false;
			for(int i=0; i<x; i++) {
				char l = a.charAt(i);
				char r = b.charAt(i);
				
				if(r-l>1 && i<a.length()-1) {
					sb.append((char)(l+1));
					matched = true;
					break;
				}
				if(r-l==1 && i<x-1) {
					sb.append(r);
					matched = true;
					break;
				}
				sb.append(l);
			}
			
			if(!matched)
				for(int i=x; i<a.length(); i++) 
					if(i<a.length()-1 && a.charAt(i)!='Z') {
						sb.append((char)(a.charAt(i)+1));
						break;
					} else sb.append(a.charAt(i));
			
			System.out.println(sb);
		}
	}
}
