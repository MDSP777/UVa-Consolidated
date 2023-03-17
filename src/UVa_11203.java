import java.util.Scanner;

public class UVa_11203 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0){
			String s = sc.next();
			boolean yes = true;
			if(!s.matches("^[?]+M[?]+E[?]+$")) yes = false;
			else {
				String[] split = s.split("[ME]");
				if(split[0].length()+split[1].length()!=split[2].length()) yes = false;
			}
			System.out.println(yes ? "theorem" : "no-theorem");
		}
	}
}
