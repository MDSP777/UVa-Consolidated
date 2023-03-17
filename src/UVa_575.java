import java.util.Scanner;

public class UVa_575 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String s = new StringBuilder(sc.next()).reverse().toString();
			if(s.equals("0")) break;
			int total = 0;
			for(int i=0; i<s.length(); i++)
				total+=Integer.parseInt(s.charAt(i)+"")*(Math.pow(2, i+1)-1);
			System.out.println(total);
		}
	}
}
