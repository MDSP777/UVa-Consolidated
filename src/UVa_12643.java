import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_12643 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split(" ");
			int n = Integer.parseInt(split[0]);
			int l = Integer.parseInt(split[1])-1;
			int r = Integer.parseInt(split[2])-1;
			
			int ans = n;
			int i = 1<<(n-1);
			while(l/i==r/i) {
				i/=2;
				ans--;
			}
			System.out.println(ans);
		}
	}
}
