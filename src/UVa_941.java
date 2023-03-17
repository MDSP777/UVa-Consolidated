import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_941 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long[] f = new long[21];
		f[0] = f[1] = 1;
		for(int i=2; i<21; i++) f[i] = f[i-1]*i;
		int tc = sc.nextInt();
		while(tc-->0){
			char[] word = sc.next().toCharArray();
			ArrayList<Character> w = new ArrayList<>();
			for(int i=0; i<word.length; i++) w.add(word[i]);
			long n = sc.nextLong();
			Collections.sort(w);
			ArrayList<Integer> fac = new ArrayList<>();
			int ctr = 1;
			while(n>0){
				fac.add((int)(n%ctr));
				n/=ctr++;
			}
			while(fac.size()<w.size()) fac.add(0);
			Collections.reverse(fac);
			String out = "";
			for(int i=0; i<fac.size(); i++) {
				out+=w.get(fac.get(i));
				w.remove((int)fac.get(i));
			}
			System.out.println(out);
		}
	}
}
