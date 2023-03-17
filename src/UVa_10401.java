import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_10401 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s==null) break;
			if(s.isEmpty()) continue;
			int n = s.length();
			char[] c = s.toCharArray();
			long[][] grid = new long[n][n];
			if(s.charAt(0)=='?')
				for(int i=0; i<n; i++) {
					if(n==1 || c[1]=='?' || !conflict(i, c[1])) grid[i][0] = 1;
				}
			else if(n==1 || !conflict(toInt(c[0]), c[1])) grid[toInt(c[0])][0] = 1;
			for(int i=1; i<n; i++)
				if(c[i]=='?')
					for(int j=0; j<n; j++){
						if(c[i-1]=='?')
							for(int k=0; k<n; k++){
								if(Math.abs(j-k)>1) grid[j][i]+=grid[k][i-1];
							}
						else if(Math.abs(j-toInt(c[i-1]))>1) grid[j][i]+=grid[toInt(c[i-1])][i-1];
					}
				else{
					if(c[i-1]=='?'){
						for(int j=0; j<n; j++)
							if(!conflict(j, c[i])) grid[toInt(c[i])][i]+=grid[j][i-1];
					} else if(Math.abs(toInt(c[i])-toInt(c[i-1]))>1) grid[toInt(c[i])][i]+=grid[toInt(c[i-1])][i-1];
				}
			long total = 0;
			for(int i=0; i<n; i++) total+=grid[i][n-1];
			System.out.println(total);
		}
	}
	
	static int toInt(char c){
		if(c<='9') return c-'0'-1;
		else return c-'A'+9;
	}
	
	static boolean conflict(int a, char c){
		if(c=='?') return false;
		int b = toInt(c);
		return Math.abs(a-b)<=1;
	}
}
