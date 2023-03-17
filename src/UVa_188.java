import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_188 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split("\\s+");
			int n = split.length;
			int[] w = new int[n];
			int min = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				w[i] = convert(split[i]);
				min = Math.min(min, w[i]);
			}
			int c = min;
			while(true){
				boolean hasConflict = false;
				int maxConflict = 0;
				int[] mods = new int[n];
				for(int i=0; i<n; i++) mods[i] = c/w[i]%n;
				for(int i=0; i<n; i++)
					for(int j=i+1; j<n; j++){
						if(mods[i]==mods[j]){
							hasConflict = true;
							maxConflict = Math.max(maxConflict, Math.min((c/w[i]+1)*w[i], (c/w[j]+1)*w[j]));
						}
					}
				if(!hasConflict) break;
				c = maxConflict;
			}
			System.out.println(s+"\n"+c+"\n");
		}
	}
	
	static int convert(String s){
		int ans = 0;
		for(int i=0; i<s.length(); i++) ans = ans*32+s.charAt(i)-'a'+1;
		return ans;
	}
}
