import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;

public class UVa_10404 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] choices = new int[m];
			HashSet<Integer> c = new HashSet<>();
			for(int i=0; i<m; i++) {
				choices[i] = sc.nextInt();
				c.add(choices[i]);
			}
			BitSet memo = new BitSet();
			for(int i=1; i<=n; i++)
				if(c.contains(i)) memo.set(i);
				else {
					boolean win = false;
					for(int j=0; !win && j<m; j++)
						if(i>=choices[j]) win|=!memo.get(i-choices[j]);
					memo.set(i, win);
				}
			System.out.println(memo.get(n) ? "Stan wins" : "Ollie wins");
		}while(sc.hasNext());
	}
}
