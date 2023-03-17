import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVa_13197 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Long>[][] res = new ArrayList[1010][1010];
		while(true){
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			String[] split = s.split(" ");
			int a = Integer.parseInt(split[0]);
			int p = Integer.parseInt(split[1]);
			if(res[a][p]==null) {
				res[a][p] = new ArrayList<>();
				for(long x=0; x<p; x++)
					if((x*x*x)%p==a) res[a][p].add(x);
			}
			print(res[a][p]);
		}
	}
	
	static void print(ArrayList<Long> a){
		StringBuilder sb = new StringBuilder();
		if(a.size()>0) sb.append(a.get(0));
		for(int i=1; i<a.size(); i++)
			sb.append(" ").append(a.get(i));
		System.out.println(sb);
	}
}
