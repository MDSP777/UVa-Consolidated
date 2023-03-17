import java.util.Scanner;


public class UVa_12155 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();
			int height = 2*n-1;
			sb.append("Case ").append(t++).append(":\n");
			for(int i=r1; i<=r2; i++){
				StringBuilder cur = new StringBuilder();
				for(int j=c1; j<=c2; j++){
					int row = i%height;
					int col = j%height;
					int nEmpty = Math.abs(row-n+1);
					int halfLen = n-nEmpty;
					int diff = Math.abs(n-col-1)+1;
					if(diff>halfLen) cur.append(".");
					else {
						int val = 'a'+(n%26-(halfLen-diff)-1)%26;
						if(val<'a') val = 'z'-('a'-val-1)%26;
						cur.append((char) val);
					}
				}
				sb.append(cur).append("\n");
			}
		}
		System.out.print(sb);
	}
}
