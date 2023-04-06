import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class UVa_1019 {
	static char[] src, dest;
	static char[] config;
	static int[][] memo;
	// note: Java 9 onwards has BigInteger.TWO constant, but UVa judge compiler uses Java 8
	// using BigInteger.TWO will result in CPE
	static BigInteger TWO = new BigInteger("2");
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while(true) {
			String[] split = br.readLine().split(" ");
			if(split[0].equals("0") && split[1].equals("0")) break;
			if(tc>1) System.out.println();
			
			StringBuilder sb1 = convert(new BigInteger(split[0]));
			StringBuilder sb2 = convert(new BigInteger(split[1]));
			
			if(sb1.length() < sb2.length()) {
				while(sb1.length() < sb2.length()) {
					sb1.append("0");
				}
			} else if(sb2.length() < sb1.length()) {
				while(sb2.length() < sb1.length()) {
					sb2.append("0");
				}
			}
			
			src = sb1.reverse().toString().toCharArray();
			dest = sb2.reverse().toString().toCharArray();

			if(src.length==1) {
				System.out.println("Case Number "+tc+++": "+Math.abs(src[0]-dest[0]));
				continue;
			}
			
			config = new char[src.length];
			memo = new int[src.length][8];
			for(int i=0; i<src.length; i++)
				Arrays.fill(memo[i], -1);
			if(dp(0, convert(0, 1))) System.out.println("Case Number "+tc+++": "+toDecimal());
			else System.out.println("Case Number "+tc+++": impossible");
		}
	}
	
	static boolean dp(int index, int state) {
		if(index==src.length-1) {
			char left = (char) ('0'+state/2);
			char cur = (char) ('0'+state%2);
			if(areOpposite(left, dest[index-1]) && areOpposite(cur, dest[index])) {
				config[index] = '1';
				return true;
			} else if(left==dest[index-1] && cur==dest[index]) {
				return true;
			} else return false;
		}
		if(memo[index][state]!=-1) return memo[index][state]==1;
		
		boolean can = false;
		if(index==0) {
			char left = (char) ('0'+state/2);
			char cur = (char) ('0'+state%2);
			
			// no press
			int nextState = state;
			if(src.length>2) nextState = (state<<1) + src[2]-'0';
			can |= dp(1, nextState);
			if(can) return true;
			
			// try press
			nextState = (('1'-left)<<1) + '1'-cur;
			if(src.length>2) nextState = (nextState<<1) + src[2]-'0';
			config[index] = '1';
			can |= dp(1, nextState);
			if(can) return true;
			config[index] = '0';
		} else {
			char left = (char) ('0'+state/4);
			char cur = (char) ('0'+state%4/2);
			char right = (char) ('0'+state%2);
			
			// must press
			if(areOpposite(left, dest[index-1])) {
				int nextState = (('1'-cur)<<1) + '1'-right;
				config[index] = '1';
				if(index+1 < src.length-1) nextState = (nextState<<1) + src[index+2]-'0';
				can |= dp(index+1, nextState);
				if(can) return true;
				config[index] = '0';
			} else { // must not press
				int nextState = state%4;
				if(index+1 < src.length-1) nextState = (nextState<<1) + src[index+2]-'0';
				can |= dp(index+1, nextState);
				if(can) return true;
			}
		}
		
		memo[index][state] = can ? 1 : 0;
		return can;
	}
	
	static boolean areOpposite(char a, char b) {
		return Math.abs(a-b)==1;
	}
	
	static BigInteger toDecimal() {
		BigInteger ans = BigInteger.ZERO;
		for(int i=0; i<config.length; i++) {
			ans = ans.multiply(TWO);
			if(config[i]=='1') ans = ans.add(BigInteger.ONE);
		}
		return ans;
	}
	
	static int convert(int u, int v) {
		int ans = 0;
		for(int i=u; i<=v; i++) {
			ans<<=1;
			if(src[i]=='1') ans++;
		}
		return ans;
	}
	
	static StringBuilder convert(BigInteger b) {
		StringBuilder sb = new StringBuilder();
		if(b.equals(BigInteger.ZERO)) sb.append("0");
		while(!b.equals(BigInteger.ZERO)) {
			sb.append(b.mod(TWO));
			b = b.divide(TWO);
		}
		return sb;
	}
}
