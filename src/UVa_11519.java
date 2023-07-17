import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_11519 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			int n = Integer.parseInt(br.readLine());
			String[][] commands = new String[n][2];
			int qIdx = -1;
			double finalTheta = 0;
			for(int i=0; i<n; i++) {
				String cmd = br.readLine();
				commands[i] = cmd.split(" ");
				if(cmd.contains("?")) qIdx = i;
				else if(commands[i][0].startsWith("l")) {
					finalTheta+=Double.parseDouble(commands[i][1]);
					finalTheta%=360;
				} else if(commands[i][0].startsWith("r")) {
					finalTheta+=360-Double.parseDouble(commands[i][1]);
					finalTheta%=360;	
				}
			}
			
			double curX1 = 0, curY1 = 0;
			double curTheta1 = 0;
			for(int i=0; i<qIdx; i++) {
				if(commands[i][0].startsWith("l")) {
					curTheta1+=Double.parseDouble(commands[i][1]);
					curTheta1%=360;
				} else if(commands[i][0].startsWith("r")) {
					curTheta1+=360-Double.parseDouble(commands[i][1]);
					curTheta1%=360;	
				} else {
					double h = Double.parseDouble(commands[i][1]);
					double xDist = h*Math.cos(Math.toRadians(curTheta1));
					double yDist = h*Math.sin(Math.toRadians(curTheta1));
					if(commands[i][0].startsWith("f")) {
						curX1+=xDist;
						curY1+=yDist;
					} else {
						curX1-=xDist;
						curY1-=yDist;
					}
				}
			}
			
			if(commands[qIdx][0].startsWith("f") || commands[qIdx][0].startsWith("b")) {
				double curX2 = 0, curY2 = 0;
				double curTheta2 = finalTheta;
				for(int i=n-1; i>qIdx; i--) {
					if(commands[i][0].startsWith("r")) {
						curTheta2+=Double.parseDouble(commands[i][1]);
						curTheta2%=360;
					} else if(commands[i][0].startsWith("l")) {
						curTheta2+=360-Double.parseDouble(commands[i][1]);
						curTheta2%=360;	
					} else {
						double h = Double.parseDouble(commands[i][1]);
						double xDist = h*Math.cos(Math.toRadians(curTheta2));
						double yDist = h*Math.sin(Math.toRadians(curTheta2));
						if(commands[i][0].startsWith("b")) {
							curX2+=xDist;
							curY2+=yDist;
						} else {
							curX2-=xDist;
							curY2-=yDist;
						}
					}
				}
				double xDiff = curX1-curX2;
				double yDiff = curY1-curY2;
				sb.append(Math.round(Math.sqrt(xDiff*xDiff + yDiff*yDiff))).append("\n");
			} else {
				for(int adj=0; adj<360; adj++) {
					double curX2 = curX1, curY2 = curY1, curTheta2 = curTheta1;
					if(commands[qIdx][0].startsWith("l")) curTheta2+=adj;
					else curTheta2+=360-adj;
					curTheta2%=360;
					
					for(int i=qIdx+1; i<n; i++) {
						if(commands[i][0].startsWith("l")) {
							curTheta2+=Double.parseDouble(commands[i][1]);
							curTheta2%=360;
						} else if(commands[i][0].startsWith("r")) {
							curTheta2+=360-Double.parseDouble(commands[i][1]);
							curTheta2%=360;	
						} else {
							double h = Double.parseDouble(commands[i][1]);
							double xDist = h*Math.cos(Math.toRadians(curTheta2));
							double yDist = h*Math.sin(Math.toRadians(curTheta2));
							if(commands[i][0].startsWith("f")) {
								curX2+=xDist;
								curY2+=yDist;
							} else {
								curX2-=xDist;
								curY2-=yDist;
							}
						}
					}
					
					if(Math.abs(curX2)<1e-2 && Math.abs(curY2)<1e-2) {
						sb.append(adj).append("\n");
						break;
					}
				}
			}
		}
		System.out.print(sb);
	}
}
