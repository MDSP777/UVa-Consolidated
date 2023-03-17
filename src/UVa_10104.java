import java.util.Scanner;


public class UVa_10104 {
	static long d, x, y;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		do{
			long a = sc.nextLong();
			long b = sc.nextLong();
			if(a==0) System.out.println("0 1 "+b);
			else if(b==0) System.out.println("1 0 "+a);
			else {
				boolean swapped = false;
				if(b>a){
					long temp = a;
					a = b;
					b = temp;
					swapped = true;
				}
				d = gcd(a, b);
				ee(a, b);
				long ln = (long) Math.ceil(-x*1.0/b);
				long rn = (long) Math.floor(y*1.0/a);
				long ans1 = -10000000000l, ans2 = -1000000000;
				long[] vals = {ln, rn};
				for(long i : vals){
					long xf = x+(b/d)*i;
					long yf = y-(a/d)*i;
					long cap = xf*a+yf*b;
					if(cap==d){
						if(Math.abs(xf)+Math.abs(yf)<Math.abs(ans1)+Math.abs(ans2)){
							ans1 = xf;
							ans2 = yf;
						} else if(Math.abs(xf)+Math.abs(yf)==Math.abs(ans1)+Math.abs(ans2) && xf<=yf){
							ans1 = xf;
							ans2 = yf;
						}
					}
				}
				if(swapped){
					long temp = ans1;
					ans1 = ans2;
					ans2 = temp;
				}
				System.out.println(ans1+" "+ans2+" "+d);
			}
		}while(sc.hasNext());
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
