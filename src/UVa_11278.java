import java.util.HashMap;
import java.util.Scanner;

public class UVa_11278 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char[] src = {	'`','1','2','3','4','5','6','7','8','9','0','-','=',
						'q','w','e','r','t','y','u','i','o','p','[',']','\\',
						'a','s','d','f','g','h','j','k','l',';','\'',
						'z','x','c','v','b','n','m',',','.','/',
						'~','!','@','#','$','%','^','&','*','(',')','_','+',
						'Q','W','E','R','T','Y','U','I','O','P','{','}','|',
						'A','S','D','F','G','H','J','K','L',':','"',
						'Z','X','C','V','B','N','M','<','>','?',' '};
		char[] dest = { '`','1','2','3','q','j','l','m','f','p','/','[',']',
						'4','5','6','.','o','r','s','u','y','b',';','=','\\',
						'7','8','9','a','e','h','t','d','c','k','-',
						'0','z','x',',','i','n','w','v','g','\'',
						'~','!','@','#','Q','J','L','M','F','P','?','{','}',
						'$','%','^','>','O','R','S','U','Y','B',':','+','|',
						'&','*','(','A','E','H','T','D','C','K','_',
						')','Z','X','<','I','N','W','V','G','"',' '};
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<src.length; i++) map.put(src[i], i);
		do{
			String s = sc.nextLine();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<s.length(); i++) sb.append(dest[map.get(s.charAt(i))]);
			System.out.println(sb);
		}while(sc.hasNext());
	}
}
