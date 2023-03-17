import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;


public class UVa_551 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Character> pair = new HashMap<>();
		pair.put(')', '(');
		pair.put(']', '[');
		pair.put('}', '{');
		pair.put('>', '<');
		pair.put('9', '6');
		while(true){
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			s+="a";
			boolean yes = true;
			int failIdx = -1, lastFullResolve = 0, idx = 1; // lastFullResolve issa scam
			char[] terms = s.toCharArray();
			Stack<Character> stack = new Stack<>();
			for(int i=0; yes && i<terms.length; i++){
				char cur = terms[i];
				if(cur=='('){
					if(terms[i+1]=='*'){
						i++;
						stack.push('6');
					} else stack.push('(');
				} else if(cur=='[' || cur=='{' || cur=='<') {
					stack.push(cur);
				} else if(cur=='*'){
					if(terms[i+1]==')'){
						i++;
						if(!stack.isEmpty() && stack.peek()=='6') stack.pop();
						else {
							yes = false;
							failIdx = idx;
						}
					}
				} else if(cur==']' || cur=='}' || cur==')' || cur=='>'){
					if(!stack.isEmpty() && stack.peek()==pair.get(cur)) stack.pop();
					else {
						yes = false;
						failIdx = idx;
					}
				}
				if(stack.isEmpty()) lastFullResolve = idx;
				idx++;
			}
			if(yes) {
				if(stack.isEmpty()) System.out.println("YES");
				else System.out.println("NO "+(idx-1));
			} else System.out.println("NO "+failIdx);
		}
	}
}
