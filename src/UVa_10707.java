import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class UVa_10707 {
	static int[] rOffsets = {-1, 1, 0, 0};
	static int[] cOffsets = {0, 0, -1, 1};
	static HashMap<String, Integer> ids;
	static HashMap<Integer, Integer> map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()); 
		while(tc-->0){
			String[] split = br.readLine().split(" ");
			int r = Integer.parseInt(split[0]);
			int c = Integer.parseInt(split[1]);
			int n = Integer.parseInt(split[2]);
			split = br.readLine().split(" ");
			char[][] gridA = new char[r][c];
			char[][] gridB = new char[r][c];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) gridA[i][j] = gridB[i][j] = ' ';
			for(int i=0; i<n; i++){
				gridA[Integer.parseInt(split[2*i])][Integer.parseInt(split[2*i+1])] = '*';
			}
			split = br.readLine().split(" ");
			for(int i=0; i<n; i++){
				gridB[Integer.parseInt(split[2*i])][Integer.parseInt(split[2*i+1])] = '*';
			}
			int id = 0;
			ids = new HashMap<>();
			map = new HashMap<>();
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++)
					if(gridA[i][j]=='*'){
						ArrayList<Point> coords = new ArrayList<>();
						fill(i, j, gridA, true, coords);
						flush(coords);
						String base = conv(coords);
						if(ids.containsKey(base)){
							int x = ids.get(base);
							map.put(x, map.get(x)+1);
							continue;
						}
						for(int x=0; x<4; x++){
							ids.put(conv(coords), id);
							reflectR(coords); // reflect 1
							ids.put(conv(coords), id);
							reflectC(coords); // reflect 1+2
							ids.put(conv(coords), id);
							reflectR(coords); // undo reflect 1, keeping reflect 2
							ids.put(conv(coords), id);
							rotateLeft(coords);
						}
						map.put(id, 1);
						id++;
					}
			
			boolean yes = true;
			for(int i=0; yes && i<r; i++)
				for(int j=0; yes && j<c; j++)
					if(gridB[i][j]=='*'){
						ArrayList<Point> coords = new ArrayList<>();
						fill(i, j, gridB, false, coords);
						flush(coords);
						String k = conv(coords);
						if(!ids.containsKey(k)){
							yes = false;
							break;
						}
						int a = ids.get(k);
						map.put(a, map.get(a)-1);
					}
			for(int k : map.keySet()){
				yes&=map.get(k)==0;
			}
			System.out.println(yes ? "YES" : "NO");
		}
	}
	
	static void reflectR(ArrayList<Point> coords){
		for(Point p : coords){
			p.r*=-1;
		}
		flush(coords);
	}
	
	static void reflectC(ArrayList<Point> coords){
		for(Point p : coords){
			p.c*=-1;
		}
		flush(coords);
	}
	
	static String conv(ArrayList<Point> coords){
		StringBuilder sb = new StringBuilder();
		for(Point p: coords)
			sb.append(p.r).append(p.c).append("|");
		return sb.toString();
	}
	
	static void rotateLeft(ArrayList<Point> coords){
		for(Point p : coords){
			int newR = -p.c;
			p.c = p.r;
			p.r = newR;
		}
		flush(coords);
	}
	
	static void flush(ArrayList<Point> coords){
		int minI = 10000000, minJ = 10000000;
		for(Point p : coords){
			minI = Math.min(minI, p.r);
			minJ = Math.min(minJ, p.c);
		}
		for(Point p : coords){
			p.r-=minI;
			p.c-=minJ;
		}
		Collections.sort(coords);
	}
	
	static void fill(int r, int c, char[][] grid, boolean isA, ArrayList<Point> coords){
		grid[r][c] = ' ';
		coords.add(new Point(r, c));
		for(int i=0; i<4; i++){
			int newR = r+rOffsets[i];
			int newC = c+cOffsets[i];
			if(newR>=0 && newR<grid.length && newC>=0 && newC<grid[0].length && grid[newR][newC]=='*'){
				fill(newR, newC, grid, isA, coords);
			}
		}
	}
	
	static class Point implements Comparable<Point>{
		int r, c;
		
		Point(int a, int b){
			r = a;
			c = b;
		}

		@Override
		public int compareTo(Point o) {
			if(r==o.r) return c-o.c;
			return r-o.r;
		}
		
		public String toString(){
			return r+", "+c;
		}
	}
}
