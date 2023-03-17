import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class UVa_127 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s.equals("#")) break;
			ArrayList<Stack<Card>> stacks = new ArrayList<>();
			String[] split = s.split("\\s+");
			for(int i=0; i<split.length; i++) {
				Stack<Card> st = new Stack<>();
				st.add(new Card(split[i].charAt(0), split[i].charAt(1)));
				stacks.add(st);
			}
			split = br.readLine().split("\\s+");
			for(int i=0; i<split.length; i++) {
				Stack<Card> st = new Stack<>();
				st.add(new Card(split[i].charAt(0), split[i].charAt(1)));
				stacks.add(st);
			}
			while(true) {
				boolean madeMove = false;
				for(int i=0; i<stacks.size(); i++) {
					Stack<Card> st = stacks.get(i);
					if(i>=3 && st.peek().matches(stacks.get(i-3).peek())) {
						stacks.get(i-3).push(st.pop());
						madeMove = true;
						if(st.isEmpty()) stacks.remove(i);
						break;
					} else if(i>=1 && st.peek().matches(stacks.get(i-1).peek())) {
						stacks.get(i-1).push(st.pop());
						madeMove = true;
						if(st.isEmpty()) stacks.remove(i);
						break;
					}
				}
				if(!madeMove) break;
			}
			System.out.print(stacks.size()+ (stacks.size()==1 ? " pile remaining:" : " piles remaining:"));
			for(int i=0; i<stacks.size(); i++) System.out.print(" "+stacks.get(i).size());
			System.out.println();
		}
	}
	
	static class Card {
		char val;
		char suit;
		
		public Card(char v, char s) {
			val = v;
			suit = s;
		}
		
		boolean matches(Card o) {
			return val==o.val || suit==o.suit;
		}
	}
}
