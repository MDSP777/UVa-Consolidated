import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class UVa_10887 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++){
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			
			ArrayList<String> aTerms = new ArrayList<>();
//			HashMap<String, HashSet<String>> aMap = new HashMap<>();
//			HashMap<String, HashSet<String>> backMap = new HashMap<>();
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				aTerms.add(str);
//				aMap.put(str, new HashSet<String>());
//				if(!str.equals("")) aMap.get(str).add("");
			}
//			Collections.sort(aTerms);
////			aMap.put("", new HashSet<String>());
//			for(String str : aTerms){
//				String s = "";
//				if(!str.equals("") && aMap.containsKey("")) aMap.get(s).add(str);
//				for(int i=0; i<str.length()-1; i++){
//					s+=str.charAt(i);
//					if(aMap.containsKey(s))
//						aMap.get(s).add(str.substring(i+1));
//				}
//			}
//			
//			ArrayList<String> bTerms = new ArrayList<>();
			HashSet<String> terms = new HashSet<>();
//			HashMap<String, HashSet<String>> bMap = new HashMap<>();
			for(int i=0; i<m; i++) {
				String str = br.readLine();
				for(String s : aTerms)
					terms.add(s+str);
//				bTerms.add(str);
//				bMap.put(str, new HashSet<String>());
//				if(!str.equals("")) bMap.get(str).add("");
			}
//			if(aMap.size()!=n || bMap.size()!=m) throw new Exception("BAD TC "+t);
//			Collections.sort(bTerms);
////			bMap.put("", new HashSet<String>());
//			for(String str : bTerms){
//				String s = "";
//				if(!str.equals("") && bMap.containsKey("")) bMap.get(s).add(str);
//				for(int i=str.length()-1; i>=1; i--){
//					s = str.charAt(i)+s; 
//					if(bMap.containsKey(s))
//						bMap.get(s).add(str.substring(0,i));
//				}
//			}
//			
//			for(String key : aMap.keySet()){
//				HashSet<String> set = aMap.get(key);
//				for(String x : set){
//					if(!x.equals("")){
//						if(!backMap.containsKey(x)) backMap.put(x, new HashSet<String>());
//						backMap.get(x).add(key);
//					}
//				}
//			}
//			
//			for(String key : aMap.keySet()){
//				System.out.println(key+" "+aMap.get(key)+" "+aMap.get(key).size());
//			}
//			System.out.println();
//			
//			for(String key : bMap.keySet()){
//				System.out.println(key+" "+bMap.get(key));
//			}
//			System.out.println();
//			
//			for(String key : backMap.keySet()){
//				System.out.println(key+" "+backMap.get(key));
//			}
////			
//			int total = m*n;
//			for(String key : bMap.keySet()){
//				HashSet<String> set = bMap.get(key);
//				for(String x : set){
//					if(backMap.containsKey(x)) total-=backMap.get(x).size();
//				}
//			}
//			if(aMap.containsKey("") && bMap.containsKey("")) {
//				System.out.println("FUCK "+total);
//				Set<String> k = aMap.keySet();
//				k.retainAll(bMap.keySet());
//				System.out.println(k);
//				total-=k.size()-1;
//			}
			System.out.println("Case "+t+": "+terms.size());
		}
	}
}
