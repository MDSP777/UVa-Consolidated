import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_737 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			Cube[] cubes = new Cube[n];
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split(" ");
				cubes[i] = new Cube(Integer.parseInt(split[0]), Integer.parseInt(split[1]), 
									Integer.parseInt(split[2]), Integer.parseInt(split[3]));
			}
			int maxX = 100000000;
			int maxY = 100000000;
			int maxZ = 100000000;
			
			int minX = -100000000;
			int minY = -100000000;
			int minZ = -100000000;
			
			for(Cube c : cubes) {
				maxX = Math.min(maxX, c.hx);
				maxY = Math.min(maxY, c.hy);
				maxZ = Math.min(maxZ, c.hz);
				
				minX = Math.max(minX, c.lx);
				minY = Math.max(minY, c.ly);
				minZ = Math.max(minZ, c.lz);
			}
			
			System.out.println(Math.max(0, (maxX-minX)*(maxY-minY)*(maxZ-minZ)));
		}
	}
	
	static class Cube {
		int lx, ly, lz, hx, hy, hz;
		
		Cube(int x, int y, int z, int d){
			lx = x;
			ly = y;
			lz = z;
			hx = x+d;
			hy = y+d;
			hz = z+d;
		}
	}
}
