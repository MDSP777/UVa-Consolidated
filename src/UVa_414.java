import java.util.Scanner;

public class UVa_414 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n=sc.nextInt();
			sc.nextLine();
			if(n==0) break;
			int[] diffs = new int[n];
			int min = 100;
			for(int i=0; i<n; i++) {
				char[] arr = sc.nextLine().toCharArray();
				int s = 0;
				for(int j=0; j<arr.length; j++)
					if(arr[j]==' ') s++;
				diffs[i] = s;
				min = Math.min(min, s);
			}
			int total = 0;
			for(int i=0; i<n; i++) total+=diffs[i]-min;
			System.out.println(total);
		}
	}
}
