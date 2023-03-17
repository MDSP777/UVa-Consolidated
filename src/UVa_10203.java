import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_10203 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		br.readLine();
		while(tc-->0) {
			String[] split = br.readLine().split(" ");
			int sx = Integer.parseInt(split[0]);
			int sy = Integer.parseInt(split[1]);
			double total = 0;
			while(true) {
				String s = br.readLine();
				if(s==null || s.isEmpty()) break;
				split = s.split(" ");
				double x1 = Double.parseDouble(split[0])/1000.0;
				double y1 = Double.parseDouble(split[1])/1000.0;
				double x2 = Double.parseDouble(split[2])/1000.0;
				double y2 = Double.parseDouble(split[3])/1000.0;
				total+=Math.sqrt(sq(x1-x2)+sq(y1-y2));
			}
			total*=2;
			long h = (long) total/20;
			total-=20*h;
			total = Math.round(total/20 * 60);
			if(total>=60) {
				h++;
				total-=60;
			}
			System.out.printf("%d:%02.0f", h, total);
			System.out.println();
			if(tc>0) System.out.println();
		}
	}
	
	static double sq(double x) {
		return x*x;
	}
}
