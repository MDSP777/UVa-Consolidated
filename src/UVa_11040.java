import java.util.Scanner;

public class UVa_11040 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			long[][] terms = new long[9][9];
			for(int i=0; i<9; i+=2)
				for(int j=0; j<=i; j+=2) terms[i][j] = sc.nextLong();
			for(int i=1; i<9; i+=2) terms[8][i] = (terms[6][i-1]-terms[8][i-1]-terms[8][i+1])/2;
			for(int i=7; i>=0; i--)
				for(int j=0; j<=i; j++) terms[i][j] = terms[i+1][j]+terms[i+1][j+1];
			for(int i=0; i<9; i++) {
				System.out.print(terms[i][0]);
				for(int j=1; j<=i; j++) System.out.print(" "+terms[i][j]);
				System.out.println();
			}
		}
	}
}
