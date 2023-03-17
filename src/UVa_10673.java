import java.util.Scanner;


public class UVa_10673 {
	static long d, x, y;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			long n = sc.nextLong();
			long m = sc.nextLong();
			long a = (long) Math.floor(n*1.0/m);
			long b = (long) Math.ceil(n*1.0/m);
			boolean swapped = false;
			if(b>a){
				long temp = a;
				a = b;
				b = temp;
				swapped = true;
			}
			d = gcd(a, b);
			ee(a, b);
			long denom = n/d;
			x*=denom;
			y*=denom;
			long ln = (long) Math.ceil(-x*1.0*d/b);
			long rn = (long) Math.floor(y*1.0*d/a);
			long ans1 = -1, ans2 = -1;
			long[] vals = {ln, rn};
			for(long i : vals){
				long xf = x+(b/d)*i;
				long yf = y-(a/d)*i;
				long cap = xf*a+yf*b;
				if(cap==n){
					ans1 = xf;
					ans2 = yf;
				}
			}
			if(swapped){
				long temp = ans1;
				ans1 = ans2;
				ans2 = temp;
			}
			System.out.println(ans1+" "+ans2);
		}
	}
	
	static long gcd(long a, long b){
		return b==0 ? a : gcd(b, a%b);
	}
	
	static void ee(long a, long b){
		if(b==0){
			x = 1;
			y = 0;
			d = a;
			return;
		}
		ee(b, a%b);
		long x1 = y;
		long y1 = x-(a/b)*y;
		x = x1;
		y = y1;
	}
}
