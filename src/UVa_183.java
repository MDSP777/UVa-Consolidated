import java.util.Scanner;


public class UVa_183 {
	static int dIdx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = "NONE";
		while(true){
			String[] split = temp.split("\\s+");
			String key = temp.equals("NONE") ? sc.next() : split[0];
			if(key.equals("#")) break;
			int r = temp.equals("NONE") ? sc.nextInt() : Integer.parseInt(split[1]);
			int c = temp.equals("NONE") ? sc.nextInt() : Integer.parseInt(split[2]);
			String s = sc.next();
			String head = "";
			for(int i=(r+"").length(); i<4; i++) head+=" ";
			head+=r;
			for(int i=(c+"").length(); i<4; i++) head+=" ";
			head+=c;
			char[][] grid = new char[r][c];
			if(key.equals("B")){
				temp = "NONE";
				while(s.length()<r*c) s += sc.next();
				for(int i=0; i<r; i++)
					for(int j=0; j<c; j++) grid[i][j] = s.charAt(i*c+j);
				System.out.println("D"+head);
				String ans = encrypt(grid, 0, 0, r, c);
				int ctr = 0;
				for(int i=0; i<ans.length(); i++){
					System.out.print(ans.charAt(i));
					ctr++;
					if(ctr%50==0) System.out.println();
				}
				if(ctr%50!=0) System.out.println();
			} else {
				sc.nextLine();
				while(true){
					String x = sc.nextLine();
					if(x.contains(" ") || x.contains("#")){
						temp = x;
						break;
					}
				}
				dIdx = 0;
				decrypt(grid, s, 0, 0, r, c);
				System.out.println("B"+head);
				int ctr = 0;
				for(int i=0; i<r; i++) 
					for(int j=0; j<c; j++){
						System.out.print(grid[i][j]);
						ctr++;
						if(ctr%50==0) System.out.println();
					}
				if(ctr%50!=0) System.out.println();
			}
		}
	}
	
	static String encrypt(char[][] grid, int i1, int j1, int i2, int j2){
		boolean allSame = true;
		for(int i=i1; allSame && i<i2; i++)
			for(int j=j1; allSame && j<j2; j++) allSame&=grid[i][j]==grid[i1][j1];
		if(allSame) return grid[i1][j1]+"";
		int r = i2-i1;
		int c = j2-j1;
		int midR = i1+(i2-i1)/2;
		int midC = j1+(j2-j1)/2;
		if((r&1)==1) midR++;
		if((c&1)==1) midC++;
		if(r==1) return "D"+encrypt(grid, i1, j1, i2, midC)+encrypt(grid, i1, midC, i2, j2);
		if(c==1) return "D"+encrypt(grid, i1, j1, midR, j2)+encrypt(grid, midR, j1, i2, j2);
		
		return "D"+encrypt(grid, i1, j1, midR, midC)
				+encrypt(grid, i1, midC, midR, j2)
				+encrypt(grid, midR, j1, i2, midC)
				+encrypt(grid, midR, midC, i2, j2);
		
	}
	
	static void decrypt(char[][] grid, String s, int i1, int j1, int i2, int j2){
		if(s.charAt(dIdx)!='D'){
			for(int i=i1; i<i2; i++)
				for(int j=j1; j<j2; j++) grid[i][j] = s.charAt(dIdx);
			dIdx++;
			return;
		}
		dIdx++;
		int r = i2-i1;
		int c = j2-j1;
		int midR = i1+(i2-i1)/2;
		int midC = j1+(j2-j1)/2;
		if((r&1)==1) midR++;
		if((c&1)==1) midC++;
		if(r==1) {
			decrypt(grid, s, i1, j1, i2, midC);
			decrypt(grid, s, i1, midC, i2, j2);
			return;
		}
		if(c==1) {
			decrypt(grid, s, i1, j1, midR, j2);
			decrypt(grid, s, midR, j1, i2, j2);
			return;
		}
		
		decrypt(grid, s, i1, j1, midR, midC);
		decrypt(grid, s, i1, midC, midR, j2);
		decrypt(grid, s, midR, j1, i2, midC);
		decrypt(grid, s, midR, midC, i2, j2);
	}
}
