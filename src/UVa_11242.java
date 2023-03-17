import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_11242 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n1 = sc.nextInt();
			if(n1==0) break;
			int n2 = sc.nextInt();
			double[] a1 = new double[n1];
			double[] a2 = new double[n2];
			for(int i=0; i<n1; i++) a1[i] = sc.nextDouble();
			for(int i=0; i<n2; i++) a2[i] = sc.nextDouble();
			ArrayList<Double> res = new ArrayList<>();
			for(int i=0; i<n1; i++)
				for(int j=0; j<n2; j++)
					res.add(a2[j]/a1[i]);
			Collections.sort(res);
			double max = 0;
			for(int i=1; i<res.size(); i++) max = Math.max(max, res.get(i)/res.get(i-1));
			System.out.printf("%.2f\n", max);
		} 
	}
}
