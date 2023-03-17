import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UVa_230 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Book> books = new ArrayList<>();
		HashMap<String, String> authorsMap = new HashMap<>();
		while(true) {
			String s = br.readLine();
			if(s.equals("END")) break;
			String[] split = s.split(" by ");
			books.add(new Book(split[0], split[1]));
			authorsMap.put(split[0], split[1]);
		}
		Collections.sort(books);
		ArrayList<Book> returned = new ArrayList<>();
		while(true) {
			String s = br.readLine();
			if(s.equals("END")) break;
			if(s.startsWith("BORROW")) {
				s = s.substring(7);
				int index = Collections.binarySearch(books, new Book(s, authorsMap.get(s)));
				books.get(index).borrowed = true;
			} else if(s.startsWith("RETURN")) {
				s = s.substring(7);
				int index = Collections.binarySearch(books, new Book(s, authorsMap.get(s)));
				books.get(index).borrowed = false;
				returned.add(books.get(index));	
			} else {
				Collections.sort(returned);
				for(int i=0; i<returned.size(); i++) {
					int index = Collections.binarySearch(books, returned.get(i));
					int left = index-1;
					while(left>=0 && books.get(left).borrowed) left--;
					System.out.println(left==-1 ? "Put "+books.get(index).title+" first" : "Put "+books.get(index).title+" after "+books.get(left).title);
				}
				returned = new ArrayList<>();
				System.out.println("END");
			}
		}
	}
	
	static class Book implements Comparable<Book> {
		String title;
		String author;
		boolean borrowed;
		
		public Book(String title, String author) {
			this.title = title;
			this.author = author;
			borrowed = false;
		}

		@Override
		public int compareTo(Book o) {
			if(this.author.equals(o.author)) return this.title.compareTo(o.title);
			return this.author.compareTo(o.author);
		}
	}
}
