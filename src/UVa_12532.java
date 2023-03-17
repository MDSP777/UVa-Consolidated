import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_12532 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringBuilder sb = new StringBuilder();
			String s = br.readLine();
			if(s==null) break;
			String[] split = s.split("\\s+");
			int nQ = Integer.parseInt(split[1]);
			split = br.readLine().split("\\s+");
			int[] terms = new int[split.length];
			for(int i=0; i<split.length; i++) {
				int cur = Integer.parseInt(split[i]);
				if(cur==0) terms[i] = 0;
				else if(cur<0) terms[i] = -1;
				else terms[i] = 1;
			}
			SegmentTree st = new SegmentTree(terms);
			while(nQ-->0) {
				split = br.readLine().split("\\s+");
				if(split[0].equals("C")) {
					int cur = Integer.parseInt(split[2]);
					if(cur<0) cur = -1;
					else if(cur>0) cur = 1;
					st.update(Integer.parseInt(split[1])-1, cur);
				} else {
					int ans = st.rpq(Integer.parseInt(split[1])-1, Integer.parseInt(split[2])-1);
					if(ans==0) sb.append("0");
					else if(ans<0) sb.append("-");
					else sb.append("+");
				}
			}
			System.out.println(sb);
		}
	}
	
	static class SegmentTree {
		int[] terms;
		int[] st;
		
		public SegmentTree(int[] terms) {
			this.terms = terms;
			this.st = new int[4*terms.length];
			build(1, 0, terms.length-1);
		}
		
		void build(int p, int l, int r) {
			if(l==r) st[p] = terms[l];
			else {
				int mid = (l+r)/2;
				build(p<<1, l, mid);
				build((p<<1)+1, mid+1, r);
				st[p] = st[p<<1]*st[(p<<1)+1];
			}
		}
		
		void update(int p, int l, int r, int index, int val) {
			if(l==r && l==index) st[p] = val;
			else {
				int mid = (l+r)/2;
				if(l<=index && index<=mid) update(p<<1, l, mid, index, val);
				else update((p<<1)+1, mid+1, r, index, val);
				st[p] = st[p<<1]*st[(p<<1)+1];
			}
		}
		
		void update(int index, int val) {
			terms[index] = val;
			update(1, 0, terms.length-1, index, val);
		}
		
		int rpq(int p, int l, int r, int i, int j) {
			if(i>r || j<l) return 1;
			if(i<=l && r<=j) return st[p];
			int mid = (l+r)/2;
			return rpq(p<<1, l, mid, i, j)*rpq((p<<1)+1, mid+1, r, i, j);
		}
		
		int rpq(int i, int j) {
			return rpq(1, 0, terms.length-1, i, j);
		}
	}
}
