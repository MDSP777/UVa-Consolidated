import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class UVa_429 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		sc.nextLine();
		while(nC-->0) {
			ArrayList<String> d = new ArrayList<>();
			while(true) {
				String s = sc.nextLine();
				if(s.equals("*")) break;
				d.add(s);
			}
			Collections.sort(d);
			ArrayList<Node> n = new ArrayList<>();
			for(int i=0; i<d.size(); i++) n.add(new Node(d.get(i)));
			for(int i=0; i<d.size(); i++) {
				for(int j=i+1; j<d.size(); j++)
					if(oneDist(n.get(i).id, n.get(j).id)) {
						n.get(i).next.add(j);
						n.get(j).next.add(i);
					}
			}
			while(true) {
				if(!sc.hasNext()) break;
				String s = sc.nextLine();
				if(s==null || s.isEmpty()) break;
				String[] split = s.split(" ");
				String a = split[0];
				String b = split[1];
				LinkedList<Node> q = new LinkedList<>();
				boolean[] visited = new boolean[d.size()];
				for(int i=0; i<n.size(); i++) n.get(i).depth = 0;
				int ans = 0;
				int srcIndex = Collections.binarySearch(d, a);
				q.add(n.get(srcIndex));
				if(a.equals(b)) ans = 0;
				else
					while(!q.isEmpty()) {
						Node cur = q.poll();
						boolean found = false;
						for(int i=0; i<cur.next.size(); i++) {
							if(d.get(cur.next.get(i)).equals(b)) {
								ans = cur.depth+1;
								found = true;
								break;
							}
							if(!visited[cur.next.get(i)]) {
								visited[cur.next.get(i)] = true;
								Node next = n.get(cur.next.get(i));
								next.depth = cur.depth+1;
								q.add(next);
							}
						}
						if(found) break;
					}
				System.out.println(a+" "+b+" "+ans);
			}
			if(nC>0) System.out.println();
		}
	}
	
	private static boolean oneDist(String a, String b) {
		int total = 0;
		if(a.length()!=b.length()) return false;
		for(int i=0; i<a.length(); i++)
			if(a.charAt(i)!=b.charAt(i)) total++;
		return total==1;
	}

	static class Node {
		String id;
		ArrayList<Integer> next;
		int depth;
		
		public Node(String id) {
			this.id = id;
			next = new ArrayList<>();
		}
	}
}
