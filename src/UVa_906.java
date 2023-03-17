import java.util.Scanner;


public class UVa_906 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			long a = sc.nextLong();
			long b = sc.nextLong();
			float n = sc.nextFloat();
			solve(a, b, n);
		}
	}

	private static void solve(long a, long b, float n) {
		for(long d=1; d<=10000000; d++){
			long c = Math.round(a*1.0*d/b);
			for(int i=-1; i<=1; i++){
				c+=i;
				double l = a*1.0/b;
				double r = c*1.0/d;
				if(r>l && r-l-n<=n*1e-6){
					System.out.println(c+" "+d);
					return;
				}
				c-=i;
			}
		}
		System.out.println("SHIT");
	}
}
