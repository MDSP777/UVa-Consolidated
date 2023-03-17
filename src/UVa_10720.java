import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10720 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			ArrayList<Integer> d = new ArrayList<>();
			int sum = 0;
			for(int i=0; i<n; i++) {
				d.add(sc.nextInt());
				sum+=d.get(i);
			}
			Collections.sort(d, Collections.reverseOrder());
			boolean yes = (sum&1)==0;
			for(int k=1; yes && k<=n; k++){
				int left = 0;
				for(int i=0; yes && i<k; i++) left+=d.get(i);
				int right = k*(k-1);
				for(int i=k; i<n; i++) right+=Math.min(d.get(i), k);
				if(left>right) yes = false;
			}
			System.out.println(yes ? "Possible" : "Not possible");
		}
	}
}
