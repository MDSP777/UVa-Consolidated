import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_13215 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			int n = Integer.parseInt(br.readLine());
			double areas = 0;
			double[] p = new double[4];
			String[] split = br.readLine().split(" ");
			double first = Double.parseDouble(split[1]);
			p[0]+=first;
			p[3]+=first;
			areas+=first*first;
			int ctr = 0;
			for(int i=1; i<n; i++) {
				split = br.readLine().split(" ");
				double s = Double.parseDouble(split[1]);
				if(split[0].equals("S")) {
					areas+=s*s;
				} else if(split[0].equals("T")) {
					areas+=area(s);
				} else {
					p[ctr++]+=s;
					areas+=s*s;
				}
				p[ctr]+=s;
			}
			System.out.printf("%.4f\n", Math.max(p[0], p[2])*Math.max(p[1], p[3])-areas);
		}
	}
	
	// area of an equilateral triangle with side length a
	// Heron's Formula
	static double area(double a) {
		double s = 3*a/2;
		return Math.sqrt(s*(s-a)*(s-a)*(s-a));
	}
}
