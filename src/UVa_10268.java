import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UVa_10268 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		do {
			long x = sc.nextLong();
			sc.nextLine();
			long total = 0;
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			ArrayList<Long> coeffs = new ArrayList<>();
			while(st.hasMoreTokens()) coeffs.add(Long.parseLong(st.nextToken()));
			long temp = 1;
			for(int i=coeffs.size()-2; i>=0; i--) {
				total+=coeffs.get(i)*(coeffs.size()-i-1)*temp;
				temp*=x;
			}
			System.out.println(total);
		} while(sc.hasNext());
	}
}


/*
Code below is WA. Idk why

public class UVa_10268 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		do {
			long x = sc.nextLong();
			sc.nextLine();
			long total = 0;
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			long pow = st.countTokens()-1;
			while(st.hasMoreTokens()) {
				total+=pow*Long.parseLong(st.nextToken())*Math.pow(x, pow-1);
				pow--;
			}
			System.out.println(total);
		} while(sc.hasNext());
	}
}
*/