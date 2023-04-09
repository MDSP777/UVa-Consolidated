import java.util.Scanner;

public class UVa_1641 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int area = 0;
			for(int i=0; i<r; i++) {
				char[] arr = sc.next().toCharArray();
				boolean inside = false;
				for(char cur : arr) {
					if(cur=='/' || cur=='\\') {
						area++;
						inside = !inside;
					} else if(inside) area+=2;
				}
			}
			System.out.println(area/2);
		} while(sc.hasNext());
	}
}
