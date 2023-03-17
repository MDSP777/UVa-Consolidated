import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class UVa_872 {
	static Stack<Integer> stack;
	static BitSet visited;
	static int[] inD;
	static int total;
	static int n;
	static String[] v;
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
				sb.append(v[s2.peek()]).append(" ");
				stack.add(s2.pop());
			}
			out.add(sb.toString().trim());
			total++;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0){
			br.readLine();
			v = br.readLine().split(" ");
			HashMap<String, Integer> map = new HashMap<>();
			n = v.length;
			e = new ArrayList[n];
			for(int i=0; i<n; i++) {
				map.put(v[i], i);
				e[i] = new ArrayList<>();
			}
			String[] split = br.readLine().split(" ");
			inD = new int[n];
			for(int i=0; i<split.length; i++){
				String[] sp = split[i].split("<");
				e[map.get(sp[0])].add(map.get(sp[1]));
				inD[map.get(sp[1])]++;
			}
			stack = new Stack<>();
			visited = new BitSet();
			total = 0;
			out = new ArrayList<>();
			ts();
			if(total==0) System.out.println("NO");
			else {
				Collections.sort(out);
				for(String s: out) System.out.println(s);
			}
			if(tc>0) System.out.println();
		}
	}
}
