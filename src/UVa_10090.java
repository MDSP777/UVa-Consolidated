import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_10090 {
	static long x, y, d;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			boolean swapped = false;
			long n = Long.parseLong(br.readLine());
			if(n==0) break;
			String[] split = br.readLine().split(" ");
			long c1 = Long.parseLong(split[0]);
			long n1 = Long.parseLong(split[1]);
			split = br.readLine().split(" ");
			long c2 = Long.parseLong(split[0]);
			long n2 = Long.parseLong(split[1]);
			if(n2>n1){
				long temp = n2;
				n2 = n1;
				n1 = temp;
				temp = c1;
				c1 = c2;
				c2 = temp;
				swapped = true;
			}
			d = gcd(n1, n2);
			ee(n1, n2);
			long denom = n/d;
			x*=denom;
			y*=denom;
			long ln = (long) Math.ceil(-x*1.0*d/n2);
			long rn = (long) Math.floor(y*1.0*d/n1);
			long cheapest = Long.MAX_VALUE;
			long ans1 = -1, ans2 = -1;
			long[] vals = {ln, rn};
			for(long i : vals){
				long xf = x+(n2/d)*i;
				long yf = y-(n1/d)*i;
				long cost = c1*xf+c2*yf;
				long cap = xf*n1+yf*n2;
				if(cost<cheapest && cap==n && xf>=0 && yf>=0){
					cheapest = cost;
					ans1 = xf;
					ans2 = yf;
				}
			}
			if(swapped){
				long temp = ans1;
				ans1 = ans2;
				ans2 = temp;
			}
			if(ans1==-1 && ans2==-1) sb.append("failed\n");
			else sb.append(ans1).append(" ").append(ans2).append("\n");
		}
		System.out.print(sb);
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
