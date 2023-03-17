import java.util.Scanner;

public class UVa_10222 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String map = "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./";
		do {
			String s = sc.nextLine().toLowerCase();
			for(int i=0; i<s.length(); i++)
				if(s.charAt(i)==' ') System.out.print(' ');
				else 
					for(int j=0; j<map.length(); j++)
						if(map.charAt(j)==s.charAt(i)) System.out.print(map.charAt(j-2));
			System.out.println();
		}while(sc.hasNext());
	}
}
