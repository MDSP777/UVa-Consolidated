import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_628 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			int n = Integer.parseInt(s);
			String[] terms = new String[n];
			for(int i=0; i<n; i++) terms[i] = br.readLine();
			int m = Integer.parseInt(br.readLine());
			Rule[] rules = new Rule[m];
			for(int i=0; i<m; i++) rules[i] = new Rule(br.readLine());
			sb.append("--\n");
			for(String st : terms)
				for(Rule r : rules) {
					dfs(st, r, 0, new int[r.nZero], sb);
				}
		}
		System.out.print(sb);
	}
	
	static void dfs(String term, Rule rule, int i, int[] zVals, StringBuilder sb) {
		if(i==rule.nZero) {
			sb.append(convert(term, rule, zVals)).append("\n");
			return;
		}
		for(int v=0; v<10; v++) {
			zVals[i] = v;
			dfs(term, rule, i+1, zVals, sb);
			zVals[i] = -1;
		}
	}
	
	static String convert(String term, Rule rule, int[] zVals) {
		StringBuilder sb = new StringBuilder();
		int zIdx = 0;
		for(int i=0; i<rule.exp.length(); i++) {
			if(rule.exp.charAt(i)=='#') sb.append(term);
			else sb.append(zVals[zIdx++]);
		}
		return sb.toString();
	}
	
	static class Rule {
		String exp;
		int nZero;
		
		Rule(String e){
			exp = e;
			nZero = 0;
			for(int i=0; i<exp.length(); i++)
				if(exp.charAt(i)=='0') nZero++;
		}
	}
}
