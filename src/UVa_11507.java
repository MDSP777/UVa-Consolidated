import java.util.Scanner;

public class UVa_11507 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0) break;
			n--;
			String curDir = "+x";
			for(int i=0; i<n; i++) {
				String s = sc.next();
				if(!s.equals("No")) curDir = rotate(curDir, s);
			}
			System.out.println(curDir);
		}
	}

	private static String rotate(String curDir, String next) {
		if(curDir.equals("+x")) return next;
		if(curDir.equals("-x")) return next.contains("+") ? "-"+next.charAt(1) : "+"+next.charAt(1);
		if(curDir.contains("y")) {
			if(next.contains("y")) {
				if(curDir.contains("+")) return next.contains("+") ? "-x" : "+x";
				else return next.charAt(0)+"x";
			}
			else return curDir;
		} else {
			if(next.contains("y")) return curDir;
			if(next.equals("-x")) return curDir.contains("+") ? "-z" : "+z";
			if(curDir.contains("+")) return next.contains("+") ? "-x" : "+x";
			else return next.charAt(0)+"x";
		}
	}
}
