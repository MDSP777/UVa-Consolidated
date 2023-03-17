import java.util.Scanner;


public class UVa_10182 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] memo = new int[100100][2];
		int[] aOffsets = {-1, 0, 1, 1, 0};
		int[] bOffsets = {0, -1, -1, 0, 1};
		int i = 1;
		int a = 0, b = 0;
		memo[1][0] = a;
		memo[1][1] = b;
		int n = 1;
		while(i<100000){
			// down
			i++;
			if(i>=100000) break;
			b++;
			memo[i][0] = a;
			memo[i][1] = b;
			
			// down-left
			for(int j=0; j<n-1; j++){
				i++;
				if(i>=100000) break;
				a--;
				b++;
				memo[i][0] = a;
				memo[i][1] = b;
			}
			
			for(int j=0; j<5; j++){
				if(i>=100000) break;
				for(int k=0; k<n; k++){
					i++;
					if(i>=100000) break;
					a+=aOffsets[j];
					b+=bOffsets[j];
					memo[i][0] = a;
					memo[i][1] = b;
				}
			}
			n++;
		}
		
		do{
			int x = sc.nextInt();
			System.out.println(memo[x][0]+" "+memo[x][1]);
		}while(sc.hasNext());
	}
}
