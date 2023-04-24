import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_12709 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			int bestH = 0, bestV = 0;
			while(n-->0) {
				String[] split = br.readLine().split(" ");
				int l  = Integer.parseInt(split[0]);
				int w  = Integer.parseInt(split[1]);
				int h  = Integer.parseInt(split[2]);
				if(h>bestH) {
					bestH = h;
					bestV = l*w*h;
				} else if(h==bestH) bestV = Math.max(bestV, l*w*h);
			}
			System.out.println(bestV);
		}
	}
}
