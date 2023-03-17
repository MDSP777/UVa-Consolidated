import java.util.Scanner;


public class UVa_12090 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			long l = sc.nextLong();
			if(l==0) break;
			if(l==1) {
				System.out.println("1 0");
				continue;
			} else if(l<=3) {
				System.out.println(l+" 1");
				continue;
			}
			long sqrt = (long) Math.sqrt(l);
			long ans = 1;
			for(long i=2; i<sqrt; i++)
				if(l%i==0){
					long[] factors = {i, l/i};
					for(long f : factors){
						long cur = l;
						while(cur%f==0){
							ans++;
							cur/=f;
						}
					}
				}
			long cur = l;
			if(cur%sqrt==0){
				while(cur%sqrt==0){
					ans++;
					cur/=sqrt;
				}
				if(sqrt!=l/sqrt){
					sqrt = l/sqrt;
					cur = l;
					while(cur%sqrt==0){
						ans++;
						cur/=sqrt;
					}
				}
			}
			System.out.println(l+" "+ans);
		}
	}
}
