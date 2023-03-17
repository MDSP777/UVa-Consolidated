import java.util.Scanner;
import java.util.Stack;

public class UVa_10017 {
	static int n, m, ctr;
	static Stack<Integer>[] st;
	static StringBuilder sb;
	static char[] p = {'A', 'B', 'C'};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		sb = new StringBuilder();
		while(true) {
			n = sc.nextInt();
			m = sc.nextInt();
			if(n==0 && m==0) break;
			ctr = 0;
			st = new Stack[3];
			st[0] = new Stack<>();
			st[1] = new Stack<>();
			st[2] = new Stack<>();
			for(int i=n; i>0; i--) st[0].add(i);
			sb.append("Problem #").append(t++).append("\n\n");
			out();
			f(n, 0, 2);
		}
		System.out.print(sb);
	}
	
	static void f(int v, int from, int to) {
		if(ctr==m) return;
		if(v==1) {
			move(from, to);
			return;
		}
		int temp = rem(from, to);
		f(v-1, from, temp);
		move(from, to);
		f(v-1, temp, to);
	}
	
	static int rem(int a, int b) {
		return 3-a-b;
	}
	
	static void move(int from, int to) {
		if(ctr==m) return;
		st[to].add(st[from].pop());
		ctr++;
		out();
	}
	
	static void out() {
		for(int x=0; x<3; x++) {
			sb.append(p[x]).append("=>");
			if(!st[x].isEmpty()) sb.append("  ");
			for(int i=0; i<st[x].size(); i++) sb.append(" ").append(st[x].get(i));
			sb.append("\n");
		}
		sb.append("\n");
	}
}
