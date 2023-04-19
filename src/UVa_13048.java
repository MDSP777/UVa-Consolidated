import java.util.Scanner;

public class UVa_13048 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++){
			char[] arr = sc.next().toCharArray();
			int total = 0;
			for(int i=0; i<arr.length; i++){
				boolean can = arr[i]=='-';
				for(int j=i+1; j<=i+2 && j<arr.length; j++)
					can&=arr[j]!='B';
				if(i+1<arr.length) can&=arr[i+1]!='S';
				if(i-1>=0) can&=arr[i-1]!='S';
				if(can) total++;
			}
			
			System.out.println("Case "+t+": "+total);
		}
	}
}
