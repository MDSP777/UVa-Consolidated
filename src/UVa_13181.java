import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_13181 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			int left = -1, right = -1;
			int best = -1;
			for(int i=0; i<s.length(); i++) 
				if(s.charAt(i)=='X') {
					left = right;
					right = i;
					if(left==-1) best = Math.max(best, right-1);
					else {
						int gap = right-left-1;
						best = Math.max(best, (gap-1)/2);
					}
				}
			
			best = Math.max(best, s.length()-2-right);
			sb.append(best).append("\n");
		}
		System.out.print(sb);
	}
}
