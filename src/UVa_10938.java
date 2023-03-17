import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.LinkedList;


public class UVa_10938 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			Node[] nodes = new Node[n];
			ArrayList<Integer>[] e = new ArrayList[n];
			for(int i=0; i<n; i++) {
				nodes[i] = new Node(i);
				e[i] = new ArrayList<>();
			}
			for(int i=1; i<n; i++){
				String[] split = br.readLine().split(" ");
				int a = Integer.parseInt(split[0])-1;
				int b = Integer.parseInt(split[1])-1;
				e[a].add(b);
				e[b].add(a);
			}
			LinkedList<Integer> qu = new LinkedList<>();
			BitSet visited = new BitSet();
			qu.add(0);
			visited.set(0);
			while(!qu.isEmpty()){
				int cur = qu.poll();
				for(int next: e[cur]){
					if(!visited.get(next)){
						nodes[next].parent = nodes[cur];
						nodes[cur].children.add(nodes[next]);
						qu.add(next);
						visited.set(next);
					}
				}
			}
			int q = Integer.parseInt(br.readLine());
			while(q-->0){
				String[] split = br.readLine().split(" ");
				int a = Integer.parseInt(split[0])-1;
				int b = Integer.parseInt(split[1])-1;
				int u = Math.min(a, b);
				int v = Math.max(a, b);
				int[] p1Index = new int[5050];
				Arrays.fill(p1Index, -1);
				int ctr = 0;
				ArrayList<Integer> p1 = new ArrayList<>();
				ArrayList<Integer> p2 = new ArrayList<>();
				p1.add(u);
				p1Index[u] = ctr++;
				while(nodes[u].parent!=null){
					u = nodes[u].parent.val;
					p1.add(u);
					p1Index[u] = ctr++;
				}
				int lca = -1;
				p2.add(v);
				if(p1Index[v]!=-1) lca = v;
				while(lca==-1 && nodes[v].parent!=null){
					v = nodes[v].parent.val;
					p2.add(v);
					if(p1Index[v]!=-1) lca = v;
				}
				List<Integer> temp = p1.subList(0, p1Index[lca]);
				Collections.reverse(temp);
				p2.addAll(temp);
				if(p2.size()%2==1) sb.append("The fleas meet at "+(p2.get(p2.size()/2)+1)+".\n");
				else {
					a = p2.get(p2.size()/2)+1;
					b = p2.get(p2.size()/2-1)+1;
					int l = Math.min(a, b);
					int r = Math.max(a, b);
					sb.append("The fleas jump forever between "+l+" and "+r+".\n");
				}
			}
		}
		System.out.print(sb);
	}
	
	static class Node {
		int val;
		Node parent;
		ArrayList<Node> children;
		
		Node(int v){
			val = v;
			parent = null;
			children = new ArrayList<>();
		}
	}
}
