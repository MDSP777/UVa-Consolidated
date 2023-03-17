import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_11173 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		while(c-->0) {
			int n = Integer.parseInt(br.readLine().split(" ")[1]);
			System.out.println(n^(n>>1));
		}
	}
}
