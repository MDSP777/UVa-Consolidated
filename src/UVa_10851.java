import java.util.Scanner;

public class UVa_10851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			char[][] grid = new char[10][];
			for(int i=0; i<10; i++) grid[i] = sc.next().toCharArray();
			
			StringBuilder sb = new StringBuilder();
			for(int i=1; i<grid[0].length-1; i++){
				StringBuilder b = new StringBuilder();
				for(int j=1; j<9; j++)
					b.append(grid[j][i]=='/' ? 0 : 1);
				sb.append((char)Integer.parseInt(b.reverse().toString(), 2));
			}
			System.out.println(sb);
		}
	}
}
