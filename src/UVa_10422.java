import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;


public class UVa_10422 {
	static char[][] goal = {{'1','1','1','1','1'},
							{'0','1','1','1','1'},
						    {'0','0','X','1','1'},
							{'0','0','0','0','1'},
							{'0','0','0','0','0'}};
	static int[] rOffsets = {-1,-2,-2,-1,1,2,2,1};
	static int[] cOffsets = {-2,-1,1,2,-2,-1,1,2};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0){
			char[][] grid = new char[5][5];
			for(int i=0; i<5; i++) grid[i] = br.readLine().replace(' ', 'X').toCharArray();
			int dist = -1;
			LinkedList<State> q = new LinkedList<>();
			HashSet<String> visited = new HashSet<>();
			q.add(new State(grid, 0));
			visited.add(toString(grid));
			while(!q.isEmpty()){
				State cur = q.poll();
				if(isFinal(cur.grid)){
					dist = cur.depth;
					break;
				}
				if(cur.depth<10){
					int rFree = -1, cFree = -1;
					for(int i=0; i<5 && rFree==-1; i++)
						for(int j=0; j<5; j++) 
							if(cur.grid[i][j]=='X'){
								rFree = i;
								cFree = j;
							}
					for(int i=0; i<8; i++){
						int newR = rFree+rOffsets[i];
						int newC = cFree+cOffsets[i];
						if(newR>=0 && newR<5 && newC>=0 && newC<5){
							char[][] newGrid = new char[5][5];
							for(int x=0; x<5; x++)
								for(int y=0; y<5; y++) newGrid[x][y] = cur.grid[x][y];
							newGrid[rFree][cFree] = newGrid[newR][newC];
							newGrid[newR][newC] = 'X';
							String s = toString(newGrid);
							if(!visited.contains(s)){
								visited.add(s);
								q.add(new State(newGrid, cur.depth+1));
							}
						}
					}
				}
			}
			System.out.println(dist==-1 ? "Unsolvable in less than 11 move(s)." : "Solvable in "+dist+" move(s).");
		}
	}
	
	static boolean isFinal(char[][] grid){
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++) if(grid[i][j]!=goal[i][j]) return false;
		return true;
	}
	
	static String toString(char[][] grid){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++) sb.append(grid[i][j]);
		return sb.toString();
	}
	
	static class State{
		char[][] grid;
		int depth;
		
		public State(char[][] g, int d){
			grid = g;
			depth = d;
		}
	}
}
