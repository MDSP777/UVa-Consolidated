import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class UVa_11629 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int g = sc.nextInt();
		HashMap<String, BigDecimal> map = new HashMap<>();
		while(p-->0) map.put(sc.next(), sc.nextBigDecimal());
		sc.nextLine();
		for(int x=1; x<=g; x++) {
			BigDecimal total = BigDecimal.ZERO;
			String[] split = sc.nextLine().split("\\+");
			for(int i=0; i<split.length-1; i++) total = total.add(map.get(split[i].trim()));
			String last = split[split.length-1];
			String[] comps = {">=", "<=", ">", "<", "="};
			for(String s: comps)
				if(last.contains(s)) {
					split = last.split(s);
					total = total.add(map.get(split[0].trim()));
					boolean yes = s.equals(">=") ? total.compareTo(new BigDecimal(split[1].trim())) >= 0 :
										s.equals("<=") ? total.compareTo(new BigDecimal(split[1].trim())) <= 0 :
										s.equals(">") ? total.compareTo(new BigDecimal(split[1].trim())) > 0 :
										s.equals("<") ? total.compareTo(new BigDecimal(split[1].trim())) < 0 :
											total.compareTo(new BigDecimal(split[1].trim()))==0;
					System.out.println("Guess #"+x+" was "+(yes ? "correct" : "incorrect")+".");
					break;
				}
		}
	}
}
