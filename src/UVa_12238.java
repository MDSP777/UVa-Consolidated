import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class UVa_12238 {
	static int[] H, E, L;
	static long[] path;
	static int idx;
	static Node[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			tree = new Node[n];
			tree[0] = new Node(-1, 0);
			for(int i=1; i<n; i++){
				String[] split = br.readLine().split(" ");
				int a = Integer.parseInt(split[0]);
				int b = Integer.parseInt(split[1]);
				tree[i] = new Node(a, b);
			}
			for(int i=1; i<n; i++){
				tree[tree[i].parent].children.put(i, tree[i].parentWeight);
			}
			H = new int[n];
			E = new int[2*n-1];
			L = new int[2*n-1];
			path = new long[n];
			idx = 0;
			Arrays.fill(H, -1);
//			dfs(0, 0);
			dfsIterative();
//			System.out.println(Arrays.toString(H));
			
			SparseTable st = new SparseTable(L);
			int q = Integer.parseInt(br.readLine());
			ArrayList<Long> ans = new ArrayList<>();
			while(q-->0){
				String[] split = br.readLine().split(" ");
				int l = Integer.parseInt(split[0]);
				int r = Integer.parseInt(split[1]);
				if(H[l]>H[r]){
					int temp = l;
					l = r;
					r = temp;
				}
				int lca = E[st.rmq(H[l], H[r])];
				ans.add(path[l]+path[r]-2*path[lca]);
//				System.out.println(path[l]+path[r]-2*path[lca]);
			}
			sb.append(ans.get(0));
			for(int i=1; i<ans.size(); i++)
				sb.append(" ").append(ans.get(i));
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static void dfs(int cur, int depth){
		if(cur>0){
			path[cur]+=path[tree[cur].parent]+tree[cur].parentWeight;
		}
		
		H[cur] = idx;
		E[idx] = cur;
		L[idx++] = depth;
		
		for(int next : tree[cur].children.keySet()){
			dfs(next, depth+1);
			E[idx] = cur;
			L[idx++] = depth;
		}
	}
	
	static void dfsIterative(){
		Stack<State> stack = new Stack<>();
		stack.add(new State(0, 0, false));
		
		while(!stack.isEmpty()){
			State cur = stack.pop();
			
			if(cur.isBack){
				E[idx] = cur.cur;
				L[idx++] = cur.depth;
				continue;
			}
			
			if(cur.cur>0){
				path[cur.cur]+=path[tree[cur.cur].parent]+tree[cur.cur].parentWeight;
			}
			
			Node node = tree[cur.cur];
			H[cur.cur] = idx;
			E[idx] = cur.cur;
			L[idx++] = cur.depth;
			if(node.parent!=-1) 
				stack.add(new State(node.parent, cur.depth-1, true));
			
			for(int next : node.children.keySet()){
				stack.add(new State(next, cur.depth+1, false));
			}
		}
		
//		if(cur>0){
//			path[cur]+=path[tree[cur].parent]+tree[cur].parentWeight;
//		}
//		
//		H[cur] = idx;
//		E[idx] = cur;
//		L[idx++] = depth;
//		
//		for(int next : tree[cur].children.keySet()){
//			dfs(next, depth+1);
//			E[idx] = cur;
//			L[idx++] = depth;
//		}
	}
	
	static int log2(int x){
		return (int) (Math.log10(x)/Math.log10(2));
	}
	
	static class State {
		int cur, depth;
		boolean isBack;
		
		State(int a, int b, boolean c){
			cur = a;
			depth = b;
			isBack = c;
		}
		
		
	}
	
	static class Node {
		int parent, parentWeight;
		HashMap<Integer,Integer> children;
		
		Node(int p, int w){
			parent = p;
			parentWeight = w;
			children = new HashMap<>();
		}
		
		void add(int child, int val){
			children.put(child, val);
		}
	}
	
	static class SparseTable {
		int[][] table;
		int[] arr;
		
		SparseTable(int[] arr){
			this.arr = arr;
			int n = arr.length;
			int x = log2(n)+1;
			if(n==(1<<x)) x++;
			
			table = new int[x][n];
			for(int i=0; i<n; i++) 
				table[0][i] = i;
			for(int i=1; i<x; i++){
				int rangeSize = 1<<i;
				for(int j=0; j<n-rangeSize+1; j++){
					int u = table[i-1][j];
					int v = table[i-1][j+rangeSize/2];
					table[i][j] = arr[u]<arr[v] ? u : v;
				}
			}
		}
		
		int rmq(int l, int r){
			int len = r-l+1;
			int x = log2(len);
			int p = 1<<x;
			if(p==len) return table[x][l];
			int u = table[x][l];
			int v = table[x][r-p+1];
			return arr[u]<arr[v] ? u : v;
		}
	}
}
