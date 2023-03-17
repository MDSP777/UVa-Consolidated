import java.util.Scanner;


public class UVa_11254 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==-1) break;
			int c = (int) (Math.sqrt(2*n)+2);
			while(c-->0){
				int num = 2*n-c*c+c;
				int den = 2*c;
				if(num<=0 || den<=0 || num%den!=0) continue;
				if(num%den==0){
					System.out.println(n+" = "+(num/den)+" + ... + "+(num/den+c-1));
					break;
				}
			}
		}
	}
}
