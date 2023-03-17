import java.util.Arrays;
import java.util.Scanner;

public class UVa_377 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("COWCULATIONS OUTPUT");
		int tc = sc.nextInt();
		while(tc-->0){
			char[] n1 = new char[8];
			char[] n2 = new char[8];
			Arrays.fill(n1, 'V');
			Arrays.fill(n2, 'V');
			char[] s = sc.next().toCharArray();
			for(int i=0; i<5; i++) n1[3+i] = s[i];
			s = sc.next().toCharArray();
			for(int i=0; i<5; i++) n2[3+i] = s[i];
			for(int i=0; i<3; i++){
				String oper = sc.next();
				if(oper.equals("R")){
					for(int j=7; j>=1; j--) n2[j] = n2[j-1];
					n2[0] = 'V';
				} else if(oper.equals("L")){
					for(int j=0; j<7; j++) n2[j] = n2[j+1];
					n2[7] = 'V';
				} else if(oper.equals("A")){
					char[] sum = new char[8];
					Arrays.fill(sum, 'V');
					String a = "", b = "";
					for(int j=0; j<8; j++){
						a+=ch(n1[j]);
						b+=ch(n2[j]);
						int x = Integer.parseInt(a, 4)+Integer.parseInt(b, 4);
						String su = Integer.toString(x, 4);
						for(int k=0; k<su.length(); k++) sum[8-su.length()+k] = rev(su.charAt(k));
					}
					n2 = sum;
				}
			}
			s = sc.next().toCharArray();
			boolean yes = true;
			for(int i=0; yes && i<8; i++) yes&=n2[i]==s[i];
			System.out.println(yes ? "YES" : "NO");
		}
		System.out.println("END OF OUTPUT");
	}

	private static char rev(char c) {
		return c=='0' ? 'V' : c=='1' ? 'U' : c=='2' ? 'C' : 'D';
	}

	private static int ch(char c) {
		return c=='V' ? 0 : c=='U' ? 1 : c=='C' ? 2 : 3;
	}
}
