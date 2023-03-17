import java.util.BitSet;
import java.util.Scanner;
import java.util.Stack;

public class UVa_12582 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++){
			char[] str = sc.next().toCharArray();
			BitSet letters = new BitSet();
			int[] ctr = new int[26];
			Stack<Character> st = new Stack<>();
			for(char cur: str){
				letters.set(cur-'A');
				if(!st.isEmpty() && st.peek()==cur) {
					st.pop();
					if(!st.isEmpty()) ctr[st.peek()-'A']++;
				} else {
					st.push(cur);
				}
 			}
			System.out.println("Case "+t);
			for(int i=0; i<26; i++)
				if(letters.get(i)) System.out.println(((char)(i+'A'))+" = "+(ctr[i] + (i+'A'==str[0] ? 0 : 1)));
		}
	}
}
