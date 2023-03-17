import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_410 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = 1;
		do{
			int c = sc.nextInt();
			int s = sc.nextInt();
			ArrayList<Integer> a = new ArrayList<>();
			for(int i=0; i<s; i++) a.add(sc.nextInt());
			while(a.size()<2*c) a.add(0);
			Collections.sort(a);
			System.out.println("Set #"+t++);
			double avg = 0;
			int[] totals = new int[c];
			for(int i=0; i<c; i++){
				System.out.print(" "+i+":");
				if(a.get(i)!=0) System.out.print(" "+a.get(i));
				if(a.get(2*c-1-i)!=0) System.out.print(" "+a.get(2*c-1-i));
				System.out.println();
				totals[i] = a.get(i)+a.get(2*c-1-i);
				avg+=totals[i];
			}
			avg/=c;
			double imbalance = 0;
			for(int i=0; i<c; i++) imbalance+=Math.abs(avg-totals[i]);
			System.out.printf("IMBALANCE = %.5f\n\n", imbalance);
		}while(sc.hasNext()); 
	}
}
