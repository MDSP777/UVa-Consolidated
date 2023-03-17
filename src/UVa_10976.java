import java.util.ArrayList;
import java.util.Scanner;

public class UVa_10976 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double eps = 10e-5;
		do {
			int n = sc.nextInt();
			ArrayList<String> ans = new ArrayList<>();
			for(int i=n+1; i<=n*2; i++) {
				double diff = 1.0/n-1.0/i;
				int pow = 0;
				while(Math.floor(diff)!=diff) {
					diff*=10;
					pow++;
				}
				diff = Math.pow(10, pow)/diff;
				if(Math.abs(diff-Math.round(diff))<=eps) ans.add("1/"+n+" = 1/"+((int) Math.round(diff))+" + 1/"+i);
			}
			System.out.println(ans.size());
			for(String s: ans) System.out.println(s);
		} while(sc.hasNext());
	}
}
