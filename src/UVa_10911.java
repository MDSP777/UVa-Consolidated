import java.util.Arrays;
import java.util.Scanner;


public class UVa_10911 {
	static double[] memo;
	static int n;
	static int bound;
	static Point[] points;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true){
			n = sc.nextInt()*2;
			if(n==0) break;
			points = new Point[n];
			for(int i=0; i<n; i++) {
				sc.next();
				points[i] = new Point(sc.nextDouble(), sc.nextDouble());
			}
			bound = 1<<n;
			memo = new double[bound];
			Arrays.fill(memo, -1);
			System.out.printf("Case %d: %.2f\n", tc++, dp(0));
		}
	}
	
	static double dp(int mask){
		if(mask==bound-1) return 0;
		if(memo[mask]!=-1) return memo[mask];
		double ans = Double.MAX_VALUE;
		for(int i=0; i<n; i++)
			for(int j=i+1; j<n; j++)
				if((mask&(1<<i))==0 && (mask&(1<<j))==0) 
					ans = Math.min(ans, hypot(points[i].x-points[j].x, points[i].y-points[j].y)+dp(mask|(1<<i)|(1<<j)));
		memo[mask] = ans;
		return ans;
	}
	
	static double hypot(double x, double y){
		return Math.sqrt(x*x+y*y);
	}
	
	static class Point {
		double x, y;
		
		Point(double a, double b){
			x = a;
			y = b;
		}
	}
}
