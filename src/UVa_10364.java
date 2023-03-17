import java.util.Scanner;

public class UVa_10364 {
	static int[] arr;
	static int n, total, goal;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		while(tc-->0){
			n = sc.nextInt();
			total = 0;
			arr = new int[n];
			for(int i=1; i<=n; i++) {
				arr[i-1] = sc.nextInt();
				total+=arr[i-1];
			}
			if(total%4!=0) sb.append("no\n");
			else {
				goal = total/4;
				sb.append(can(4, goal, 0, 0) ? "yes\n" : "no\n");
			}
		}
		System.out.print(sb);
	}
	
	static boolean can(int rem, int len, int start, int mask){
		if(rem==0) return true;
		for(int i=start; i<n; i++){
			int b = 1<<i;
			if((mask&b)==0){
				if(arr[i]==len && can(rem-1, goal, 0, mask|b)) return true;
				else if(arr[i]<len && can(rem, len-arr[i], i+1, mask|b)) return true;
				if(len==goal) break;
			}
		}
		return false;
	}
}
