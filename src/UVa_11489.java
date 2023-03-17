import java.util.Scanner;

public class UVa_11489 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++){
			char[] s = sc.next().toCharArray();
			int digitSum = 0;
			int[] mods = new int[3];
			for(int i=0; i<s.length; i++){
				digitSum+=s[i]-'0';
				mods[(s[i]-'0')%3]++;
			}
			System.out.print("Case "+t+": ");
			if(digitSum%3==0) System.out.println(mods[0]%2==1 ? "S" : "T");
			else System.out.println(mods[digitSum%3]>0 ? (mods[0]%2==1 ? "T" : "S") : "T");
		}
	}
}
