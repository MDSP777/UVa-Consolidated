import java.util.Scanner;


public class UVa_11878 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int ctr = 0;
		do{
			String[] split = sc.nextLine().split("=");
			if(!split[1].equals("?")){
				int ans = Integer.parseInt(split[1]);
				String[] s2 = split[0].split("[+-]");
				int a = Integer.parseInt(s2[0]);
				int b = Integer.parseInt(s2[1]);
				int res = split[0].contains("+") ? a+b : a-b;
				if(res==ans) ctr++;
			}
		}while(sc.hasNext());
		System.out.println(ctr);
	}
}
