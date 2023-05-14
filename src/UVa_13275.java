import java.util.Scanner;

public class UVa_13275 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int d = sc.nextInt();
			int m = sc.nextInt();
			int y = sc.nextInt();
			int q = sc.nextInt();
			
			int b = q-y;
			if(m==2 && d==29) 
				for(int i=y+1; i<=q; i++)
					if(!isLeap(i)) b--;
			System.out.println("Case "+t+": "+b);
		}
	}
	
	static boolean isLeap(int x) {
		if(x%400==0) return true;
		if(x%100==0) return false;
		return x%4==0;
	}
}
