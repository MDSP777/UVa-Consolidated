import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_12086 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x = 1;
		boolean first = true;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			if(first) first = false;
			else sb.append("\n");
			int[] terms = new int[n];
			for(int i=0; i<n; i++) terms[i] = Integer.parseInt(br.readLine());
			SegmentTree st = new SegmentTree(terms);
			sb.append("Case ").append(x++).append(":\n");
			while(true) {
				String s = br.readLine();
				if(s.equals("END")) break;
				String[] split = s.split("\\s+");
				if(split[0].equals("S")) st.update(Integer.parseInt(split[1])-1, Integer.parseInt(split[2]));
				else sb.append(st.rsq(Integer.parseInt(split[1])-1, Integer.parseInt(split[2])-1)).append("\n");
			}
		}
		System.out.print(sb);
	}
	
	static class SegmentTree {
		int[] terms;
		int[] st;
		
		public SegmentTree(int[] terms) {
			this.terms = terms;
			st = new int[4*terms.length];
			build(1, 0, terms.length-1);
		}
		
		void build(int p, int l, int r) {
			if(l==r) st[p] = terms[l];
			else {
				int mid = (l+r)/2;
				build(p<<1, l, mid);
				build((p<<1)+1, mid+1, r);
				st[p] = st[p<<1]+st[(p<<1)+1];
			}
		}
		
		void update(int p, int l, int r, int index, int val) {
			if(l==r && l==index) st[p] = val;
			else {
				int mid = (l+r)/2;
				if(l<=index && index<=mid) update(p<<1, l, mid, index, val);
				else update((p<<1)+1, mid+1, r, index, val);
				st[p] = st[p<<1]+st[(p<<1)+1];
			}
		}
		
		void update(int index, int val) {
			terms[index] = val;
			update(1, 0, terms.length-1, index, val);
		}
		
		int rsq(int p, int l, int r, int i, int j) {
			if(i>r || j<l) return 0;
			if(i<=l && r<=j) return st[p];
			int mid = (l+r)/2;
			return rsq(p<<1, l, mid, i, j)+rsq((p<<1)+1, mid+1, r, i, j);
		}
		
		int rsq(int i, int j) {
			return rsq(1, 0, terms.length-1, i, j);
		}
	}
}
