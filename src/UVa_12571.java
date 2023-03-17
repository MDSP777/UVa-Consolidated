import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;


public class UVa_12571 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		int mask = 255;
		while(tc-->0){
			String[] split = br.readLine().split(" ");
			int q = Integer.parseInt(split[1]);
			HashSet<Integer> terms = new HashSet<>();
			split = br.readLine().split(" ");
			for(String s : split){
				int x = Integer.parseInt(s);
				terms.add(x&mask);
			}
			HashMap<Integer, Integer> answers = new HashMap<>();
			while(q-->0){
				int a = Integer.parseInt(br.readLine());
				if(answers.containsKey(a)){
					sb.append(answers.get(a)).append("\n");
					continue;
				}
				int max = 0;
				for(int x : terms)
					max = Math.max(max, x&a);
				answers.put(a, max);
				sb.append(max).append("\n");
			}
		}
		System.out.print(sb);
	}
}
