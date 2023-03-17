import java.util.Scanner;


public class UVa_325 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			String s = sc.nextLine().trim();
			if(s.equals("*")) break;
			System.out.println(s+" is "+(isLegal(s) ? "legal." : "illegal."));
		}
	}
	
	static boolean isLegal(String s){
		String a = "^[+-]?[0-9]+\\.[0-9]+$";
		String b = "^[+-]?[0-9]+[eE][+-]?[0-9]+$";
		String c = "^[+-]?[0-9]+\\.[0-9]+[eE][+-]?[0-9]+?$";
		if(s.matches(a) || s.matches(b) || s.matches(c)) return true;
		return false;
	}
}
