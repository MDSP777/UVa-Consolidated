import java.util.Arrays;
import java.util.Scanner;

public class UVa_11517 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] memo = new int[20100];
			Arrays.fill(memo, 200000000);
			memo[0] = 0;
			for(int i=0; i<m; i++){
				int c = sc.nextInt();
				for(int j=20099-c; j>=0; j--)
					memo[j+c] = Math.min(memo[j+c], memo[j]+1);
			}
			for(int i=n; i<20100; i++)
				if(memo[i]!=200000000){
					System.out.println(i+" "+memo[i]);
					break;
				}
		}
	}
}
