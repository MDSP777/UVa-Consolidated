import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UVa_11389 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			long n = sc.nextLong();
			long d = sc.nextLong();
			long r = sc.nextLong();
			if(n==0) break;
			long cost = 0;
			PriorityQueue<Long> day = new PriorityQueue<>();
			PriorityQueue<Long> night = new PriorityQueue<>(Collections.reverseOrder());
			for(int i=0; i<n; i++) day.add(sc.nextLong());
			for(int i=0; i<n; i++) night.add(sc.nextLong());
			for(int i=0; i<n; i++) {
				long meters = day.poll()+night.poll();
				if(meters>d) cost += (meters-d)*r;
			}
			System.out.println(cost);
		}
	}
}
