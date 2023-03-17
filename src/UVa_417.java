import java.util.HashMap;
import java.util.Scanner;

public class UVa_417 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();
		int val = 1;
		for(char i='a'; i<='z'; i++) map.put(i+"", val++);
		for(char i='a'; i<='z'; i++) 
			for(char j=(char) (i+1); j<='z'; j++)
				map.put(""+i+j, val++);
		for(char i='a'; i<='z'; i++) 
			for(char j=(char) (i+1); j<='z'; j++)
				for(char k=(char) (j+1); k<='z'; k++)
					map.put(i+""+j+k, val++);
		for(char i='a'; i<='z'; i++) 
			for(char j=(char) (i+1); j<='z'; j++)
				for(char k=(char) (j+1); k<='z'; k++)
					for(char l=(char) (k+1); l<='z'; l++)
						map.put(i+""+j+k+l, val++);
		for(char i='a'; i<='z'; i++) 
			for(char j=(char) (i+1); j<='z'; j++)
				for(char k=(char) (j+1); k<='z'; k++)
					for(char l=(char) (k+1); l<='z'; l++)
						for(char m=(char) (l+1); m<='z'; m++)
							map.put(i+""+j+k+l+m, val++);
		do {
			String s = sc.next();
			System.out.println(map.containsKey(s) ? map.get(s) : "0");
		} while(sc.hasNext());
	}
}
