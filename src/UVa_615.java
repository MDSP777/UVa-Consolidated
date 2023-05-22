import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class UVa_615 {
	static HashMap<Integer, ArrayList<Integer>> ed;
	static HashSet<Integer> visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true) {
			HashMap<Integer, Integer> parent = new HashMap<>();
			ed = new HashMap<>();
			int e = 0;
			while(true) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(a<0) return;
				if(a==0) break;

				if(!parent.containsKey(a)) {
					parent.put(a, 0);
					ed.put(a, new ArrayList<Integer>());
				}
				if(!parent.containsKey(b)) {
					parent.put(b, 0);
					ed.put(b, new ArrayList<Integer>());
				}
				parent.put(b, parent.get(b)+1);
				ed.get(a).add(b);
				e++;
			}
			
			int zero = 0;
			int two = 0;
			int root = -1;
			for(int key : parent.keySet())
				if(parent.get(key)==0) {
					zero++;
					root = key;
				} else if(parent.get(key)>1) two++;
			
			visited = new HashSet<>();
			if(e==0 || (e==parent.size()-1 && zero==1 && two==0 && dfs(root)==parent.size())) System.out.println("Case "+tc+++" is a tree.");
			else System.out.println("Case "+tc+++" is not a tree.");
		}
	}
	
	static int dfs(int cur) {
		int total = 1;
		visited.add(cur);
		for(int next : ed.get(cur))
			if(!visited.contains(next)) total+=dfs(next);
		return total;
	}
}
