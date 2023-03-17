import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_555 {
	static char[] suits = {'C', 'D', 'S', 'H'};
	static char[] vals = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
	static char[] order = {'S', 'W', 'N', 'E'};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int loc = getIndex(sc.next().charAt(0));
			if(loc==-1) break;
			String deck = sc.next()+sc.next();
			ArrayList<Card>[] cards = new ArrayList[4];
			for(int i=0; i<4; i++) cards[i] = new ArrayList<>();
			for(int i=0; i<deck.length(); i+=2) {
				loc = (loc+1)%4;
				cards[loc].add(new Card(deck.charAt(i), deck.charAt(i+1)));
			}
			for(int i=0; i<4; i++) {
				Collections.sort(cards[i]);
				System.out.print(order[i]+":");
				for(int j=0; j<cards[i].size(); j++) System.out.print(cards[i].get(j));
				System.out.println();
			}			
		}
	}
	
	static int getIndex(char c) {
		for(int i=0; i<order.length; i++) if(c==order[i]) return i;
		return -1;
	}
	
	static class Card implements Comparable<Card> {
		int suit;
		int value;
		
		public Card(int s, int v) {
			for(int i=0; i<suits.length; i++) if(s==suits[i]) suit = i;
			for(int i=0; i<vals.length; i++) if(v==vals[i]) value = i;
		}

		@Override
		public int compareTo(Card o) {
			if(Integer.compare(this.suit, o.suit)==0) return Integer.compare(this.value, o.value);
			return Integer.compare(this.suit, o.suit);
		}
		
		public String toString() {
			return " "+suits[suit]+vals[value];
		}
	}
	
}
