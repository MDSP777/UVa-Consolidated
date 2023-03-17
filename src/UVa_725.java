import java.util.ArrayList;
import java.util.Scanner;

public class UVa_725 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean first = true;
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			if(first) first = false;
			else System.out.println();
			ArrayList<Integer> ans = new ArrayList<>();
			for(int i=1234; i<=98765; i++) 
				if(i%n==0) if(hasAllDigits(i, i/n)) ans.add(i);
			if(ans.size()==0) System.out.println("There are no solutions for "+n+".");
			else 
				for(int i: ans) {
					String s1 = i+"";
					String s2 = (i/n)+"";
					while(s1.length()<5) s1 = "0"+s1;
					while(s2.length()<5) s2 = "0"+s2;
					System.out.println(s1+" / "+s2+" = "+n);
				}
		}
	}

	private static boolean hasAllDigits(int a, int b) {
		String s1 = a+"";
		String s2 = b+"";
		while(s1.length()<5) s1 = "0"+s1;
		while(s2.length()<5) s2 = "0"+s2;
		int[] freq = new int[10];
		boolean success = true;
		for(int i=0; i<5; i++) {
			freq[s1.charAt(i)-'0']++;
			freq[s2.charAt(i)-'0']++;
			success &= freq[s1.charAt(i)-'0']==1;
			success &= freq[s2.charAt(i)-'0']==1;
		}
		return success;
	}
}
