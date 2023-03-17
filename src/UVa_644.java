import java.util.ArrayList;
import java.util.Scanner;


public class UVa_644 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int c = 1;
		do{
			ArrayList<String> s = new ArrayList<>();
			while(true){
				String x = sc.next();
				if(x.equals("9")) break;
				s.add(x);
			}
			boolean isNotD = false;
			for(int i=0; !isNotD && i<s.size(); i++)
				for(int j=0; !isNotD && j<s.size(); j++)
					if(i!=j && s.get(i).startsWith(s.get(j))) isNotD = true;
			System.out.println("Set "+c+++" is "+(isNotD ? "not " : "")+"immediately decodable");
		}while(sc.hasNext());
	}
}
