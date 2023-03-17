import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_10298 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s.equals(".")) break;
			int len = s.length();
			int ans = -1;
			for(int i=1; ans==-1 && i<=len; i++)
				if(len%i==0){
					boolean can = true;
					for(int j=0; can && j<i; j++)
						for(int k=j+i; can && k<len; k+=i) can&=s.charAt(j)==s.charAt(k);
					if(can) ans = len/i;
				}
			System.out.println(ans);
		}
	}
}
