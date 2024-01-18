import java.util.Scanner;


public class UVa_10518 {
	static int mod;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(true){
			long n = sc.nextLong();
			mod = sc.nextInt();
			if(n==0 && mod==0) break;
			
			if(n<=1){
				System.out.printf("Case %d: %d %d %d\n", t++, n, mod, 1%mod);
				continue;
			}
			long original = n;
			n--;
			
			long[][] mat = {{1, 1, 1}, {1, 0, 0}, {0, 0, 1}};
			long[][] ans = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
			long[][] src = {{5, 3, 1}, {3, 1, 1}, {1, 1, 1}};
			while(n>0){
				if((n&1)!=0)
					ans = matMul(ans, mat);
				mat = matMul(mat, mat);
				n>>=1;
			}
			ans = matMul(ans, src);
			
			System.out.printf("Case %d: %d %d %d\n", t++, original, mod, ans[0][2]%mod);
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
			return ans;
		}
}
