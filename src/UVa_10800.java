import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class UVa_10800 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Character> map = new HashMap<>();
		map.put('R', '/');
		map.put('F', '\\');
		map.put('C', '_');
		int nC = sc.nextInt();
		for(int curC=1; curC<=nC; curC++){
			char[] c = sc.next().toCharArray();
			int h = 0;
			int max = 0, min = 0;
			for(int i=0; i<c.length; i++) {
				if(c[i]=='R') h++; 
				else if(c[i]=='F') h--;
				max = Math.max(max, h);
				min = Math.min(min, h);
			}
			char[][] grid = new char[110][60];
			for(int i=0; i<110; i++){
				Arrays.fill(grid[i], ' ');
				grid[i][0] = '|';
			}
			StringBuilder sb = new StringBuilder("+---");
			int curRow = 109+min;
			grid[curRow][2] = map.get(c[0]);
			if(c[0]=='R') curRow--;
			else if(c[0]=='F') curRow++;
			for(int i=1; i<c.length; i++){
				if(c[i-1]!='F' && c[i]=='F') curRow++;
				else if(c[i-1]=='F' && c[i]!='F') curRow--;
				grid[curRow][i+2] = map.get(c[i]);
				if(c[i]=='R') curRow--;
				else if(c[i]=='F') curRow++;
				sb.append("-");
			}
			System.out.println("Case #"+curC+":");
			for(int i=0; i<110; i++)
				if(!String.valueOf(grid[i]).trim().equals("|"))
					System.out.println(String.valueOf(grid[i]).trim());
			System.out.println(sb+"\n");
		}
	}
}
