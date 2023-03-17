import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_537 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			String[] split = br.readLine().split("=");
			String p = null, i = null, u = null;
			for(int x=1; x<split.length; x++) {
				StringBuilder sb = new StringBuilder();
				String cur = split[x];
				int idx = 0;
				while(cur.charAt(idx)!='A' && cur.charAt(idx)!='W' && cur.charAt(idx)!='V') {
					sb.append(cur.charAt(idx++));
				}
				sb.append(cur.charAt(idx));
				char var = split[x-1].charAt(split[x-1].length()-1);
				if(var=='P') p = sb.toString();
				else if(var=='I') i = sb.toString();
				else if(var=='U') u = sb.toString();
			}
			
			
			double ans = 1;
			String left = null, right = null;
			if(p==null) {
				double iScale = 1, iVal = 1, uScale = 1, uVal = 1;
				
				iScale = findScale(i);
				iVal = findVal(i);

				uScale = findScale(u);
				uVal = findVal(u);
				
				ans = uVal*uScale*iVal*iScale;
				left = "P";
				right = "W";
			} else if(i==null) {
				double pScale = 1, pVal = 1, uScale = 1, uVal = 1;

				pScale = findScale(p);
				pVal = findVal(p);

				uScale = findScale(u);
				uVal = findVal(u);
				
				ans = (pVal*pScale) / (uVal*uScale);
				left = "I";
				right = "A";
			} else {
				double pScale = 1, pVal = 1, iScale = 1, iVal = 1;
				
				iScale = findScale(i);
				iVal = findVal(i);

				pScale = findScale(p);
				pVal = findVal(p);
				
				ans = (pVal*pScale) / (iVal*iScale);
				left = "U";
				right = "V";
				
			}
			
			System.out.println("Problem #"+t);
			System.out.printf("%s=%.2f%s\n\n",left, ans, right);
		}
	}
	
	static double findScale(String s) {
		if(s.contains("m")) return (double) 0.001;
		if(s.contains("k")) return 1000;
		if(s.contains("M")) return 1000000;
		return 1;
	}
	
	static double findVal(String s) {
		int x = s.length()-1;
		
		while(!(s.charAt(x)>='0' && s.charAt(x)<='9')) {
			x--;
		}
		return Double.parseDouble(s.substring(0, x+1));
	}
}
