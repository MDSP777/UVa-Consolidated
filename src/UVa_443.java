import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


public class UVa_443 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Long> s = new HashSet<>();
		int[] m = {2, 3, 5, 7};
		LinkedList<Long> q = new LinkedList<>();
		q.add(1l);
		s.add(1l);
		while(!q.isEmpty() && s.size()<5842){
			long cur = q.poll();
			for(int i=0; i<4; i++){
				long next = cur*m[i];
				if(!s.contains(next) && next<=2*1e9){
					s.add(next);
					q.add(next);
				}
			}
		}
		ArrayList<Long> a = new ArrayList<>();
		for(long l : s) a.add(l);
		Collections.sort(a);
		while(true){
			int i = sc.nextInt();
			if(i==0) break;
			System.out.println("The "+i+(i%100>=11 && i%100<20 ? "th" : i%10==1 ? "st" : i%10==2 ? "nd" : i%10==3 ? "rd" : "th")+" humble number is "+a.get(i-1)+".");
		}
	}
}
