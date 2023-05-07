import java.io.InputStreamReader;
import java.io.BufferedReader;

public class UVa_12299 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int q = Integer.parseInt(split[1]);
		
		int[] arr = new int[n];
		split = br.readLine().split(" ");
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(split[i]);
		
		SegmentTree st = new SegmentTree(arr);
		
		while(q-->0) {
			split = br.readLine().split("\\(");
			split[1] = split[1].substring(0, split[1].length()-1);
			if(split[0].startsWith("q")) {
				split = split[1].split(",");
				int l = Integer.parseInt(split[0])-1;
				int r = Integer.parseInt(split[1])-1;
				sb.append(st.rmq(l, r)).append("\n");
			} else {
				split = split[1].split(",");
				int[] shifts = new int[split.length];
				for(int i=0; i<split.length; i++) shifts[i] = Integer.parseInt(split[i])-1;
				
				int temp = st.terms[shifts[0]];
				for(int i=1; i<shifts.length; i++) 
					st.update(shifts[i-1], st.terms[shifts[i]]);
				
				st.update(shifts[shifts.length-1], temp);
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
				st[p] = Math.min(st[p<<1], st[(p<<1)+1]);
			}
		}
		
		void update(int p, int l, int r, int index, int val) {
			if(l==r && l==index) st[p] = val;
			else {
				int mid = (l+r)/2;
				if(l<=index && index<=mid) update(p<<1, l, mid, index, val);
				else update((p<<1)+1, mid+1, r, index, val);
				st[p] = Math.min(st[p<<1], st[(p<<1)+1]);
			}
		}
		
		void update(int index, int val) {
			terms[index] = val;
			update(1, 0, terms.length-1, index, val);
		}
		
		int rmq(int p, int l, int r, int i, int j) {
			if(i>r || j<l) return Integer.MAX_VALUE;
			if(i<=l && r<=j) return st[p];
			int mid = (l+r)/2;
			return Math.min(rmq(p<<1, l, mid, i, j), rmq((p<<1)+1, mid+1, r, i, j));
		}
		
		int rmq(int i, int j) {
			return rmq(1, 0, terms.length-1, i, j);
		}
	}
}
