import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class UVa_12670 {
	static TreeMap<Long, Integer> pows;
	static HashMap<Long, BigInteger> memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long t = (long) 1e17;
		memo = new HashMap<>();
		pows = new TreeMap<>();
		long x = 1;
		int p = 0;
		while(x<t){
			pows.put(x, p);
			x<<=1;
			p++;
		}
		do{
			long a = sc.nextLong();
			long b = sc.nextLong();
			System.out.println(count(b).subtract(count(a-1)));
		}while(sc.hasNext());
	}
	
	static BigInteger count(long x){
		if(x==0) return BigInteger.ZERO;
		if(x==1) return BigInteger.ONE;
		if(memo.containsKey(x)) return memo.get(x);
		
		BigInteger ans = new BigInteger(""+(pows.floorKey(x)/2)).multiply(new BigInteger(""+log2(x)));
		long right = x%pows.floorKey(x);
		ans = ans.add(count(right)).add(new BigInteger(""+(right+1)));
		memo.put(x, ans);
		return ans;
	}
	
	static int log2(long x){
		return pows.get(pows.floorKey(x));
	}
}
