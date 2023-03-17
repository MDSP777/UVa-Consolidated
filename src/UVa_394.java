import java.util.HashMap;
import java.util.Scanner;


public class UVa_394 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		HashMap<String, Array> map = new HashMap<>();
		while(n-->0){
			String str = sc.next();
			int b = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			int[] l = new int[d];
			int[] u = new int[d];
			for(int i=0; i<d; i++){
				l[i] = sc.nextInt();
				u[i] = sc.nextInt();
			}
			map.put(str, new Array(b, s, d, l, u));
		}
		while(q-->0){
			String str = sc.next();
			Array a = map.get(str);
			int[] x = new int[a.d];
			for(int i=0; i<a.d; i++) x[i] = sc.nextInt();
			int res = a.c[0];
			for(int i=0; i<x.length; i++) res+=a.c[i+1]*x[i];
			StringBuilder sb = new StringBuilder();
			sb.append(str).append("[").append(x[0]);
			for(int i=1; i<x.length; i++) sb.append(", ").append(x[i]);
			sb.append("] = ").append(res);
			System.out.println(sb);
		}
	}
	
	static class Array {
		int b;
		int d;
		int[] l;
		int[] u;
		int[] c;
		
		public Array(int b, int s, int d, int[] l, int[] u){
			this.b = b;
			this.d = d;
			this.l = l;
			this.u = u;
			c = new int[d+1];
			c[d] = s;
			for(int i=d-1; i>=1; i--) c[i] = c[i+1]*(u[i]-l[i]+1);
			c[0] = b;
			for(int i=0; i<d; i++) c[0]-=c[i+1]*l[i];
		}
	}
}
