import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_10502 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int r = Integer.parseInt(br.readLine());
			if(r==0) break;
			int c = Integer.parseInt(br.readLine());
			char[][] grid = new char[r][c];
			for(int i=0; i<r; i++) grid[i] = br.readLine().toCharArray();
			int total = 0;
			int[][] sums = new int[r][c];
			sums[0][0] = grid[0][0]-'0';
			for(int i=1; i<r; i++) sums[i][0] = sums[i-1][0]+grid[i][0]-'0';
			for(int i=1; i<c; i++) sums[0][i] = sums[0][i-1]+grid[0][i]-'0';
			for(int i=1; i<r; i++)
				for(int j=1; j<c; j++)
					sums[i][j] = grid[i][j]-'0'+sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++)
					for(int k=i; k<r; k++)
						for(int l=j; l<c; l++){
							if(sums[k][l]
								-(j-1>=0 ? sums[k][j-1] : 0)
								-(i-1>=0 ? sums[i-1][l] : 0)
								+(i-1>=0 && j-1>=0 ? sums[i-1][j-1] : 0)==(k-i+1)*(l-j+1)) total++;
						}
			System.out.println(total);
		}
	}
}
