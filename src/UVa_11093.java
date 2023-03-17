import java.util.Scanner;

public class UVa_11093 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		for(int curC=1; curC<=nC; curC++) {
			int n = sc.nextInt();
			int[] p = new int[n];
			int[] q = new int[n];
			int sum = 0;
			int min = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) p[i] = sc.nextInt();
			for(int i=0; i<n; i++) {
				q[i] = sc.nextInt();
				sum+=p[i]-q[i];
				min = Math.min(min, sum);
			}
			if(sum<0) System.out.println("Case "+curC+": Not possible");
			else {
				int index = 0;
				while(min<0 && index<n) min-=p[index]-q[index++];
				System.out.println("Case "+curC+": Possible from station "+(index+1));
			}
		}
	}
}
