import java.util.Scanner;

public class UVa_11157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		for(int curCase=1; curCase<=nC; curCase++) {
			int nRocks = sc.nextInt();
			int d = sc.nextInt();
			int largestLeap = 0;
			if(nRocks==0) largestLeap = d;
			else {
				int[] rockVals = new int[nRocks];
				char[] rockTypes = new char[nRocks];
				boolean[] used = new boolean[nRocks];
				for(int i=0; i<nRocks; i++) {
					String[] split = sc.next().split("-");
					rockTypes[i] = split[0].charAt(0);
					rockVals[i] = Integer.parseInt(split[1]);
				}
				int cur = 0;
				for(int i=0; i<nRocks; i++) {
					if(i==0) {
						largestLeap = rockVals[i];
						if(rockTypes[i]=='S') used[i] = true;
						cur = i;
					}
					else {
						if(rockTypes[i]=='B' || !(rockTypes[i]=='S' && cur==i-1 && rockTypes[cur]=='S')) {
							largestLeap = Math.max(largestLeap, rockVals[i]-rockVals[cur]);
							if(rockTypes[i]=='S') used[i] = true;
							cur = i;
						}
					}
				}
				largestLeap = Math.max(largestLeap, d-rockVals[cur]);
				cur = d;
				for(int i=nRocks-1; i>=0; i--) {
					if(!used[i]) {
						largestLeap = Math.max(largestLeap, cur-rockVals[i]);
						cur = rockVals[i];
					}
				}
				largestLeap = Math.max(largestLeap, cur);
			}
			System.out.println("Case "+curCase+": "+largestLeap);
		}
	}
}
