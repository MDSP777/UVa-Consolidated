import java.util.Scanner;

public class UVa_10703 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			int n = sc.nextInt();
			if(w==0) break;
			boolean[][] grid = new boolean[w][h];
			int total = w*h;
			while(n-->0) {
				int i1 = sc.nextInt()-1;
				int j1 = sc.nextInt()-1;
				int i2 = sc.nextInt()-1;
				int j2 = sc.nextInt()-1;
				if(i1>i2) {
					int temp = i1;
					i1 = i2;
					i2 = temp;
				}
				if(j1>j2) {
					int temp = j1;
					j1 = j2;
					j2 = temp;
				}
				for(int i=i1; i<=i2; i++)
					for(int j=j1; j<=j2; j++) {
						if(!grid[i][j]) total--;
						grid[i][j] = true;
					}
			}
			if(total==0) System.out.println("There is no empty spots.");
			else if(total==1) System.out.println("There is one empty spot.");
			else System.out.println("There are "+total+" empty spots.");
		}
	}
}
