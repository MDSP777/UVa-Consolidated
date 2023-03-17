import java.util.Scanner;

public class UVa_12488 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int n = sc.nextInt();
			int[] orig = new int[n];
			for(int i=0; i<n; i++) orig[i] = sc.nextInt();
			int[] res = new int[n];
			for(int i=0; i<n; i++) res[i] = sc.nextInt();
			int total = 0;
			for(int i=n-1; i>=0; i--) {
				int o_index = 0;
				for(int j=0; j<n; j++)
					if(orig[j]==res[i]) {
						o_index = j;
						break;
					}
				for(int j=o_index; j<i; j++) {
					int temp = orig[j];
					orig[j] = orig[j+1];
					orig[j+1] = temp;
					total++;
				}
			}
			System.out.println(total);
		} while(sc.hasNext());
	}
}
