import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class UVa_10625 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			int r = Integer.parseInt(br.readLine());
			HashMap<Character, char[]> rules = new HashMap<>();
			while(r-->0){
				String[] split = br.readLine().split("->");
				rules.put(split[0].charAt(0), split[1].toCharArray());
			}
			
			int q = Integer.parseInt(br.readLine());
			while(q-->0){
				BigInteger[] f = new BigInteger[200];
				for(int i=0; i<200; i++) f[i] = BigInteger.ZERO;
				String[] split = br.readLine().split(" ");
				char[] start = split[0].toCharArray();
				char check = split[1].charAt(0);
				int l = Integer.parseInt(split[2]);
				
				for(char c : start) f[c] = f[c].add(BigInteger.ONE);
				while(l-->0){
					BigInteger[] adjust = new BigInteger[200];
					for(int i=0; i<200; i++) adjust[i] = BigInteger.ZERO;
					for(char c : rules.keySet()){
						char[] rep = rules.get(c);
						BigInteger curF = f[c];
						f[c] = BigInteger.ZERO;
						for(char x : rep)
							adjust[x] = adjust[x].add(curF);
					}
					for(int i=0; i<200; i++) f[i] = f[i].add(adjust[i]);
				}
				
				System.out.println(f[check]);
			}
		}
	}
}
