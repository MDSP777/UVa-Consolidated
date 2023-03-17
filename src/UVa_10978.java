import java.util.Scanner;

public class UVa_10978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			String[] cards = new String[n];
			int curIndex = n-1;
			for(int i=0; i<n; i++) {
				String card = sc.next();
				int l = sc.next().length();
				while(l-->0) {
					curIndex = (curIndex+1)%n;
					while(cards[curIndex]!=null) curIndex = (curIndex+1)%n;
				}
				cards[curIndex] = card;
			}
			System.out.print(cards[0]);
			for(int i=1; i<cards.length; i++) System.out.print(" "+cards[i]);
			System.out.println();
		}
	}
}
