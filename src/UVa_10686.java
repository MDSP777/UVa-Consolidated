import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class UVa_10686 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int n = sc.nextInt();
			Type[] types = new Type[n];
			for(int i=0; i<n; i++) {
				String name = sc.next();
				int nK = sc.nextInt();
				int r = sc.nextInt();
				types[i] = new Type(name, r);
				while(nK-->0) types[i].keywords.add(sc.next());
			}
			sc.nextLine();
			while(true) {
				String s = sc.nextLine().replaceAll("[^A-Za-z]", " ");
				if(s.isEmpty()) break;
				String[] split = s.split("\\s+");
				for(String cur: split) 
					for(int i=0; i<n; i++) 
						if(types[i].keywords.contains(cur)) types[i].actual.add(cur);
			}
			ArrayList<String> res = new ArrayList<>();
			for(int i=0; i<n; i++) if(types[i].actual.size()>=types[i].req) res.add(types[i].name);
			if(res.size()==0) System.out.println("SQF Problem.");
			else {
				System.out.print(res.get(0));
				for(int i=1; i<res.size(); i++) System.out.print(","+res.get(i));
				System.out.println();
			}
		}
	}
	
	static class Type {
		String name;
		HashSet<String> keywords;
		HashSet<String> actual;
		int req;
		
		public Type(String name, int req) {
			this.name = name;
			keywords = new HashSet<>();
			actual = new HashSet<>();
			this.req = req;
		}
	}
}
