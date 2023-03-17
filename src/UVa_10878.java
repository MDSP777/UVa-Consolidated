import java.util.Scanner;

public class UVa_10878 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		while(true) {
			String s = sc.nextLine();
			if(s.equals("___________")) break;
			System.out.print(convert(s));
		}
	}

	private static char convert(String s) {
		s = s.substring(1).trim();
		int n = 1;
		for(int i=1; i<s.length(); i++) 
			if(s.charAt(i)==' ') n*=2;
			else if(s.charAt(i)=='o') n = n*2+1;
		return (char) n;
	}
}
