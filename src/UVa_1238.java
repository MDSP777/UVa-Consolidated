import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class UVa_1238 {
	static int[] terms;
	static int[] sign;
	static BitSet used;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split(" ");
			terms = new int[split.length/2+1];
			sign = new int[split.length/2+1];
			terms[0] = Integer.parseInt(split[0]);
			sign[0] = 1;
			for(int i=1; i<split.length; i+=2){
				terms[i/2+1] = Integer.parseInt(split[i+1]);
				sign[i/2+1] = split[i].equals("+") ? 1 : -1;
			}
			used = new BitSet();
			visited = new boolean[terms.length][terms.length][6060];
			dp(0, 0, 0);
			System.out.println(used.cardinality());
		}
	}
	
	static void dp(int index, int open, int val){
		if(index==terms.length) {
			used.set(val+3000);
			return;
		}
		if(visited[index][open][val+3000]) return;
		visited[index][open][val+3000] = true;
		int newVal = val+terms[index]*sign[index]*(open%2==0 ? 1 : -1);
		if(sign[index]==-1) dp(index+1, open+1, newVal);
		if(open>0) dp(index+1, open-1, newVal);
		dp(index+1, open, newVal);
	}
}
