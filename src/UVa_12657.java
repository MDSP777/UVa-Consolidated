import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVa_12657 {
	static Node head, tail;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(true) {
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			String[] split = s.split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			
			boolean flipped = false;
			head = new Node(1);
			tail = head;
			Node[] nodes = new Node[n+1];
			nodes[1] = head;
			for(int i=2; i<=n; i++) {
				Node cur = new Node(i);
				nodes[i] = cur;
				tail.next = cur;
				cur.prev = tail;
				tail = cur;
			}
			
			while(m-->0) {
				split = br.readLine().split(" ");
				int c = Integer.parseInt(split[0]);
				if(c==1) {
					int x = Integer.parseInt(split[1]);
					int y = Integer.parseInt(split[2]);
					Node X = nodes[x];
					Node Y = nodes[y];
					if(!flipped) {
						if(Y.prev==X) continue;
						delete(X);
						insertBehind(Y, X);
					} else {
						if(Y.next==X) continue;
						delete(X);
						insertInFront(Y, X);
					}
				} else if(c==2) {
					int x = Integer.parseInt(split[1]);
					int y = Integer.parseInt(split[2]);
					Node X = nodes[x];
					Node Y = nodes[y];
					if(!flipped) {
						if(Y.next==X) continue;
						delete(X);
						insertInFront(Y, X);
					} else {
						if(Y.prev==X) continue;
						delete(X);
						insertBehind(Y, X);
					}
				} else if(c==3) {
					int x = Integer.parseInt(split[1]);
					int y = Integer.parseInt(split[2]);
					Node X = nodes[x];
					Node Y = nodes[y];
					int temp = X.val;
					X.val = Y.val;
					Y.val = temp;
					nodes[X.val] = X;
					nodes[Y.val] = Y;
				} else {
					flipped = !flipped;
				}
			}
			long ans = 0;
			if(!flipped) {
				int i = 1;
				Node cur = head;
				while(cur!=null) {
					if((i&1)==1)
						ans+=cur.val;
					cur = cur.next;
					i++;
				}
			} else {
				int i = 1;
				Node cur = tail;
				while(cur!=null) {
					if((i&1)==1)
						ans+=cur.val;
					cur = cur.prev;
					i++;
				}
			}
			sb.append("Case ").append(tc++).append(": ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static void print(Node cur) {
		while(cur!=null) {
			cur = cur.next;
		}
		System.out.println();
	}
	
	static void delete(Node x) {
		if(x.prev!=null) 
			x.prev.next = x.next;
		if(x.next!=null) 
			x.next.prev = x.prev;
		
		if(x==head) head = x.next;
		if(x==tail) tail = x.prev;
		x.next = x.prev = null;
	}
	
	static void insertBehind(Node cur, Node x) {
		x.next = cur;
		x.prev = cur.prev;
		if(cur.prev!=null) 
			cur.prev.next = x;
		cur.prev = x;
		if(cur==head) head = x;
	}
	
	static void insertInFront(Node cur, Node x) {
		x.prev = cur;
		x.next = cur.next;
		if(cur.next!=null)
			cur.next.prev = x;
		cur.next = x;
		if(cur==tail) tail = x;
	}
	
	static class Node {
		int val;
		Node next, prev;
		
		Node(int v){
			val = v;
		}
	}
}
