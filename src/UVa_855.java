import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_855 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int nC = sc.nextInt();
		while(nC-->0) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int f = sc.nextInt();
			ArrayList<Integer> rows = new ArrayList<>();
			ArrayList<Integer> cols = new ArrayList<>();
			for(int i=0; i<f; i++) {
				rows.add(sc.nextInt());
				cols.add(sc.nextInt());
			}
			Collections.sort(rows);
			Collections.sort(cols);
			int m = f%2==0 ? (f-1)/2 : f/2;
			sb.append("(Street: ").append(rows.get(m)).append(", Avenue: ").append(cols.get(m)).append(")\n");
		}
		System.out.print(sb);
	}
}
