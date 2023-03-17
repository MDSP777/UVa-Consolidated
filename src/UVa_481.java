import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class UVa_481 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> terms = new ArrayList<>();
		while(true) {
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			terms.add(Integer.parseInt(s));
		}
		int n = terms.size();
		int[] I = new int[n];
		int[] L = new int[n];
		int ans = 0;
		for(int i=0; i<n; i++) I[i] = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			int index = Arrays.binarySearch(I, terms.get(i));
			if(index<0) index = -(index+1);
			if(terms.get(i)<I[index]) {
				L[i] = index+1;
				I[index] = terms.get(i);
				ans = Math.max(ans, L[i]);
			}
		}
		System.out.println(ans);
		System.out.println("-");
		Stack<Integer> out = new Stack<>();
		for(int i=n-1; i>=0; i--) {
			if(L[i]==ans) {
				out.push(terms.get(i));
				ans--;
			}
		}
		while(!out.isEmpty()) System.out.println(out.pop());
	}
}
