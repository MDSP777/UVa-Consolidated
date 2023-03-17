import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class UVa_612 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			int len = sc.nextInt();
			int n = sc.nextInt();
			ArrayList<String> arr = new ArrayList<>();
			for(int i=0; i<n; i++) arr.add(sc.next());
			Collections.sort(arr, new Comparator<String>() {

				@Override
				public int compare(String s1, String s2) {
					return inversions(s1)-inversions(s2);
				}
				
				int inversions(String s){
					int ctr = 0;
					for(int i=0; i<s.length(); i++)
						for(int j=i+1; j<s.length(); j++)
							if(s.charAt(i)>s.charAt(j)) ctr++;
					return ctr;
				}
				
			});
			for(String s : arr) System.out.println(s);
			if(tc>0) System.out.println();
		}
	}
}
