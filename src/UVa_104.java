import java.util.Scanner;


public class UVa_104 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		do{
			int n = sc.nextInt();
			double[][][] adj = new double[n+1][n][n];
			int[][][] next = new int[n+1][n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<i; j++) {
					adj[0][i][j] = sc.nextDouble();
					next[0][i][j] = j;
				}
				adj[0][i][i] = 1.0;
				next[0][i][i] = i;
				for(int j=i+1; j<n; j++) {
					adj[0][i][j] = sc.nextDouble();
					next[0][i][j] = j;
				}
			}
			for(int s=1; s<=n; s++)
				for(int k=0; k<n; k++)
					for(int i=0; i<n; i++)
						for(int j=0; j<n; j++){
							double tmp = adj[s-1][i][k]*adj[0][k][j];
							if(tmp>adj[s][i][j]) {
								adj[s][i][j] = tmp;
								next[s][i][j] = k;
							}
						}
			int ans = -1;
			int steps = -1;
			for(int s=1; ans==-1 && s<=n; s++)
				for(int i=0; ans==-1 && i<n; i++)
					if(adj[s][i][i]>=1.01) {
						ans = i;
						steps = s;
					}
			if(ans==-1) System.out.println("no arbitrage sequence exists");
			else{
				int[] out = new int[steps+2];
				int index = 0;
				int cur = ans;
				out[index++] = ans;
				for(int s=steps; s>=0; s--){
					cur = next[s][ans][cur];
					out[index++] = cur;
				}
				System.out.print((ans+1)+" ");
				for(int i=index-2; i>0; i--) System.out.print((out[i]+1)+" ");
				System.out.println(out[0]+1);
			}
		}while(sc.hasNext());
	}
}
