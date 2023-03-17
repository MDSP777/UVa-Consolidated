import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_297 {
	static boolean[][] grid;
	static int index;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			grid = new boolean[32][32];
			index = -1;
			fill(br.readLine().toCharArray(), 0, 32, 0, 32);
			index = -1;
			fill(br.readLine().toCharArray(), 0, 32, 0, 32);
			int total = 0;
			for(int i=0; i<32; i++)
				for(int j=0; j<32; j++)
					if(grid[i][j]) total++;
			System.out.println("There are "+total+" black pixels.");
		}
	}
	
	static void fill(char[] arr, int i1, int i2, int j1, int j2) {
		index++;
		if(arr[index]=='f') 
			for(int i=i1; i<i2; i++)
				for(int j=j1; j<j2; j++)
					grid[i][j] = true;
		else if(arr[index]=='p') {
			int iMid = (i1+i2)/2;
			int jMid = (j1+j2)/2;
			fill(arr, i1, iMid, jMid, j2);
			fill(arr, i1, iMid, j1, jMid);
			fill(arr, iMid, i2, j1, jMid);
			fill(arr, iMid, i2, jMid, j2);
		}
	}
}
