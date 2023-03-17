import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class UVa_12504 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			String[] split1 = br.readLine().replaceAll("[{}]", "").split(",");
			String[] split2 = br.readLine().replaceAll("[{}]", "").split(",");
			TreeMap<String, String> map1 = new TreeMap<>();
			TreeMap<String, String> map2 = new TreeMap<>();
			for(int i=0; i<split1.length; i++) {
				if(split1[i].contains(":")) {
					String[] split = split1[i].split(":");
					map1.put(split[0], split[1]);
				}
			}
			for(int i=0; i<split2.length; i++) {
				if(split2[i].contains(":")) {
					String[] split = split2[i].split(":");
					map2.put(split[0], split[1]);
				}
			}
			ArrayList<String> add = new ArrayList<>();
			ArrayList<String> mod = new ArrayList<>();
			ArrayList<String> del = new ArrayList<>();
			for(String s: map1.keySet()) {
				if(!map2.containsKey(s)) del.add(s);
				else if(!map1.get(s).equals(map2.get(s))) mod.add(s);
			}
			for(String s: map2.keySet()) {
				if(!map1.containsKey(s)) add.add(s);
			}
			StringBuilder sb = new StringBuilder();
			if(add.size()==0 && mod.size()==0 && del.size()==0) sb.append("No changes\n");
			else {
				if(add.size()>0) {
					sb.append("+");
					for(String s: add) sb.append(s).append(",");
					sb.setLength(sb.length()-1);
					sb.append("\n");
				}
				if(del.size()>0) {
					sb.append("-");
					for(String s: del) sb.append(s).append(",");
					sb.setLength(sb.length()-1);
					sb.append("\n");
				}
				if(mod.size()>0) {
					sb.append("*");
					for(String s: mod) sb.append(s).append(",");
					sb.setLength(sb.length()-1);
					sb.append("\n");
				}
			}
			System.out.println(sb);
		}
	}
}
