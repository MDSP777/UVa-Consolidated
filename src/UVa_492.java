import java.io.BufferedReader;
import java.io.InputStreamReader;


public class UVa_492  {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder word = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		while(true){
			int st = br.read();
			if(st==-1) break;
			char s = (char) st;
			if(isLetter(s)){
				word.append(s);
			} else {
				if(word.length()>0){
					if(isVowel(word.charAt(0))) sb.append(word).append("ay");
					else sb.append(word.substring(1)).append(word.charAt(0)).append("ay");
					word = new StringBuilder();
				}
				sb.append(s);
			}
			
		}
		if(word.length()>0){
			if(isVowel(word.charAt(0))) sb.append(word).append("ay");
			else sb.append(word.substring(1)).append(word.charAt(0)).append("ay");
		}
		System.out.print(sb);
	}

	private static boolean isVowel(char c) {
		return c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' || c=='u' || c=='U';
	}

	private static boolean isLetter(char c) {
		return (c>='A' && c<='Z') || (c>='a' && c<='z');
	}
}
