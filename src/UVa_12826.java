import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class UVa_12826 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] rOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] cOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};
		int t = 1;
		while(true){
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			String[] split = s.split(" ");
			int sR = Integer.parseInt(split[0])-1;
			int sC = Integer.parseInt(split[1])-1;
			int tR = Integer.parseInt(split[2])-1;
			int tC = Integer.parseInt(split[3])-1;
			int xR = Integer.parseInt(split[4])-1;
			int xC = Integer.parseInt(split[5])-1;
			
			LinkedList<State> q = new LinkedList<>();
			boolean[][] visited = new boolean[8][8];
			visited[sR][sC] = visited[xR][xC] = true;
			q.add(new State(sR, sC, 0));
			int ans = 0;
			while(ans==0 && !q.isEmpty()){
				State cur = q.poll();
				for(int i=0; i<8; i++){
					int newR = cur.r+rOffsets[i];
					int newC = cur.c+cOffsets[i];
					if(newR>=0 && newR<8 && newC>=0 && newC<8){
						if(newR==tR && newC==tC){
							ans = cur.depth+1;
							break;
						}
						if(!visited[newR][newC]){
							visited[newR][newC] = true;
							q.add(new State(newR, newC, cur.depth+1));
						}
					}
				}
			}
			System.out.println("Case "+t+++": "+ans);
		}
	}
	
	static class State {
		int r, c, depth;
		
		State(int a, int b, int d){
			r = a;
			c = b;
			depth = d;
		}
	}
}
