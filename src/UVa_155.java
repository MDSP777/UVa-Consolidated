import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_155 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] split = br.readLine().split(" ");
			int k = Integer.parseInt(split[0]);
			Point t = new Point(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
			if(k==0 && t.x==0 && t.y==0) break;
			
			int total = 0;
			Point c = new Point(1024, 1024);
			while(k>0) {
				Point UL = new Point(c.x-k, c.y-k), BR = new Point(c.x+k, c.y+k),
					  UR = new Point(c.x+k, c.y-k), BL = new Point(c.x-k, c.y+k);
				if(UL.x<=t.x && t.x<=BR.x && UL.y<=t.y && t.y<=BR.y) total++;
				if(t.x==c.x || t.y==c.y) break;
				
				if(t.x<c.x && t.y<c.y) c = UL;
				else if(t.x<c.x && t.y>c.y) c = BL;
				else if(t.x>c.x && t.y>c.y) c = BR;
				else c = UR;
				k/=2;
			}
			System.out.printf("%3d\n", total);
		}
	}
	
	static class Point {
		int x, y;
		
		Point(int a, int b){
			x = a;
			y = b;
		}
	}
}
