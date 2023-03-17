import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_12541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Person> p = new ArrayList<>();
		while(n-->0) p.add(new Person(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		Collections.sort(p);
		System.out.println(p.get(p.size()-1).name);
		System.out.println(p.get(0).name);
	}
	
	static class Person implements Comparable<Person> {
		String name;
		int d;
		int m;
		int y;
		
		public Person(String name, int d, int m, int y) {
			this.name = name;
			this.d = d;
			this.m = m;
			this.y = y;
		}

		@Override
		public int compareTo(Person o) {
			if(y==o.y) {
				if(m==o.m) return Integer.compare(d, o.d);
				return Integer.compare(m, o.m);
			}
			return Integer.compare(y, o.y);
		}
	}
}
