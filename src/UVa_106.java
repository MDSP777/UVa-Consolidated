import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UVa_106 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] t1 = new int[1_000_001];
		int[] first = new int[1_000_001];
		Arrays.fill(first, 100000000);
		for(int i=1; i*i<=1_000_000; i++)
			for(int j=i+1; j*j<=1_000_000; j++) {
				if((i&1)!=(j&1) && gcd(j, i)==1) {
					PriorityQueue<Integer> q = new PriorityQueue<>();
					q.add(j*j-i*i);
					q.add(2*i*j);
					q.add(i*i+j*j);
					int a = q.poll(), b = q.poll(), c = q.poll();
					if(c<=1_000_000) {
						t1[c]++;
						
						for(int k=1; c*k<=1_000_000; k++) {
							first[a*k] = Math.min(first[a*k], c*k);
							first[b*k] = Math.min(first[b*k], c*k); 
							first[c*k] = Math.min(first[c*k], c*k);
						}
					}
				}
			}
		int[] t2 = new int[1_000_001];
		
		for(int i=0; i<1_000_001; i++)
			if(first[i]!=100000000) t2[first[i]]++;
		
		int[] t1Sum = new int[1_000_001];
		int[] t2Sum = new int[1_000_001];
		t1Sum[0] = t1[0];
		t2Sum[0] = t2[0];
		for(int i=1; i<1_000_001; i++) {
			t1Sum[i] = t1[i]+t1Sum[i-1];
			t2Sum[i] = t2[i]+t2Sum[i-1];
		}
		do {
			int x = sc.nextInt();
			System.out.println(t1Sum[x]+" "+(x-t2Sum[x]));
		} while(sc.hasNext());
	}
	
	static int gcd(int a, int b) {
		return b==0 ? a : gcd(b, a%b);
	}
}
