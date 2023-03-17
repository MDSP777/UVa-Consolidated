import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UVa_11827 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(n-->0){
			String[] split = br.readLine().split(" ");
			int[] arr = new int[split.length];
			Arrays.sort(arr);
			for(int i=0; i<split.length; i++) arr[i] = Integer.parseInt(split[i]);
			int max = 0;
			for(int i=0; i<arr.length; i++)
				for(int j=i+1; j<arr.length; j++)
					max = Math.max(max, gcd(arr[j], arr[i]));
			System.out.println(max);
		}
	}
	
	static int gcd(int a, int b){
		return b==0 ? a : gcd(b, a%b);
	}
}
