import java.util.Scanner;

public class UVa_10642 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++){
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			System.out.println("Case "+t+": "+(findIndex(y2, x2)-findIndex(y1, x1)));
		}
	}
	
	static long findIndex(long x, long y){
		if(x==0 && y==0) return 0;
		long diag = x+y;
		long pathCost = diag*(diag-1)/2 + diag + y;
		return pathCost;
	}
}
