import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Stack;


public class UVa_124 {
	static Stack<Integer> stack;
	static BitSet visited;
	static int[] inD;
	static int total;
	static int n;
	static char[] letters;
	static ArrayList<Integer>[] e;
	static ArrayList<String> out;
	
	static void ts(){
		boolean flag = false;
		for(int i=0; i<n; i++){
			if(!visited.get(i) && inD[i]==0){
				visited.set(i);
				stack.push(i);
				for(int next: e[i]) inD[next]--;
				ts();
				visited.clear(i);
				stack.pop();
				for(int next: e[i]) inD[next]++;
				flag = true;
			}
		}
		if(!flag && !stack.isEmpty()){
			StringBuilder sb = new StringBuilder();
			Stack<Integer> s2 = new Stack<>();
			while(!stack.isEmpty()) s2.add(stack.pop());
			while(!s2.isEmpty()){
				sb.append(letters[s2.peek()]);
				stack.add(s2.pop());
			}
			out.add(sb.toString());
			total++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean first = true;
		while(true){
			String s = br.readLine();
			if(s==null) break;
			if(first) first = false;
			else System.out.println();
			String[] split = s.split(" ");
			n = split.length;
			int[] index = new int[26];
			letters = new char[26];
			int ctr = 0;
			for(String cur : split) {
				index[cur.charAt(0)-'a'] = ctr;
				letters[ctr++] = cur.charAt(0);
			}
			e = new ArrayList[n];
			split = br.readLine().split(" ");
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			inD = new int[n];
			for(int i=0; i<split.length; i+=2) {
				e[index[split[i].charAt(0)-'a']].add(index[split[i+1].charAt(0)-'a']);
				inD[index[split[i+1].charAt(0)-'a']]++;
			}
			stack = new Stack<>();
			visited = new BitSet();
			total = 0;
			out = new ArrayList<>();
			ts();
			Collections.sort(out);
			for(String cur: out) System.out.println(cur);
		}
	}
}
