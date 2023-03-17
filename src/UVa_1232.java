import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVa_1232 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			int n = Integer.parseInt(br.readLine());
			int[] l = new int[n];
			int[] r = new int[n];
			int[] h = new int[n];
			int s = 0;
			for(int i=0; i<n; i++) {
				String[] split = br.readLine().split("\\s+");
				l[i] = Integer.parseInt(split[0]);
				r[i] = Integer.parseInt(split[1]);
				h[i] = Integer.parseInt(split[2]);
				s = Math.max(s, r[i]);
			}
			SegmentTree st = new SegmentTree(s);
			int overlap = 0;
			for(int i=0; i<n; i++) overlap+=st.update(l[i], r[i]-1, h[i]);
			System.out.println(overlap);
		}
	}
	
	static class SegmentTree {
		int n;
		int[] maxST;
		int[] minST;
		int[] lazy;
		
		public SegmentTree(int n) {
			this.n = n;
			maxST = new int[4*n];
			minST = new int[4*n];
			lazy = new int[4*n];
		}
		
		int update(int p, int l, int r, int i, int j, int val) {
			if(l>r || r<i || l>j) return 0;
			if(lazy[p]!=0) {
				if(l==r) minST[p] = maxST[p] = lazy[p];
				else {
					minST[p] = Math.min(minST[p], lazy[p]);
					maxST[p] = Math.max(maxST[p], lazy[p]);
				}
				if(l!=r) lazy[p<<1] = lazy[(p<<1)+1] = lazy[p];
				lazy[p] = 0;
			}
			if(i<=l && r<=j) {
				if(minST[p]==maxST[p] && minST[p]>val) return 0;
				else if(minST[p]==maxST[p] && minST[p]<=val) {
					minST[p] = maxST[p] = val;
					if(l!=r) lazy[p<<1] = lazy[(p<<1)+1] = val;
					return r-l+1;
				} 
			}
			int mid = (l+r)/2;
			int ans = update(p<<1, l, mid, i, j, val)+update((p<<1)+1, mid+1, r, i, j, val);
			minST[p] = Math.min(minST[p<<1], minST[(p<<1)+1]);
			maxST[p] = Math.max(maxST[p<<1], maxST[(p<<1)+1]);
			return ans;
		}
		
		int update(int i, int j, int val) {
			return update(1, 0, n-1, i, j, val);
		}
	}
}
