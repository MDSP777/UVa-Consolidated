import java.util.Scanner;

public class UVa_10660 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc-->0){
			int n = sc.nextInt();
			int[] rows = new int[n];
			int[] cols = new int[n];
			int[] vals = new int[n];
			for(int i=0; i<n; i++){
				rows[i] = sc.nextInt();
				cols[i] = sc.nextInt();
				vals[i] = sc.nextInt();
			}
			int[] ans = new int[5];
			int best = 1000000000;
			for(int i=0; i<25; i++)
				for(int j=i+1; j<25; j++)
					for(int k=j+1; k<25; k++)
						for(int l=k+1; l<25; l++)
							for(int m=l+1; m<25; m++){
								int score = 0;
								for(int x=0; x<n; x++){
									int dist = 100000000;
									dist = Math.min(dist, vals[x]*(Math.abs(i/5-rows[x])+Math.abs(i%5-cols[x])));
									dist = Math.min(dist, vals[x]*(Math.abs(j/5-rows[x])+Math.abs(j%5-cols[x])));
									dist = Math.min(dist, vals[x]*(Math.abs(k/5-rows[x])+Math.abs(k%5-cols[x])));
									dist = Math.min(dist, vals[x]*(Math.abs(l/5-rows[x])+Math.abs(l%5-cols[x])));
									dist = Math.min(dist, vals[x]*(Math.abs(m/5-rows[x])+Math.abs(m%5-cols[x])));
									score+=dist;
								}
								if(score<best){
									best = score;
									ans[0] = i;
									ans[1] = j;
									ans[2] = k;
									ans[3] = l;
									ans[4] = m;
								}
							}
			for(int i=0; i<4; i++) System.out.print(ans[i]+" ");
			System.out.println(ans[4]);
		}
	}
}
