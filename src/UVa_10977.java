import java.util.LinkedList;
import java.util.Scanner;

public class UVa_10977 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] rOffsets = {-1, 0, 0, 1};
		int[] cOffsets = {0, -1, 1, 0};
		while(true){
			int r = sc.nextInt();
			int c = sc.nextInt();
			if(r==0 && c==0) break;
			int n = sc.nextInt();
			boolean[][] valid = new boolean[r][c];
			boolean[][] visited = new boolean[r][c];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) valid[i][j] = true;
			while(n-->0){
				valid[sc.nextInt()-1][sc.nextInt()-1] = false;
			}
			int m = sc.nextInt();
			while(m-->0){
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				int d = sc.nextInt();
				for(int i=0; i<r; i++)
					for(int j=0; j<c; j++) visited[i][j] = false;
				LinkedList<Node> q = new LinkedList<>();
				q.add(new Node(a, b, 0));
				visited[a][b] = true;
				while(!q.isEmpty()){
					Node cur = q.poll();
					valid[cur.r][cur.c] = false;
					for(int i=0; i<4; i++){
						int newR = cur.r+rOffsets[i];
						int newC = cur.c+cOffsets[i];
						if(newR>=0 && newR<r && newC>=0 && newC<c && !visited[newR][newC] && dist(newR-a, newC-b)<=d*1.0){
							visited[newR][newC] = true;
							q.add(new Node(newR, newC, cur.depth+1));
						}
					}
				}
			}
//			for(int i=0; i<r; i++){
//				for(int j=0; j<c; j++) System.out.print(valid[i][j] ? 1 : 0);
//				System.out.println();
//			}
			int ans = -1;
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) visited[i][j] = false;
			LinkedList<Node> q = new LinkedList<>();
			if(valid[0][0]) {
				q.add(new Node(0, 0, 0));
				visited[0][0] = true;
			}
			while(!q.isEmpty()){
				Node cur = q.poll();
				if(cur.r==r-1 && cur.c==c-1){
					ans = cur.depth;
					break;
				}
				for(int i=0; i<4; i++){
					int newR = cur.r+rOffsets[i];
					int newC = cur.c+cOffsets[i];
					if(newR>=0 && newR<r && newC>=0 && newC<c && !visited[newR][newC] && valid[newR][newC]){
						visited[newR][newC] = true;
						q.add(new Node(newR, newC, cur.depth+1));
					}
				}
			}
			System.out.println(ans==-1 ? "Impossible." : ans);
		}
	}
	
	static double dist(int a, int b){
		return Math.sqrt(a*a+b*b);
	}
	
	static class Node{
		int r;
		int c;
		int depth;
		
		public Node(int a, int b, int d){
			r = a;
			c = b;
			depth = d;
		}
	}
}
