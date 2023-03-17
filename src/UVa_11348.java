import java.util.HashSet;
import java.util.Scanner;

public class UVa_11348 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		for(int x=1; x<=nC; x++) {
			int n = sc.nextInt();
			int[] owner = new int[10010];
			HashSet<Integer>[] sets = new HashSet[n];
			for(int i=1; i<=n; i++) {
				sets[i-1] = new HashSet<>();
				int nStamps = sc.nextInt();
				for(int j=0; j<nStamps; j++) {
					int stamp = sc.nextInt();
					if(owner[stamp]==0) owner[stamp] = i;
					else if(owner[stamp]!=i) owner[stamp] = -1;
				}
			}
			for(int i=0; i<owner.length; i++) if(owner[i]>0) sets[owner[i]-1].add(i);
			int total = 0;
			for(int i=0; i<n; i++) total+=sets[i].size();
			System.out.print("Case "+x+":");
			for(int i=0; i<n; i++) System.out.printf(" %.6f%c", sets[i].size()*100.0/total, '%');
			System.out.println();
		}
	}
}
