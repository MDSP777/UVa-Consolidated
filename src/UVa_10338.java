import java.util.Scanner;

public class UVa_10338 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long[] f = new long[25];
		f[0] = f[1] = 1;
		for(int i=2; i<25; i++) f[i] = i*f[i-1];
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++){
			String s = sc.next();
			int[] count = new int[26];
			for(int i=0; i<s.length(); i++) count[s.charAt(i)-'A']++;
			long ans = f[s.length()];
			for(int i=0; i<26; i++) ans/=f[count[i]];
			System.out.println("Data set "+t+": "+ans);
		}
	}
}
