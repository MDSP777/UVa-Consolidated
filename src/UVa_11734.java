import java.util.Scanner;


public class UVa_11734 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sc.nextLine();
		for(int t=1; t<=tc; t++){
			String a = sc.nextLine();
			String b = sc.nextLine();
			System.out.print("Case "+t+": ");
			if(a.equals(b)) System.out.println("Yes");
			else{
				a = a.replaceAll(" ", "");
				b = b.replaceAll(" ", "");
				System.out.println(a.equals(b) ? "Output Format Error" : "Wrong Answer");
			}
		}
	}
}
