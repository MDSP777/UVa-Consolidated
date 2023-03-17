import java.util.Scanner;


public class UVa_10189 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] rOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] cOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};
		int t = 1;
		boolean first = true;
		while(true){
			int r = sc.nextInt();
			int c = sc.nextInt();
			if(r==0 && c==0) break;
			if(first) first = false;
			else System.out.println();
			char[][] grid = new char[r][c];
			for(int i=0; i<r; i++) grid[i] = sc.next().toCharArray();
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++)
					if(grid[i][j]=='.'){
						int ctr = 0;
						for(int k=0; k<8; k++){
							int newR = i+rOffsets[k];
							int newC = j+cOffsets[k];
							if(newR>=0 && newR<r && newC>=0 && newC<c && grid[newR][newC]=='*')
								ctr++;
							grid[i][j] = (char)('0'+ctr);
						}
					}
			System.out.println("Field #"+t+++":");
			for(int i=0; i<r; i++) System.out.println(grid[i]);
		}
	}
}
