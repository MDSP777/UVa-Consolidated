import java.util.ArrayList;
import java.util.Scanner;

public class UVa_735 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> scores = new ArrayList<>();
		for(int i=0; i<=60 ; i++) if(i<=20 || (i%2==0 && i/2<=20) || (i%3==0 && i/3<=20)) scores.add(i);
		scores.add(50);
		while(true) {
			int n = sc.nextInt();
			if(n<=0) break;
			int nC = 0;
			int nP = 0;
			for(int i : scores) 
				for(int j : scores) 
					for(int k : scores) 
						if(i+j+k==n) {
							if(i>=j && j>=k) nC++;
							nP++;
						}
			if(nP==0) System.out.println("THE SCORE OF "+n+" CANNOT BE MADE WITH THREE DARTS.");
			else {
				System.out.println("NUMBER OF COMBINATIONS THAT SCORES "+n+" IS "+nC+".");
				System.out.println("NUMBER OF PERMUTATIONS THAT SCORES "+n+" IS "+nP+".");
			}
			System.out.println("**********************************************************************");
		}
		System.out.println("END OF OUTPUT");
	}
}
