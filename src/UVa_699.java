import java.util.Scanner;
import java.util.TreeMap;

public class UVa_699 {
	static TreeMap<Integer, Integer> piles;
	static Scanner sc;
	
	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true) {
			int root = sc.nextInt();
			if(root==-1) break;
			
			piles = new TreeMap<>();
			piles.put(0, root);
			
//			Alternate stack-based traversal (no recursion):
//			Stack<Integer> st = new Stack<>();
//			st.push(1);
//			st.push(-1);
//			while(!st.isEmpty()) {
//				int col = st.pop();
//				int cur = sc.nextInt();
//				if(cur==-1) continue;
//				if(!piles.containsKey(col)) piles.put(col, 0);
//				piles.put(col, piles.get(col)+cur);
//				st.push(col+1);
//				st.push(col-1);
//			}
			
			traverse(-1);
			traverse(1);
			boolean first = true;
			sb.append("Case ").append(t++).append(":\n");
			for(int key : piles.keySet()) {
				if(first) first = false;
				else sb.append(" ");
				sb.append(piles.get(key));
			}
			sb.append("\n\n");
		}
		System.out.print(sb);
	}
	
	static void traverse(int col) {
		int cur = sc.nextInt();
		if(cur==-1) return;
		if(!piles.containsKey(col)) piles.put(col, 0);
		piles.put(col, piles.get(col)+cur);
		traverse(col-1);
		traverse(col+1);
	}
}
