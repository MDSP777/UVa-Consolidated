import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_11505 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			int n = Integer.parseInt(br.readLine());
			double curX = 0, curY = 0;
			double curTheta = 0;
			while(n-->0) {
				String[] split = br.readLine().split(" ");
				if(split[0].startsWith("l")) {
					curTheta+=Double.parseDouble(split[1]);
					curTheta%=360;
				} else if(split[0].startsWith("r")) {
					curTheta+=360-Double.parseDouble(split[1]);
					curTheta%=360;	
				} else {
					double h = Double.parseDouble(split[1]);
					double xDist = h*Math.cos(Math.toRadians(curTheta));
					double yDist = h*Math.sin(Math.toRadians(curTheta));
					if(split[0].startsWith("f")) {
						curX+=xDist;
						curY+=yDist;
					} else {
						curX-=xDist;
						curY-=yDist;
					}
				}
			}
			System.out.println(Math.round(Math.sqrt(curX*curX+curY*curY)));
		}
	}
}
