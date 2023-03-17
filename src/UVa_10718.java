import java.util.Scanner;

public class UVa_10718 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			long n = sc.nextLong();
			long l = sc.nextLong();
			long r = sc.nextLong();
			long ans = 0;
			for(int i=31; i>=0; i--){
				
				long onehot = 1l<<i;
				if((ans|onehot)>=l && (ans|onehot)<=r){
					if((n & (onehot))==0){
						ans|=onehot;
					} else if((ans | onehot)-1 < l) {
						ans|=onehot;
					}
				} else if((ans|onehot)-1<l){
					ans|=onehot;
				}
			}
			System.out.println(ans);
		}while(sc.hasNext());
	}
}
