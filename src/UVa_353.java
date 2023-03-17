import java.util.HashMap;
import java.util.Scanner;

public class UVa_353 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			String s = sc.next();
			System.out.println("The string '"+s+"' contains "+unique(s)+" palindromes.");
		}while(sc.hasNext());
	}

	private static int unique(String s) {
		HashMap<String, Boolean> map = new HashMap<>();
		for(int i=0; i<s.length(); i++)
			for(int j=i+1; j<=s.length(); j++) {
				String key = s.substring(i, j);
				if(key.equals(new StringBuilder(key).reverse().toString()))
					if(!map.containsKey(key)) map.put(key, true);
			}
		return map.size();
	}
}
