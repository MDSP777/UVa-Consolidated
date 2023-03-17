import java.util.Scanner;


public class UVa_11001 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0 && m==0) break;
			double maxD = -1;
			boolean unique = true;
			int bestI = -1;
			for(int i=1; i<=n; i++){
				double v = n*1.0/i;
				double d = v<=m ? 0 : 0.3*Math.sqrt(v-m);
				d*=i;
				if(Math.abs(d-maxD)<1e-9){
					unique = false;
				} else if(d>maxD){
					bestI = i;
					maxD = d;
					unique = true;
				} 
			}
			System.out.println(bestI==-1 || !unique ? 0 : bestI);
		}
	}
}
