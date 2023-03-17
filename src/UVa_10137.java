import java.util.Scanner;


public class UVa_10137 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			double[] arr = new double[n];
			double total = 0;
			for(int i=0; i<n; i++){
				arr[i] = sc.nextDouble();
				total+=arr[i];
			}
			double x = 0;
			double avg = total/n;
			avg = Math.round(avg*100)/100.0;
			double pos = 0, neg = 0;
			for(int i=0; i<n; i++){
				if(arr[i]>avg)
					pos+=arr[i]-avg;
				else neg+=avg-arr[i];
			}
			System.out.printf("$%.2f\n", Math.min(pos, neg));
		}
	}
}
