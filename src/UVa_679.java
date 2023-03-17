import java.util.BitSet;
import java.util.Scanner;


public class UVa_679 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[][] memo = new int[21][525000];
		for(int i=0; i<=20; i++)
			for(int j=0; j<525000; j++) memo[i][j] = -1;
		int tc = sc.nextInt();
		while(tc-->0){
			int d = sc.nextInt();
			int x = sc.nextInt();
			if(memo[d][x]!=-1) {
				sb.append(memo[d][x]).append("\n");
				continue;
			}
			BitSet bs = new BitSet();
			int cur = 1;
			for(int idx=1; idx<=x; idx++){
				cur = 1;
				for(int i=1; i<d; i++)
					if(!bs.get(cur)){
						bs.set(cur);
						cur*=2;
					} else {
						bs.set(cur, false);
						cur = cur*2+1;
					}
				memo[d][idx] = cur;
			}
			sb.append(cur).append("\n");
		}
		System.out.print(sb);
	}
}
