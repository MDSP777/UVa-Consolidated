import java.util.Scanner;

public class UVa_10870 {
	static int d, mod;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			d = sc.nextInt();
			int n = sc.nextInt();
			mod = sc.nextInt();
			if(d==0) break;
			
			long[][] mat = new long[d][d];
			long[][] ans = new long[d][d];
			long[][] src = new long[d][d];
			for(int i=0; i<d; i++) {
				mat[0][i] = sc.nextInt();
				ans[i][i] = 1;
				if(i>0) mat[i][i-1] = 1;
			}
			for(int i=0; i<d; i++) src[d-1-i][0] = sc.nextInt();
			
			if(n<=d) {
				System.out.println(src[n-1][0]%mod);
				continue;
			}
			
			n-=d;
			while(n>0){
				if((n&1)!=0)
					ans = matMul(ans, mat);
				mat = matMul(mat, mat);
				n>>=1;
			}
			ans = matMul(ans, src);
			System.out.println(ans[0][0]%mod);
		}
	}
	
	static long[][] matMul(long[][] a, long[][] b){
		long[][] ans = new long[d][d];
		for(int i=0; i<d; i++)
			for(int j=0; j<d; j++)
				for(int k=0; k<d; k++){
					ans[i][j]+=((a[i][k]%mod)*(b[k][j])%mod)%mod;
					ans[i][j]%=mod;
					while(ans[i][j]<0) ans[i][j]+=mod;
				}
		return ans;
	}
}
