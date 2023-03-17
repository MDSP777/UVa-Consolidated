import java.util.Scanner;

public class UVa_255 {
	static int kRow;
	static int kCol;
	static int qRow;
	static int qCol;
	static int mRow;
	static int mCol;
	static int[] rOffsets = {0, 0, -1, 1};
	static int[] cOffsets = {-1, 1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a==b) System.out.println("Illegal state");
			else {
				kRow = a/8;
				kCol = a%8;
				qRow = b/8;
				qCol = b%8;
				mRow = c/8;
				mCol = c%8;
				if(illegal()) System.out.println("Illegal move");
				else if(notAllowed()) System.out.println("Move not allowed");
				else System.out.println(noMove() ? "Stop" : "Continue");
			}
		}while(sc.hasNext());
	}
	
	static boolean illegal() {
		if(qRow!=mRow && qCol!=mCol) return true;
		if(qRow==mRow && qCol==mCol) return true;
		if(qRow==mRow) {
			while(qCol!=mCol) {
				if(qCol<mCol) qCol++;
				else qCol--;
				if(qCol==kCol && qRow==kRow) return true;
			}
			return false;
		} else {
			while(qRow!=mRow) {
				if(qRow<mRow) qRow++;
				else qRow--;
				if(qRow==kRow && qCol==kCol) return true;
			}
			return false;
		}
	}
	
	static boolean notAllowed() {
		if(kRow!=mRow && kCol!=mCol) return false;
		if(kRow==mRow) return mCol==kCol-1 || mCol==kCol+1;
		else return mRow==kRow-1 || mRow==kRow+1;
	}
	
	static boolean noMove() {
		for(int i=0; i<4; i++) {
			int nRow = kRow+rOffsets[i];
			int nCol = kCol+cOffsets[i];
			if(nRow>=0 && nRow<8 && nCol>=0 && nCol<8 && nRow!=mRow && nCol!=mCol) return false;
		}
		return true;
	}
}
