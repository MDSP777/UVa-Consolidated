import java.util.Scanner;

public class UVa_300 {
	static String[] inYear = {"pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin", "mol", "chen", "yax", "zac", "ceh", "mac", "kankin", "muan", "pax",
		"koyab", "cumhu", "uayet"};
	static String[] outYear = {"imix", "ik", "akbal", "kan", "chicchan",
"cimi", "manik", "lamat", "muluk", "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		System.out.println(tc);
		while(tc-->0){
			String t = sc.next();
			int d1 = Integer.parseInt(t.substring(0, t.length()-1));
			int m1 = find(sc.next());
			int y1 = sc.nextInt();
			int num = y1*365 + 20*m1 + d1;
			
			int y2 = num/260;
			int rem = num%260;
			int d2 = rem%20;
//			System.out.println(num);
//			System.out.println(rem);
			System.out.println((rem%13+1)+" "+outYear[d2]+" "+y2);
		}
	}
	
	static int find(String m){
		for(int i=0; i<inYear.length; i++)
			if(inYear[i].equals(m)) return i;
		return -10000;
	}
}
