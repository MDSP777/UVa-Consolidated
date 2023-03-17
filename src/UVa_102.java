import java.util.Scanner;

public class UVa_102 {
	// 0: B, 1: G, 2: C
	static int[][] combs = {
		{0, 2, 1},
		{0, 1, 2},
		{2, 0, 1},
		{2, 1, 0},
		{1, 0, 2},
		{1, 2, 0}
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int[] bottles = new int[9];
			for(int i=0; i<9; i++) bottles[i] = sc.nextInt();
			System.out.println(solve(bottles));
		}while(sc.hasNext());
	}

	private static String solve(int[] bottles) {
		int best = Integer.MAX_VALUE;
		String bestStr = "";
		for(int i=0; i<combs.length; i++) {
			int cur = 0;
			switch(combs[i][0]) {
				case 0:
					cur+=bottles[3]+bottles[6];
					break;
				case 1:
					cur+=bottles[4]+bottles[7];
					break;
				default:
					cur+=bottles[5]+bottles[8];
			}
			switch(combs[i][1]) {
				case 0:
					cur+=bottles[0]+bottles[6];
					break;
				case 1:
					cur+=bottles[1]+bottles[7];
					break;
				default:
					cur+=bottles[2]+bottles[8];
			}
			switch(combs[i][2]) {
				case 0:
					cur+=bottles[0]+bottles[3];
					break;
				case 1:
					cur+=bottles[1]+bottles[4];
					break;
				default:
					cur+=bottles[2]+bottles[5];
			}
			if(cur<best) {
				best = cur;
				bestStr = convert(combs[i]);
			}
		}
		return bestStr+" "+best;
	}

	private static String convert(int[] a) {
		String out = "";
		for(int i=0; i<a.length; i++) out+=a[i]==0 ? "B" : a[i]==1 ? "G" : "C";
		return out;
	}
}
