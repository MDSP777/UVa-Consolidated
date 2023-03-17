import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_11608 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = 1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n<0) break;
			String[] split = br.readLine().split("\\s+");
			String[] split2 = br.readLine().split("\\s+");
			System.out.println("Case "+c+++":");
			for(int i=0; i<12; i++) {
				if(n>=Integer.parseInt(split2[i])) {
					n-=Integer.parseInt(split2[i]);
					System.out.println("No problem! :D");
				} else System.out.println("No problem. :(");
				n+=Integer.parseInt(split[i]);
			}
		}
	}
}
