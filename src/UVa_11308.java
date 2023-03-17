import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_11308 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nBinders = sc.nextInt();
		while(nBinders-->0) {
			sc.nextLine();
			String bName = sc.nextLine();
			int m = sc.nextInt();
			int n = sc.nextInt();
			int b = sc.nextInt();
			HashMap<String, Integer> ing = new HashMap<>();
			while(m-->0) ing.put(sc.next(), sc.nextInt());
			ArrayList<Recipe> l = new ArrayList<>();
			while(n-->0) {
				sc.nextLine();
				String rName = sc.nextLine();
				int nIng = sc.nextInt();
				int cost = 0;
				while(nIng-->0) cost+=ing.get(sc.next())*sc.nextInt();
				if(cost<=b) l.add(new Recipe(rName, cost));
			}
			Collections.sort(l);
			System.out.println(bName.toUpperCase());
			if(l.size()==0) System.out.println("Too expensive!");
			else for(Recipe r: l) System.out.println(r.name);
			System.out.println();
		}
	}
	
	static class Recipe implements Comparable<Recipe> {
		String name;
		int cost;
		
		public Recipe(String n, int c) {
			name = n;
			cost = c;
		}

		@Override
		public int compareTo(Recipe o) {
			if(this.cost==o.cost) return this.name.compareTo(o.name);
			return Integer.compare(this.cost, o.cost);
		}
	}
}
