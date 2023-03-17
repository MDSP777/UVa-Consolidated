import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class UVa_524 {
	static int[] arr;
	static BitSet used;
	static int n;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		boolean first = true;
		sb = new StringBuilder();
		while(true){
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			n = Integer.parseInt(s);
			if(first) first = false;
			else sb.append("\n");
			arr = new int[n];
			arr[0] = 1;
			used = new BitSet();
			used.set(1);
			sb.append("Case ").append(t++).append(":\n");
			backtrack(1);
		}
		System.out.print(sb);
	}
	
	static void backtrack(int index){
		if(index==n) {
			sb.append(1);
			for(int i=1; i<n; i++) sb.append(" ").append(arr[i]);
			sb.append("\n");
		}
		for(int i=2; i<=n; i++)
			if(!used.get(i) && isPrime(arr[index-1]+i) && (index<n-1 || isPrime(arr[0]+i))){
				used.set(i);
				arr[index] = i;
				backtrack(index+1);
				used.set(i, false);
			}
	}
	
	static boolean isPrime(int n){
		for(int i=2; i<n; i++) if(n%i==0) return false;
		return true;
	}
}
