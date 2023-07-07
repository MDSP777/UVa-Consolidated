import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_375 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			br.readLine();
			String[] split = br.readLine().split(" ");
			double b = Double.parseDouble(split[0]), h = Double.parseDouble(split[1]);
			double total = 0;
			double rad = incircle(b, h);
			double theta = Math.atan(h/(b/2));
			while(rad>=1e-6){
				double d = rad*2;
				total+=d;
				double u = d/Math.tan(theta);
				h-=d;
				b-=u*2;
				rad = incircle(b, h);
			}
			
			sb.append(String.format("%13.6f\n", Math.PI*total));
			if(tc>0) sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static double incircle(double b, double h){
		double hypot = Math.sqrt((b/2)*(b/2)+h*h);
		double s = (b+hypot*2)/2;
		double A = b*h/2;
		return A/s;
	}
}
