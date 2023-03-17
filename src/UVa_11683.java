import java.util.Scanner;

public class UVa_11683 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int r = sc.nextInt();
			if(r==0) break;
			int c = sc.nextInt();
			int curHeight = sc.nextInt();
			int total = r-curHeight;
			for(int i=1; i<c; i++) {
				int newHeight = sc.nextInt();
				if(newHeight<curHeight) total += (curHeight-newHeight);
				curHeight = newHeight;
			}
			System.out.println(total);
		}
	}
}
