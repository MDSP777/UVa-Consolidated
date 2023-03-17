import java.util.Scanner;

public class UVa_11988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int HEAD = 0;
		int MID = 1;
		int TAIL = 2;
		do {
			String line = sc.nextLine();
			LinkedList ll = new LinkedList();
			int cursor = TAIL;
			Node cur = null;
			for(int i=0; i<line.length(); i++) {
				char c = line.charAt(i);
				if (c=='[')
		            cursor = HEAD;
				else if (c==']')
		            cursor = TAIL;
		        else if (cursor==TAIL)
		            ll.addAtTail(c);
		        else if (cursor==HEAD) {
		            cur = ll.addAtHead(c);
		            cursor = MID;
		        } else
		            cur = ll.addInFrontOf(cur, c);
			}
			StringBuilder sb = new StringBuilder();
			cur = ll.head;
			while(cur!=null) {
				sb.append(cur.value);
				cur = cur.next;
			}
			System.out.println(sb);
		} while(sc.hasNext());
	}
	
	static class Node {
		char value;
		Node next;
		
		Node(char v){
			value = v;
		}
	}
	
	static class LinkedList {
		Node head, tail;
		
		LinkedList(){
			
		}
		
	    Node addAtTail(char value) {
	        Node toAdd = new Node(value);
	        if(head==null)
	            head = tail = toAdd;
	        else {
	            tail.next = toAdd;
	            tail = toAdd;
	        }
	        return toAdd;
	    }
	        		
	    Node addAtHead(char value) {
	        Node toAdd = new Node(value);
	        if (head==null)
	            head = tail = toAdd;
	        else {
	            toAdd.next = head;
	            head = toAdd;
	        }
	        return toAdd;
	    }

	    Node addInFrontOf(Node cur, char value) {
	        Node toAdd = new Node(value);
	        toAdd.next = cur.next;
	        cur.next = toAdd;
	        if(cur==tail)
	        	tail = toAdd;
	        return toAdd;
	    }
	}
}
