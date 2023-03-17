import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;

public class UVa_665 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			BitSet legit = new BitSet();
			while(q-->0) {
				int s = sc.nextInt();
				int[] left = new int[s];
				for(int i=0; i<s; i++) left[i] = sc.nextInt()-1;
				int[] right = new int[s];
				for(int i=0; i<s; i++) right[i] = sc.nextInt()-1;
				String c = sc.next();
				if(c.equals("=")) {
					for(int i=0; i<s; i++) {
						legit.set(left[i]);
						legit.set(right[i]);
					}
				} else {
					HashSet<Integer> suspect = new HashSet<>();
					for(int i=0; i<s; i++) {
						suspect.add(left[i]);
						suspect.add(right[i]);
					}
					for(int i=0; i<n; i++) if(!suspect.contains(i)) legit.set(i);
				}
			}
			if(legit.cardinality()==n-1) {
				for(int i=0; i<n; i++)
					if(!legit.get(i)) {
						System.out.println(i+1);
						break;
					}
			} else System.out.println("0");
			if(nC>0) System.out.println();
		}
	}
}
