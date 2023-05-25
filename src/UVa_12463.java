import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_12463 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] split = br.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			int c = Integer.parseInt(split[2]);
			int d = Integer.parseInt(split[3]);
			int e = Integer.parseInt(split[4]);
			if(a==0 && b==0 && c==0 && d==0 && e==0) break;
			
			System.out.println(a*b*c*d*d*e*e);
		}
	}
}
