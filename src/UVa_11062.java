import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class UVa_11062 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] prev = null;
		TreeSet<String> hs = new TreeSet<>();
		while(true) {
			String s = br.readLine();
			if(s==null || s.equals("DONE")) break;
			if(!s.isEmpty()) {
				String[] split = s.split("[^A-Za-z-]");
				if(prev!=null && prev.length>0 && prev[prev.length-1].endsWith("-")) split[0] = prev[prev.length-1].replaceAll("-", "")+split[0];
				for(int i=0; i<split.length; i++) if(!split[i].isEmpty() && !(i==split.length-1 && split[i].endsWith("-"))) hs.add(split[i].replaceAll("[^A-Za-z-]", "").toLowerCase());
				prev = split;
			}
		}
		for(String s: hs) System.out.println(s);
	}
}
