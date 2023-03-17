import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class UVa_11900 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++){
			int n = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			ArrayList<Integer> a = new ArrayList<>();
			for(int i=0; i<n; i++) a.add(sc.nextInt());
			Collections.sort(a);
			int ctr = 0;
			int sum = 0;
			int i = 0;
			while(ctr<p && sum<q && i<n){
				if(ctr+1<=p && sum+a.get(i)<=q && i<n){
					ctr++;
					sum+=a.get(i);
					i++;
				} else {
					break;
				}
			}
			System.out.println("Case "+t+": "+ctr);
		}
	}
}
