import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UVa_10100 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while(true){
			String s1 = br.readLine();
			if(s1==null) break;
			String s2 = br.readLine();
			String tc = t+++"";
			if(tc.length()<2) tc = " "+tc;
			if(s1.isEmpty() || s2.isEmpty()) System.out.println(tc+". Blank!");
			else {
				s1 = s1.replaceAll("[^A-Za-z0-9]", " ").trim();
				s2 = s2.replaceAll("[^A-Za-z0-9]", " ").trim();
				String[] arr1 = s1.split("\\s+");
				String[] arr2 = s2.split("\\s+");
				int[][] memo = new int[arr1.length+1][arr2.length+1];
				for(int i=1; i<=arr1.length; i++)
					for(int j=1; j<=arr2.length; j++)
						memo[i][j] = arr1[i-1].equals(arr2[j-1]) ? memo[i-1][j-1]+1 : Math.max(memo[i-1][j], memo[i][j-1]);
				System.out.println(tc+". Length of longest match: "+memo[arr1.length][arr2.length]);
			}
		}
	}
}
