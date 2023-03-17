import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class UVa_732 {
	static char[] c1;
	static char[] c2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		do {
			String s1 = sc.next();
			String s2 = sc.next();
			c1 = s1.toCharArray();
			c2 = s2.toCharArray();
			ArrayList<Word> words = new ArrayList<>();
			words.add(new Word(new Stack<>()));
			for(int i=0; i<c1.length; i++) {
				ArrayList<Word> nWords = new ArrayList<>();
				for(Word w: words) {
					while(!w.s.isEmpty() && w.s.peek()==c2[w.index]) {
						Word nWord = w.copy();
						nWord.out.append(nWord.s.pop());
						nWord.index++;
						nWord.path.append("o ");
						nWords.add(nWord);
						w = nWord;
					}
				}
				for(Word w: nWords) words.add(w);
				for(Word w: words) {
					w.s.add(c1[i]);
					w.path.append("i ");
				}
			}
			for(Word w: words) 
				while(!w.s.isEmpty()) {
					w.path.append("o ");
					w.out.append(w.s.pop());
					w.index++;
				}
			ArrayList<Word> out = new ArrayList<>();
			for(Word w: words) if(w.out.toString().equals(s2)) out.add(w);
			Collections.sort(out);
			sb.append("[\n");
			for(Word w: out) sb.append(w).append("\n");
			sb.append("]\n");
		} while(sc.hasNext());
		System.out.print(sb);
	}
	
	static class Word implements Comparable<Word> {
		int index;
		StringBuilder path;
		StringBuilder out;
		Stack<Character> s;
		
		public Word(Stack<Character> s) {
			index = 0;
			path = new StringBuilder();
			out = new StringBuilder();
			this.s = s;
		}
		
		public Word copy() {
			Word newWord = new Word((Stack<Character>) this.s.clone());
			newWord.index = this.index;
			newWord.path = new StringBuilder(this.path);
			newWord.out = new StringBuilder(this.out);
			return newWord;
		}
		
		public String toString() {
			return path.toString().trim();
		}

		@Override
		public int compareTo(Word o) {
			return this.path.toString().compareTo(o.path.toString());
		}
	}
}
