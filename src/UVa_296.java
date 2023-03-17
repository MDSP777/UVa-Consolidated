import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_296 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			int n = Integer.parseInt(br.readLine());
			Guess[] g = new Guess[n];
			for(int i=0; i<n; i++){
				String[] split = br.readLine().split(" ");
				g[i] = new Guess(split[0].toCharArray(), split[1].charAt(0)-'0', split[1].charAt(2)-'0');
			}
			int match = count(g);
			if(match==0) System.out.println("impossible");
			else if(match==-1) System.out.println("indeterminate");
			else {
				String s = match+"";
				while(s.length()<4) s = "0"+s;
				System.out.println(s);
			}
		}
	}
	
	static int count(Guess[] g){
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0; i<10000; i++) {
			boolean m = true;
			for(int j=0; m && j<g.length; j++) m&=match(i, g[j]);
			if(m) ans.add(i);
		}
		if(ans.size()==0) return 0;
		else if(ans.size()>1) return -1;
		else return ans.get(0);
	}
	
	static boolean match(int x, Guess g){
		int c = 0;
		String s = x+"";
		while(s.length()<4) s = "0"+s;
		char[] n = s.toCharArray();
		char[] actual = new char[4];
		for(int i=0; i<4; i++) actual[i] = g.num[i];
		for(int i=0; i<4; i++)
			if(actual[i]==n[i]){
				c++;
				actual[i] = 100;
				n[i] = 100;
			}
		int m = 0;
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
				if(i!=j && n[i]<100 && actual[j]<100 && n[i]==actual[j]){
					m++;
					n[i] = 100;
					actual[j] = 100;
				}
		return c==g.correct && m==g.misplaced;
	}
	
	static class Guess {
		char[] num;
		int correct, misplaced;
		
		Guess(char[] n, int c, int m){
			num = n;
			correct = c;
			misplaced = m;
		}
	}
}
