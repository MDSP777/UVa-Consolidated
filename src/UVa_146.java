import java.util.Arrays;
import java.util.Scanner;

public class UVa_146 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String s = sc.next();
			if(s.equals("#")) break;
			int lastIncrease = -1;
			for(int i=1; i<s.length(); i++) if(s.charAt(i-1)<s.charAt(i)) lastIncrease = i-1;
			if(lastIncrease==-1) System.out.println("No Successor");
			else {
				String right = s.substring(lastIncrease);
				int nextLarger = 1;
				for(int i=1; i<right.length(); i++)
					if(right.charAt(i)>right.charAt(0) && right.charAt(i)<right.charAt(nextLarger)) nextLarger = i;
				char newStart = right.charAt(nextLarger);
				String out = sort(right.substring(0, nextLarger)+right.substring(nextLarger+1));
				System.out.println(s.substring(0, lastIncrease)+newStart+out);
			}
		}
	}

	private static String sort(String string) {
		char[] arr = string.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}
