import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_10589 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			if(n==0) break;
			int a = Integer.parseInt(split[1]);
			int m = 0;
			for(int i=0; i<n; i++){
				split = br.readLine().split(" ");
				double x = Double.parseDouble(split[0]);
				double y = Double.parseDouble(split[1]);
				if(Math.hypot(x, y)<=a && Math.hypot(a-x, y)<=a && Math.hypot(x, a-y)<=a && Math.hypot(a-x, a-y)<=a) m++;
			}
			System.out.printf("%.5f\n", m*1.0*a*a/n);
		}
	}
}
