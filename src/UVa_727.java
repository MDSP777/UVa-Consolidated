import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class UVa_727 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		br.readLine();
		boolean done = false;
		while(!done){
			StringBuilder sb = new StringBuilder();
			Stack<String> st = new Stack<>();
			while(true){
				String s = br.readLine();
				if(s==null || s.isEmpty()){
					if(s==null) done = true;
					break;
				}
				if(!s.matches("[()+\\-\\*/]")) sb.append(s);
				else if(s.matches("[+\\-\\*/]")){
					if(st.isEmpty() || st.peek().equals("(") || s.matches("[\\*/]") && st.peek().matches("[+\\-]")) st.push(s);
					else {
						while(!st.isEmpty() && greaterOrEqual(st.peek(), s)) sb.append(st.pop());
						st.push(s);
 					}
				} else if(s.equals("(")) st.push(s);
				else if(s.equals(")")){
					while(!st.isEmpty() && !st.peek().equals("(")) sb.append(st.pop());
					st.pop();
				}
			}
			while(!st.isEmpty()) 
				if(st.peek().equals("(")) st.pop();
				else sb.append(st.pop());
			System.out.println(sb);
			if(!done) System.out.println();
		}
	}
	
	static boolean greaterOrEqual(String a, String b){
		if(a.matches("[\\*/]")) return true;
		if(a.matches("[+\\-]") && b.matches("[+\\-]")) return true;
		return false;
	}
}
