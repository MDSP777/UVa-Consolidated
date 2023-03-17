import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_10578 {
	static HashMap<String, Boolean> memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		memo = new HashMap<>();
		do{
			String s = sc.next();
			boolean w = win(s);
			String ans = s.length()%2==0 ? (w ? "A" : "B") : (w ? "B" : "A");
			System.out.println(s+" "+ans);
		}while(sc.hasNext());
	}
	
	static boolean win(String cur){
		if(memo.containsKey(cur)) return memo.get(cur);
		boolean win = false;
		int[] rem = new int[7];
		Arrays.fill(rem, 4);
		int sum = 0;
		for(int i=0; i<cur.length(); i++) {
			rem[cur.charAt(i)-'0']--;
			sum+=cur.charAt(i)-'0';
		}
		for(int i=1; !win && i<7; i++)
			if(rem[i]>0 && sum+i<=31) win|=!win(cur+((char)(i+'0')));
		memo.put(cur, win);
		return win;
	}
}
