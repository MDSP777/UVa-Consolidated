import java.util.HashMap;
import java.util.Scanner;

public class UVa_1583 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> generators = new HashMap<>();
		for(int i=1; i<=100000; i++)
			if(!generators.containsKey(digitSum(i))) generators.put(digitSum(i), i);
		int n = sc.nextInt();
		while(n-->0) {
			int cur = sc.nextInt();
			System.out.println(generators.containsKey(cur) ? generators.get(cur) : "0");
		}
	}
	
	static int digitSum(int x) {
		int total = x;
		while(x>0) {
			total+=x%10;
			x/=10;
		}
		return total;
	}
}
