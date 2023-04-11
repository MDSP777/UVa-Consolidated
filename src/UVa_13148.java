import java.util.HashSet;
import java.util.Scanner;

public class UVa_13148 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] terms = {1, 64, 729, 4096, 15625, 46656, 117649, 262144, 531441,
				1000000, 1771561, 2985984, 4826809, 7529536, 11390625, 16777216, 24137569, 34012224,
				47045881, 64000000, 85766121};
		HashSet<Integer> set = new HashSet<>();
		for(int x : terms) set.add(x);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			System.out.println(set.contains(n) ? "Special" : "Ordinary");
		}
	}
}
