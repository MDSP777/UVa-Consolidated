import java.util.Scanner;

public class UVa_151 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int nRegions = sc.nextInt();
			if(nRegions==0) break;
			System.out.println(solve(nRegions));
		}
	}

	private static int solve(int nRegions) {
		int curOffset = 1;
		while(true) {
			int curIndex = 0;
			boolean[] off = new boolean[nRegions];
			while(!off[12]) {
				off[curIndex] = true;
				if(off[12]) break;
				int jump = 0;
				while(jump!=curOffset) {
					curIndex++;
					curIndex%=nRegions;
					while(off[curIndex]) {
						curIndex++;
						curIndex%=nRegions;
					}
					jump++;
				}
			}
			if(allOff(off)) return curOffset;
			curOffset++;
		}
	}

	private static boolean allOff(boolean[] off) {
		for(int i=0; i<off.length; i++) if(!off[i]) return false;
		return true;
	}
}
