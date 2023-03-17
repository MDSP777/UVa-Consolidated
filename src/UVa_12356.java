import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_12356 {
	static boolean[] alive;
	static int[] left;
	static int[] right;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String[] split = br.readLine().split(" ");
			int s = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			if(s==0 && b==0) break;
			alive = new boolean[s];
			left = new int[s];
			right = new int[s];
			for(int i=1; i<s-1; i++) {
				alive[i] = true;
				left[i] = i-1;
				right[i] = i+1;
			}
			alive[0] = alive[s-1] = true;
			left[0] = -1;
			right[0] = s>=2 ? 1 : -1;
			left[s-1] = s-2;
			right[s-1] = -1;
			for(int i=0; i<b; i++) {
				split = br.readLine().split(" ");
				int l = Integer.parseInt(split[0]);
				int r = Integer.parseInt(split[1]);
				sb.append(process(l-1, r-1)).append("\n");
			}
			sb.append("-").append("\n");
		}
		System.out.print(sb);
	}

	private static String process(int l, int r) {
		int newLeft = getLeft(l);
		int newRight = getRight(r);
		for(int i=l; i<=r; i++) {
			alive[i] = false;
			left[i] = newLeft;
			right[i] = newRight;
		}
		return (newLeft==-1 ? "*" : newLeft+1)+" "+(newRight==-1 ? "*" : newRight+1);
	}

	private static int getLeft(int l) {
		if(l==0) return -1;
		int newLeft = l-1;
		while(newLeft>=0 && !alive[newLeft]) newLeft = left[newLeft];
		return newLeft;
	}
	
	private static int getRight(int r) {
		if(r==alive.length-1) return -1;
		int newRight = r+1;
		while(newRight>=0 && !alive[newRight]) newRight = right[newRight];
		return newRight;
	}
}
