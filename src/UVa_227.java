import java.util.Scanner;


public class UVa_227 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = 1;
		boolean first = true;
		while(true){
			String s = sc.nextLine();
			if(s.length()==4) s+=" ";
			if(s.equals("Z")) break;
			if(first) first = false;
			else System.out.println();
			
			char[][] grid = new char[5][];
			grid[0] = s.toCharArray();
			for(int i=1; i<5; i++) {
				s = sc.nextLine();
				if(s.length()==4) s+=" ";
				grid[i] = s.toCharArray();
			}
			int r = 0, c = 0;
			for(int i=0; i<5; i++)
				for(int j=0; j<5; j++) 
					if(grid[i][j]==' '){
						r = i;
						c = j;
					}
			boolean valid = true;
			while(true){
				s = sc.nextLine();
				boolean shouldBreak = s.endsWith("0");
				char[] moves = s.toCharArray();
				for(int i=0; valid && i<moves.length; i++){
					if(moves[i]=='A'){
						if(r==0) valid = false;
						else {
							grid[r][c] = grid[r-1][c];
							grid[r-1][c] = ' ';
							r--;
						}
					} else if(moves[i]=='B'){
						if(r==4) valid = false;
						else {
							grid[r][c] = grid[r+1][c];
							grid[r+1][c] = ' ';
							r++;
						}
					} else if(moves[i]=='L'){
						if(c==0) valid = false;
						else {
							grid[r][c] = grid[r][c-1];
							grid[r][c-1] = ' ';
							c--;
						}
					} else if(moves[i]=='R'){
						if(c==4) valid = false;
						else {
							grid[r][c] = grid[r][c+1];
							grid[r][c+1] = ' ';
							c++;
						}
					}
				}
				if(shouldBreak) break;
			}
			System.out.println("Puzzle #"+p+++":");
			if(valid) {
				for(int i=0; i<5; i++){
					System.out.print(grid[i][0]);
					for(int j=1; j<5; j++) System.out.print(" "+grid[i][j]);
					System.out.println();
				}
			} else System.out.println("This puzzle has no final configuration.");
		}
	}
}
