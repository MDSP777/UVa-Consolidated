import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_11297 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		SegmentTree[] st = new SegmentTree[n];
		for(int i=0; i<n; i++) {
			long[] terms = new long[n];
			String[] split = br.readLine().split("\\s+");
			for(int j=0; j<n; j++) terms[j] = Long.parseLong(split[j]);
			st[i] = new SegmentTree(terms);
		}
		ST2D st2d = new ST2D(st);
		int q = Integer.parseInt(br.readLine());
		while(q-->0) {
			String[] split = br.readLine().split("\\s+");
			if(split[0].equals("q")) {
				SegmentTree cur = st2d.q(Integer.parseInt(split[1])-1, Integer.parseInt(split[3])-1);
				int l = Integer.parseInt(split[2])-1;
				int r = Integer.parseInt(split[4])-1;
				sb.append(cur.max(l, r)).append(" ").append(cur.min(l, r)).append("\n");
			} else {
				SegmentTree cur = st2d.q(Integer.parseInt(split[1])-1, Integer.parseInt(split[1])-1);
				cur.update(Integer.parseInt(split[2])-1, Long.parseLong(split[3]));
				st2d.update(Integer.parseInt(split[1])-1);
			}
		}
		System.out.print(sb);
	}
	
	static class ST2D {
		SegmentTree[] terms;
		SegmentTree[] st;
		
		public ST2D(SegmentTree[] terms) {
			this.terms = terms;
			st = new SegmentTree[4*terms.length];
			build(1, 0, terms.length-1);
		}
		
		void build(int p, int l, int r) {
			if(l==r) st[p] = terms[l];
			else {
				int mid = (l+r)/2;
				build(p<<1, l, mid);
				build((p<<1)+1, mid+1, r);
				st[p] = new SegmentTree(st[p<<1], st[(p<<1)+1]);
			}
		}
		
		void update(int p, int l, int r, int i) {
			if(l==r && l==i) return;
			int mid = (l+r)/2;
			if(l<=i && i<=mid) update(p<<1, l, mid, i);
			else update((p<<1)+1, mid+1, r, i);
			st[p] = new SegmentTree(st[p<<1], st[(p<<1)+1]);
		}
		
		void update(int i) {
			update(1, 0, terms.length-1, i);
		}
		
		SegmentTree q(int p, int l, int r, int i, int j) {
			if(r<i || j<l) return null;
			if(i<=l && r<=j) return st[p];
			int mid = (l+r)/2;
			SegmentTree s1 = q(p<<1, l, mid, i, j);
			SegmentTree s2 = q((p<<1)+1, mid+1, r, i, j);
			if(s1==null) return s2;
			if(s2==null) return s1;
			return new SegmentTree(s1, s2);
		}
		
		SegmentTree q(int i, int j) {
			return q(1, 0, terms.length-1, i, j);
		}
	}
	
	static class SegmentTree {
		long[] terms;
		long[] minST;
		long[] maxST;
		
		public SegmentTree(long[] terms) {
			this.terms = terms;
			minST = new long[4*terms.length];
			maxST = new long[4*terms.length];
			build(1, 0, terms.length-1);
		}
		
		public SegmentTree(SegmentTree s1, SegmentTree s2) {
			terms = new long[s1.terms.length];
			minST = new long[s1.minST.length];
			maxST = new long[s1.maxST.length];
			for(int i=0; i<minST.length; i++) {
				minST[i] = Math.min(s1.minST[i], s2.minST[i]);
				maxST[i] = Math.max(s1.maxST[i], s2.maxST[i]);
			}
		}
		
		void build(int p, int l, int r) {
			if(l==r) minST[p] = maxST[p] = terms[l];
			else {
				int mid = (l+r)/2;
				build(p<<1, l, mid);
				build((p<<1)+1, mid+1, r);
				minST[p] = Math.min(minST[p<<1], minST[(p<<1)+1]);
				maxST[p] = Math.max(maxST[p<<1], maxST[(p<<1)+1]);
			}
		}
		
		void update(int p, int l, int r, int index, long val) {
			if(l==r && l==index) minST[p] = maxST[p] = val;
			else {
				int mid = (l+r)/2;
				if(l<=index && index<=mid) update(p<<1, l, mid, index, val);
				else update((p<<1)+1, mid+1, r, index, val);
				minST[p] = Math.min(minST[p<<1], minST[(p<<1)+1]);
				maxST[p] = Math.max(maxST[p<<1], maxST[(p<<1)+1]);
			}
		}
		
		void update(int index, long val) {
			terms[index] = val;
			update(1, 0, terms.length-1, index, val);
		}
		
		long min(int p, int l, int r, int i, int j) {
			if(i>r || j<l) return Long.MAX_VALUE;
			if(i<=l && r<=j) return minST[p];
			int mid = (l+r)/2;
			return Math.min(min(p<<1, l, mid, i, j), min((p<<1)+1, mid+1, r, i, j));
		}
		
		long max(int p, int l, int r, int i, int j) {
			if(i>r || j<l) return Long.MIN_VALUE;
			if(i<=l && r<=j) return maxST[p];
			int mid = (l+r)/2;
			return Math.max(max(p<<1, l, mid, i, j), max((p<<1)+1, mid+1, r, i, j));
		}
		
		long min(int i, int j) {
			return min(1, 0, terms.length-1, i, j);
		}
		
		long max(int i, int j) {
			return max(1, 0, terms.length-1, i, j);
		}
	}
}
