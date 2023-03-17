import java.util.Scanner;


public class UVa_11417 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] gcd = new int[505][505];
		for(int i=1; i<=500; i++){
			gcd[i][i] = i;
			for(int j=i+1; j<=500; j++){
				if(i==1) gcd[i][j] = gcd[j][i] = i;
				gcd[i][j] = gcd[j][i] = gcd(j, i);
			}
		}
				
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			int ans = 0;
			for(int i=1; i<n; i++)
				for(int j=i+1; j<=n; j++)
					ans+=gcd[i][j];
			System.out.println(ans);
		}
	}
	
	static int gcd(int a, int b){
		if(b==0) return a;
		return gcd(b, a%b);
	}
}
