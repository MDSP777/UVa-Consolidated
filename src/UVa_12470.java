import java.util.Scanner;

public class UVa_12470 {
	static long mod = 1_000_000_009;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			long n = sc.nextLong();
			if(n==0) break;
			n--;
			
			long[][] mat = {{1, 1, 1}, {1, 0, 0}, {0, 1, 0}};
			long[][] ans = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
			long[][] src = {{6, 3, 2}, {3, 2, 1}, {2, 1, 0}};
			while(n>0){
				if((n&1)!=0)
					ans = matMul(ans, mat);
				mat = matMul(mat, mat);
				n>>=1;
			}
//			print(ans);
			ans = matMul(ans, src);
			System.out.println(ans[2][2]%mod);
		}
	}
	
	// assumes 3x3 matrices
	static long[][] matMul(long[][] a, long[][] b){
		long[][] ans = new long[3][3];
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				for(int k=0; k<3; k++){
					ans[i][j]+=((a[i][k]%mod) * (b[k][j]%mod))%mod;
					while(ans[i][j]<0) ans[i][j]+=mod;
				}
//		print(a);
//		print(b);
//		print(ans);
		return ans;
	}
	
	static void print(int[][] arr){
		for(int i=0; i<3; i++){
			System.out.printf("[%d, %d, %d]\n", arr[i][0], arr[i][1], arr[i][2]);
		}
		System.out.println("---------------");
	}
}
