import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class UVa_11368 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int n = sc.nextInt();
			ArrayList<Doll> dolls = new ArrayList<>();
			ArrayList<Doll> nested = new ArrayList<>();
			for(int i=0; i<n; i++) dolls.add(new Doll(sc.nextInt(), sc.nextInt()));
			Collections.sort(dolls);
			nested.add(dolls.get(0));
			for(int i=1; i<n; i++) {
				int h = nested.size()-1;
				int l = 0;
				int mid;
				while(l<=h) {
					mid = (l+h)/2;
					if(dolls.get(i).w>=nested.get(mid).w || dolls.get(i).h>=nested.get(mid).h) l = mid+1;
					else h = mid-1;
				}
				if(l==nested.size()) nested.add(dolls.get(i));
				else {
//					System.out.println("putting "+dolls.get(i)+" in "+nested.get(l));
					nested.get(l).w = dolls.get(i).w;
					nested.get(l).h = dolls.get(i).h;
				}
			}
			System.out.println(nested.size());
		}
	}
	
	static class Doll implements Comparable<Doll> {
		int w;
		int h;
		
		public Doll(int w, int h) {
			this.w = w;
			this.h = h;
		}

		@Override
		public int compareTo(Doll o) {
			if(this.h==o.h) return Integer.compare(this.w, o.w);
			return Integer.compare(o.h, this.h);
		}
		
		public String toString() {
			return w+" "+h;
		}
	}
}
