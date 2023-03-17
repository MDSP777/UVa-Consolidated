import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class UVa_10393 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] fingers = new String[10];
		fingers[0] = "qaz";
		fingers[1] = "wsx";
		fingers[2] = "edc";
		fingers[3] = "rfvtgb";
		fingers[4] = "";
		fingers[5] = "";
		fingers[6] = "yhnujm";
		fingers[7] = "ik";
		fingers[8] = "ol";
		fingers[9] = "p";
		int[] map = new int[26];
		for(int i=0; i<10; i++)
			for(int j=0; j<fingers[i].length(); j++) map[fingers[i].charAt(j)-'a'] = i;
		do{
			int n = sc.nextInt();
			int w = sc.nextInt();
			boolean[] broken = new boolean[10];
			while(n-->0) broken[sc.nextInt()-1] = true;
			HashSet<String> ans = new HashSet<>();
			int best = -1;
			while(w-->0){
				String s = sc.next();
				boolean canType = true;
				for(int i=0; canType && i<s.length(); i++) if(broken[map[s.charAt(i)-'a']]) canType = false;
				if(canType){
					if(s.length()>best){
						best = s.length();
						ans = new HashSet<>();
						ans.add(s);
					} else if(s.length()==best) ans.add(s);
				}
			}
			System.out.println(ans.size());
			ArrayList<String> a = new ArrayList<>(ans);
			Collections.sort(a);
			for(String s : a) System.out.println(s);
		}while(sc.hasNext());
	}
}
