import java.util.Scanner;

public class UVa_614 {
	static int r, c, startR, startC, endR, endC;
	static boolean[][] hasWall;
	static int[][] dfsPath;
	static int[] rOffsets = {0, -1, 0, 1};
	static int[] cOffsets = {-1, 0, 1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true){
			r = sc.nextInt();
			if(r==0) break;
			c = sc.nextInt();
			startR = sc.nextInt()-1;
			startC = sc.nextInt()-1;
			endR = sc.nextInt()-1;
			endC = sc.nextInt()-1;
			hasWall = new boolean[150][150];
			
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++){
					int idx = convert(i, j);
					int downIdx = convert(i+1, j);
					int rightIdx = convert(i, j+1);
					int w = sc.nextInt();
					if(w==1 && j<c-1) {
						hasWall[idx][rightIdx] = hasWall[rightIdx][idx] = true;
					} else if(w==2 && i<r-1){
						hasWall[idx][downIdx] = hasWall[downIdx][idx] = true;
					} else if(w==3){
						if(j<c-1) hasWall[idx][rightIdx] = hasWall[rightIdx][idx] = true;
						if(i<r-1) hasWall[idx][downIdx] = hasWall[downIdx][idx] = true;
					}
				}
			
			dfsPath = new int[r][c];
			dfs(startR, startC, 1);
			System.out.println("Maze "+tc+++"\n");
			
			StringBuilder topWall = new StringBuilder("+");
			for(int i=0; i<c; i++) topWall.append("---+");
			System.out.println(topWall);
			for(int i=0; i<r; i++){
				StringBuilder sb = new StringBuilder("|");
				StringBuilder sb2 = new StringBuilder("+");
				for(int j=0; j<c; j++){
					if(dfsPath[i][j]==0) sb.append("   ");
					else if(dfsPath[i][j]==-1) sb.append("???");
					else sb.append(String.format("%3s", dfsPath[i][j]));
					
					int cur = convert(i, j);
					int right = convert(i, j+1);
					int down = convert(i+1, j);
					if(j==c-1 || hasWall[cur][right]) sb.append("|");
					else sb.append(" ");
					
					if(i==r-1 || hasWall[cur][down]) sb2.append("---+");
					else sb2.append("   +");
				}
				System.out.println(sb);
				System.out.println(sb2);
			}
			System.out.println("\n");
		}
	}
	
	static boolean dfs(int curR, int curC, int depth){
		dfsPath[curR][curC] = depth;
		if(curR==endR && curC==endC) return true;
		int convCur = convert(curR, curC);
		for(int i=0; i<4; i++){
			int newR = curR+rOffsets[i];
			int newC = curC+cOffsets[i];
			if(newR>=0 && newR<r && newC>=0 && newC<c){
				int convNew = convert(newR, newC);
				if(!hasWall[convCur][convNew] && dfsPath[newR][newC]==0){
					boolean foundPath = dfs(newR, newC, depth+1);
					if(foundPath) return true;
					dfsPath[newR][newC] = -1;
				}
			}
		}
		return false;
	}
	
	static int convert(int i, int j){
		return c*i+j;
	}
}
