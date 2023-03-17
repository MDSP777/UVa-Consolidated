import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class UVa_11319 {
	static BigDecimal OT = new BigDecimal(1000);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int n = 1500;
		while(tc-->0) {
			BigDecimal[] terms = new BigDecimal[n];
			BigDecimal[][] mat = new BigDecimal[7][8];
			for(int i=0; i<7; i++) {
				String s = br.readLine();
				mat[i][7] = new BigDecimal(s);
				terms[i] = new BigDecimal(s);
			}
			for(int i=7; i<n; i++) terms[i] = new BigDecimal(br.readLine());
			br.readLine();
			for(int i=0; i<7; i++) {
				BigDecimal val = BigDecimal.ONE;
				BigDecimal mult = new BigDecimal(i+1);
				for(int j=0; j<7; j++) {
					mat[i][j] = val;
					val = val.multiply(mult);
				}
			}
			
			BigDecimal[] ans = new BigDecimal[7];
			solve(mat, ans);
			boolean hasAns = true;
			for(int i=0; i<7; i++) hasAns&= ans[i].compareTo(OT)<=0 && ans[i].compareTo(BigDecimal.ZERO)>=0;
			for(int i=0; hasAns && i<n; i++) hasAns&=check(ans, terms[i], new BigDecimal(i+1));
			if(hasAns) {
				System.out.print(ans[0].setScale(0, RoundingMode.HALF_UP));
				for(int i=1; i<7; i++) System.out.print(" "+ans[i].setScale(0, RoundingMode.HALF_UP));
				System.out.println();
			} else {
				System.out.println("This is a smart sequence!");
			}
		}
	}
	
	private static boolean check(BigDecimal[] ans, BigDecimal val, BigDecimal x) {
		BigDecimal v = BigDecimal.ZERO;
		BigDecimal xpow = BigDecimal.ONE;
		for(int i=0; i<7; i++) {
			v = v.add(xpow.multiply(ans[i]));
			xpow = xpow.multiply(x);
		}
		return v.compareTo(val)==0;
	}

	static void solve(BigDecimal[][] mat, BigDecimal[] ans) {
		for(int i=0; i<6; i++) {
			BigDecimal maxVal = BigDecimal.ZERO;
			int bestIdx = -1;
			for(int curRow=i; curRow<7; curRow++) {
				// find largest abs value along col i, starting at row i
				BigDecimal cur = mat[curRow][i].abs();
				if(cur.compareTo(maxVal)>0) {
					maxVal = cur;
					bestIdx = curRow;
				}
			}
			if(bestIdx==-1) continue;
			BigDecimal[] temp = mat[i];
			mat[i] = mat[bestIdx];
			mat[bestIdx] = temp;
			
			// zero out every col below i
			for(int curRow=i+1; curRow<7; curRow++) {
				if(mat[curRow][i].compareTo(BigDecimal.ZERO)==0) continue;
				
//				System.out.println(mat[i][i]+"/"+mat[curRow][i]);
				BigDecimal coeff = mat[i][i].divide(mat[curRow][i], 10, RoundingMode.HALF_UP);
				for(int j=i; j<8; j++) mat[curRow][j] = mat[curRow][j].multiply(coeff).subtract(mat[i][j]);
			}
			
//			print(mat);
		}
		for(int i=0; i<7; i++)
			for(int j=0; j<7; j++)
				mat[i][j] = mat[i][j].setScale(0, RoundingMode.HALF_UP);
//		print(mat);
		for(int i=6; i>=0; i--) {
			BigDecimal t = BigDecimal.ZERO;
			for(int j=i+1; j<7; j++) {
				t = t.add(ans[j].multiply(mat[i][j]));
			}
			ans[i] = mat[i][7].subtract(t).divide(mat[i][i], 0, RoundingMode.HALF_UP);
		}
	}
	
//	static void print(BigDecimal[][] mat) {
//		for(int i=0; i<7; i++) {
//			for(int j=0; j<8; j++) {
//				if(mat[i][j].abs().compareTo(eps)<0) mat[i][j] = BigDecimal.ZERO;
//				System.out.print(mat[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("-------------------");
//	}
}
