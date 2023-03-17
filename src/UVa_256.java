import java.util.ArrayList;
import java.util.Scanner;

public class UVa_256 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String>[] a = new ArrayList[4];
		for(int i=0; i<3; i++) {
			int nDigits = (i+1)*2;
			a[i] = new ArrayList<>();
			int lim = (int) Math.pow(10, nDigits);
			for(int j=0; j<lim; j++) 
				if(quirk(j, nDigits)) a[i].add(string(j, nDigits)); 
		}
		a[3] = new ArrayList<>();
		a[3].add("00000000");
		a[3].add("00000001");
		a[3].add("04941729");
		a[3].add("07441984");
		a[3].add("24502500");
		a[3].add("25502500");
		a[3].add("52881984");
		a[3].add("60481729");
		a[3].add("99980001");
		do {
			int n = sc.nextInt()/2-1;
			for(int i=0; i<a[n].size(); i++)
				System.out.println(a[n].get(i));
		} while(sc.hasNext());
	}

	private static String string(int n, int nDigits) {
		String s = n+"";
		while(s.length()<nDigits) s = "0"+s;
		return s;
	}

	private static boolean quirk(int n, int nDigits) {
		String s = string(n, nDigits);
		int left = Integer.parseInt(s.substring(0, nDigits/2));
		int right = Integer.parseInt(s.substring(nDigits/2));
		return (left+right)*(left+right)==n;
	}
}
