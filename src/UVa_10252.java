import java.util.Scanner;


public class UVa_10252 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		do{
			String a = sc.nextLine();
			String b = sc.nextLine();
			int[] aCount = new int[26];
			int[] bCount = new int[26];
			for(int i=0; i<a.length(); i++) if(a.charAt(i)>='a' && a.charAt(i)<='z') aCount[a.charAt(i)-'a']++;
			for(int i=0; i<b.length(); i++) if(b.charAt(i)>='a' && b.charAt(i)<='z') bCount[b.charAt(i)-'a']++;
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<26; i++)
				if(aCount[i]>0 && bCount[i]>0)
					for(int j=0; j<Math.min(aCount[i], bCount[i]); j++) sb.append((char) (i+'a'));
			System.out.println(sb);
		} while(sc.hasNext());
	}
}
