import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UVa_292 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			String[] split = br.readLine().split("\\s+");
			int l1 = Integer.parseInt(split[0]);
			int l2 = Integer.parseInt(split[1]);
			StringBuilder sb1 = new StringBuilder();
			while(l1-->0) sb1.append(br.readLine().replaceFirst("\\s++$", "")).append("\n");
			StringBuilder sb2 = new StringBuilder();
			while(l2-->0) sb2.append(br.readLine().replaceFirst("\\s++$", "")).append("\n");
			String jOut = sb1.toString().replaceFirst("\\n++$", "");
			String sOut = sb2.toString().replaceFirst("\\n++$", "");
			String forComparison = jOut.replaceAll("[\\[\\]]", "");
			if(sOut.equals(forComparison)) sb.append("Accepted\n");
			else {
				jOut = jOut.toUpperCase();
				sOut = sOut.toUpperCase();
				Pattern p = Pattern.compile("\\[(.*?)\\]");
				Matcher m = p.matcher(jOut);
				ArrayList<String> essentials = new ArrayList<>();
				while(m.find()) essentials.add(m.group(1));
				int start = 0;
				boolean success = true;
				for(int i=0; i<essentials.size(); i++) {
					int loc = sOut.indexOf(essentials.get(i), start);
					if(loc==-1) {
						success = false;
						break;
					}
					start = loc+essentials.get(i).length();
				}
				sb.append(success ? "Presentation Error\n" : "Wrong Answer\n");
			}
		}
		System.out.print(sb);
	}
}
