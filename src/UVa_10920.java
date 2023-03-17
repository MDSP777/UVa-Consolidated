import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Long> terms = new ArrayList<>();
		for(long i=1; i<100000; i+=2) terms.add(i*i);
		while(true) {
			int s = sc.nextInt();
			long n = sc.nextInt();
			if(s==0 && n==0) break;
			int centerI = s/2;
			int centerJ = s/2;
			int index = Collections.binarySearch(terms, n);
			if(index>=0) System.out.println("Line = "+(centerI+index+1)+", column = "+(centerJ+index+1)+".");
			else {
				index = -(index+1);
				long squareDiff = terms.get(index)-terms.get(index-1);
				long group = squareDiff-(n-terms.get(index-1));
				if(group>=0 && group<squareDiff/4) {
//					System.out.println("group 4, offset from corner "+(n-(terms.get(index-1)+squareDiff*3/4)));
					System.out.println("Line = "+(centerI-index+1+(n-(terms.get(index-1)+squareDiff*3/4)))+", column = "+(centerJ+index+1)+".");
				} else if(group>=squareDiff/4 && group<squareDiff/2) {
//					System.out.println("group 3, offset from corner "+(n-terms.get(index-1)-squareDiff/2));
					System.out.println("Line = "+(centerI-index+1)+", column = "+(centerJ-index+1+(n-terms.get(index-1)-squareDiff/2))+".");
				} else if(group>=squareDiff/2 && group<squareDiff*3/4) {
//					System.out.println("group 2, offset from corner "+(n-(terms.get(index-1)+squareDiff/4)));
					System.out.println("Line = "+(centerI+index+1-(n-(terms.get(index-1)+squareDiff/4)))+", column = "+(centerJ-index+1)+".");
				} else if(group>=squareDiff*3/4 && group<squareDiff) {
//					System.out.println("group 1, offset from corner "+(n-terms.get(index-1)));
					System.out.println("Line = "+(centerI+index+1)+", column = "+(centerJ+index-(n-1-terms.get(index-1)))+".");
				}
			}
		}
	}
}
