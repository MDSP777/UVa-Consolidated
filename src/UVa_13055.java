import java.util.Scanner;
import java.util.Stack;


public class UVa_13055 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<String> st = new Stack<>();
		while(n-->0){
			String s = sc.next();
			if(s.equals("Sleep")) st.push(sc.next());
			else if(s.equals("Test")) System.out.println(st.isEmpty() ? "Not in a dream" : st.peek());
			else if(!st.isEmpty()) st.pop();
		}
	}
}
