import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_10221 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			
			String[] split = s.split(" ");
			int r = 6440+Integer.parseInt(split[0]);
			double theta = Integer.parseInt(split[1]);
			if(split[2].startsWith("m")) theta/=60;
			theta*=Math.PI/180;
			theta%=2*Math.PI;
			theta = Math.min(theta, 2*Math.PI-theta);
			
			double a = r*theta;
			double ch = Math.sqrt(2*r*r*(1-Math.cos(theta)));
			System.out.printf("%.6f %.6f\n", a, ch);
		}
	}
}
