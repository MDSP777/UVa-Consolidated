import java.util.Scanner;

public class UVa_12720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int MOD = 1000000007;
		for(int t=1; t<=tc; t++) {
			String s = sc.next();
			int l = s.length();
			int ans = 0;
			boolean isOdd = s.length()%2==1;
			Node a = null, b = null;
			LinkedList ll = new LinkedList();
			for(int i=0; i<l; i++) {
				Node n = new Node(s.charAt(i)-'0', i);
				if(i==l/2) a = b = n;
				ll.add(n);
			}
			if(l==1) ans = s.charAt(0)-'0';
			if(!isOdd) a = b.prev;
			for(int i=0; i<l-1; i++) {
				if(i==l-2) {
					if(a.val==1) {
						ans*=2;
						ans+=a.val;
						ans%=MOD;
						ans*=2;
						ans+=b.val;
						ans%=MOD;
					} else if(b.val==1) {
						ans*=2;
						ans+=b.val;
						ans%=MOD;
						ans*=2;
						ans+=a.val;
						ans%=MOD;
					} else {
						ans*=2;
						ans%=MOD;
						ans*=2;
						ans%=MOD;
					}
					break;
				}
				int toAdd = 0;
				if(isOdd) {
					toAdd = a.val;
					a = a.prev;
					b = b.next;
					a.next = b;
					b.prev = a;
				} else {
					if(a.val==b.val || a.val==1) {
						toAdd = a.val;
						a.prev.next = a.next;
						a.next.prev = a.prev;
						a = b;
					} else {
						toAdd = b.val;
						b.prev.next = b.next;
						b.next.prev = b.prev;
						b = a;
					}
				}
				ans*=2;
				ans+=toAdd;
				ans%=MOD;
				isOdd = !isOdd;
			}
			System.out.println("Case #"+t+": "+ans);
		}
	}
	
	static class LinkedList {
		Node head, tail;
		
		LinkedList() {
			head = tail = null;
		}
		
		void add(Node n) {
			if(head==null) {
				head = tail = n;
			} else {
				tail.next = n;
				n.prev = tail;
				tail = n;
			}
		}
	}
	
	static class Node {
		int val, index;
		Node prev, next;
		
		Node(int v, int i){
			val = v;
			index = i;
			prev = next = null;
		}
	}
}
