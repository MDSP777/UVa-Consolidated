import java.util.Scanner;

public class UVa_10038 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				int n = sc.nextInt();
				int[] arr = new int[n];
				for(int i=0; i<n; i++) arr[i] = sc.nextInt();
				boolean[] j = new boolean[n];
				for(int i=1; i<n; i++) j[Math.abs(arr[i]-arr[i-1])] = true;
				boolean s = true;
				for(int i=1; i<n; i++) s&=j[i];
				System.out.println(s ? "Jolly" : "Not jolly");
			} catch(Exception e) {
				System.out.println("Not jolly");
			}
		} while(sc.hasNext());
	}
}
