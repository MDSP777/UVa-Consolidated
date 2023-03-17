import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class UVa_1200 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			String s = br.readLine();
			String[] split = s.split("=");
			String[] left = split[0].split("[+-]");
			String[] right = split[1].split("[+-]");
			BitSet leftPos = new BitSet();
			BitSet rightPos = new BitSet();
			if(!split[0].startsWith("-")) leftPos.set(0);
			if(!split[1].startsWith("-")) rightPos.set(0);
			char[] leftSigns = split[0].replaceAll("[^+-]", "").toCharArray();
			char[] rightSigns = split[1].replaceAll("[^+-]", "").toCharArray();
			for(int i=0; i<leftSigns.length; i++) if(leftSigns[i]=='+') leftPos.set(i+1);
			for(int i=0; i<rightSigns.length; i++) if(rightSigns[i]=='+') rightPos.set(i+1);
			int xCoeffs = 0;
			int constants = 0;			
			for(int i=0; i<left.length; i++) {
				boolean hasX = left[i].contains("x");
				int coeff = Integer.parseInt(left[i].equals("x") ? "1" : hasX ? left[i].replaceAll("x", "") : left[i]) * (leftPos.get(i) ? 1 : -1);
				if(hasX) xCoeffs+=coeff;
				else constants+=-coeff;
			}
			for(int i=0; i<right.length; i++) {
				boolean hasX = right[i].contains("x");
				int coeff = Integer.parseInt(right[i].equals("x") ? "1" : hasX ? right[i].replaceAll("x", "") : right[i]) * (rightPos.get(i) ? 1 : -1);
				if(hasX) xCoeffs+=-coeff;
				else constants+=coeff;
			}
			if(xCoeffs==0 && constants==0) System.out.println("IDENTITY");
			else if(xCoeffs==0) System.out.println("IMPOSSIBLE");
			else {
				int ans = constants/xCoeffs;
				double actualVal = constants*1.0/xCoeffs;
				if(ans<0 && actualVal!=ans) ans--;
				System.out.println(ans);
			}
		}
	}
}
