import java.util.Scanner;


public class UVa_12700 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		for(int q=1; q<=tc; q++){
			int b = 0, w = 0, t = 0, a = 0;
			int n = sc.nextInt();
			char[] str = sc.next().toCharArray();
			for(char c : str)
				if(c=='B')
					b++;
				else if(c=='W')
					w++;
				else if(c=='T')
					t++;
				else
					a++;
			
			String ans = "";
			if(a==n)
				ans = "ABANDONED";
			else if(b+a==n)
				ans = "BANGLAWASH";
			else if(w+a==n)
				ans = "WHITEWASH";
			else if(w==b)
				ans = "DRAW "+w+" "+t;
			else if(b>w)
				ans = "BANGLADESH "+b+" - "+w;
			else
				ans = "WWW "+w+" - "+b;
			
			sb.append(String.format("Case %d: %s\n", q, ans));
		}
		System.out.print(sb);
	}
}
