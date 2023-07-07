import java.io.BufferedReader;
import java.io.InputStreamReader;


public class UVa_10573 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			String[] split = br.readLine().split(" ");
			if(split.length==1) {
				double t = Double.parseDouble(split[0]);
				double R = t/2;
				double r = R/2;
				System.out.printf("%.4f\n", Math.PI*R*R - 2*Math.PI*r*r);
			} else {
				double r1 = Double.parseDouble(split[0]);
				double r2 = Double.parseDouble(split[1]);
				double R = r1+r2;
				System.out.printf("%.4f\n", Math.PI*R*R - Math.PI*r1*r1 - Math.PI*r2*r2);
			}
		}
	}
}
