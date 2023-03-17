import java.util.Scanner;

public class UVa_11192 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int g = sc.nextInt();
			if(g==0) break;
			char[] c = sc.next().toCharArray();
			int len = c.length/g;
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<c.length; i+=len) 
				for(int j=i+len-1; j>=i; j--) sb.append(c[j]);
			System.out.println(sb);
		}
	}
}
