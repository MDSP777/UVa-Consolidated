import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] terms = new int[n];
			ArrayList<Integer> t = new ArrayList<>();
			for(int i=0; i<n; i++) terms[i] = sc.nextInt();
			int x = 0;
			int index = 0;
			for(int i=0; i<m; i++) {
				int size = sc.nextInt();
				while(t.size()<size) {
					int toAdd = terms[index++];
					int l = Collections.binarySearch(t, toAdd);
					if(l<0) l = -(l+1);
					t.add(l, toAdd);
				}
				System.out.println(t.get(x++));
			}
			if(nC>0) System.out.println();
		}
	}
}
