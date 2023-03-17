import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class UVa_247 {
	static int[] dfsNum;
	static int[] dfsLow;
	static BitSet visited;
	static Stack<Integer> s;
	static int dfsCtr;
	static int n;
	static ArrayList<Integer>[] e;
	static String[] names;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean first = true;
		int c = 1;
		while(true){
			n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0 && m==0) break;
			if(first) first = false;
			else System.out.println();
			HashMap<String, Integer> map = new HashMap<>();
			e = new ArrayList[n];
			names = new String[n];
			int index = 0;
			for(int i=0; i<n; i++) e[i] = new ArrayList<>();
			while(m-->0){
				String s = sc.next();
				String t = sc.next();
				if(!map.containsKey(s)) {
					map.put(s, index);
					names[index++] = s;
				}
				if(!map.containsKey(t)) {
					map.put(t, index);
					names[index++] = t;
				}
				e[map.get(s)].add(map.get(t));
			}
			dfsNum = new int[n];
			dfsLow = new int[n];
			visited = new BitSet();
			dfsCtr = 0;
			s = new Stack<>();
			Arrays.fill(dfsNum, -1);
			System.out.println("Calling circles for data set "+c+++":");
			for(int i=0; i<n; i++)
				if(dfsNum[i]==-1) scc(i);
		}
	}
	
	static void scc(int u){
		dfsLow[u] = dfsNum[u] = dfsCtr++;
		s.push(u);
		visited.set(u);
		for(int i=0; i<e[u].size(); i++){
			int v = e[u].get(i);
			if(dfsNum[v]==-1) scc(v);
			if(visited.get(v)) dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);
		}
		if(dfsLow[u]==dfsNum[u]){
			StringBuilder sb = new StringBuilder();
			if(!s.isEmpty()){
				int x = s.pop();
				visited.clear(x);
				sb.append(names[x]);
				if(x==u){
					System.out.println(sb);
					return;
				}
			}
			while(true){
				int x = s.pop();
				visited.clear(x);
				sb.append(", ").append(names[x]);
				if(u==x) break;
			}
			System.out.println(sb);
		}
	}
}
