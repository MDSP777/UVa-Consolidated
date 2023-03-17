import java.util.Scanner;


public class UVa_10908 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			int r = sc.nextInt();
			int c = sc.nextInt();
			int q = sc.nextInt();
			char[][] grid = new char[r][c];
			for(int i=0; i<r; i++) grid[i] = sc.next().toCharArray();
			System.out.println(r+" "+c+" "+q);
			while(q-->0){
				int u = sc.nextInt();
				int v = sc.nextInt();
				int size = 1;
				int dr = 1, dc = 1;
				while(true){
					if(u-dr<0 || u+dr>=r || v-dc<0 || v+dc>=c) break;
					boolean eq = true;
					for(int i=u-dr; eq && i<=u+dr; i++) eq&=grid[i][v-dc]==grid[u][v] && grid[i][v+dc]==grid[u][v]; 
					for(int i=v-dc; eq && i<=v+dc; i++) eq&=grid[u-dr][i]==grid[u][v] && grid[u+dr][i]==grid[u][v]; 
					if(eq){
						dr++;
						dc++;
						size+=2;
					} else break;
				}
				System.out.println(size);
			}
		}
	}
}
