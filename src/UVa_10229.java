import java.util.Scanner;


public class UVa_10229 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			long n = sc.nextLong();
			int m = 1<<sc.nextInt();
			
			int[][] mat = {{1, 1}, {1, 0}};
			int[][] ans = {{1, 0}, {0, 1}};
			while(n>0){
				if((n&1)!=0)
					ans = matMul(ans, mat, m);
				mat = matMul(mat, mat, m);
				n>>=1;
			}
			System.out.println(ans[0][1]);
		}while(sc.hasNext());
	}
	
	static int[][] matMul(int[][] a, int[][] b, int m){ // assumes 2x2
		int[][] ans = new int[2][2];

		ans[0][0] = (a[0][0]*b[0][0]+a[0][1]*b[1][0])%m;
		ans[0][1] = (a[0][0]*b[0][1]+a[0][1]*b[1][1])%m;
		ans[1][0] = (a[1][0]*b[0][0]+a[1][1]*b[1][0])%m;
		ans[1][1] = (a[1][0]*b[0][1]+a[1][1]*b[1][1])%m;
		
		for(int i=0; i<2; i++)
			for(int j=0; j<2; j++)
				while(ans[i][j]<0) ans[i][j]+=m;
		
		return ans;
	}
}
