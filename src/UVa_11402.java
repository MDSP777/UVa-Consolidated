import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UVa_11402 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nC = Integer.parseInt(br.readLine());
		for(int x=1; x<=nC; x++) {
			sb.append("Case ").append(x).append(":\n");
			int nChunks = Integer.parseInt(br.readLine());
			int[] rep = new int[nChunks];
			String[] chunks = new String[nChunks];
			int size = 0;
			for(int i=0; i<nChunks; i++) {
				rep[i] = Integer.parseInt(br.readLine());
				chunks[i] = br.readLine();
				size+=rep[i]*chunks[i].length();
			}
			int[] terms = new int[size];
			int index = 0;
			for(int i=0; i<nChunks; i++) {
				for(int j=0; j<rep[i]; j++)
					for(int k=0; k<chunks[i].length(); k++) terms[index++] = chunks[i].charAt(k)-'0';
			}
			int nQ = Integer.parseInt(br.readLine());
			SegmentTree st = new SegmentTree(terms);
			int i = 1;
			while(nQ-->0) {
				String[] split = br.readLine().split("\\s+");
				if(split[0].equals("S")) sb.append("Q").append(i++).append(": ").append(st.rsq(Integer.parseInt(split[1]), Integer.parseInt(split[2]))).append("\n");
				else {
					int type = split[0].equals("F") ? 1 : split[0].equals("E") ? 0 : 2;
					st.update(Integer.parseInt(split[1]), Integer.parseInt(split[2]), type);
				}
			}
		}
		System.out.print(sb);
	}

// Reference for implementing Segment Trees with Lazy Propagation
// https://www.hackerearth.com/practice/notes/segment-tree-and-lazy-propagation/ 
	static class SegmentTree {
		int[] terms;
		int[] st;
		int[] lazy;
		
		public SegmentTree(int[] terms) {
			this.terms = terms;
			st = new int[4*terms.length];
			lazy = new int[4*terms.length];
			Arrays.fill(lazy, -1);
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
		
		void update(int p, int l, int r, int i, int j, int val) {
			if(lazy[p]!=-1) {
				if(lazy[p]==0) st[p] = 0;
				else if(lazy[p]==1) st[p] = r-l+1;
				else if(lazy[p]==2) st[p] = r-l+1-st[p];
				if(l!=r) {
					if(lazy[p]!=2) {
						lazy[p<<1] = lazy[p];
						lazy[(p<<1)+1] = lazy[p];
					} else {
						lazy[p<<1] = lazy[p<<1]==-1 ? 2 : lazy[p<<1]==0 ? 1: lazy[p<<1]==1 ? 0 : -1;
						lazy[(p<<1)+1] = lazy[(p<<1)+1]==-1 ? 2 : lazy[(p<<1)+1]==0 ? 1: lazy[(p<<1)+1]==1 ? 0 : -1;
					}
				}
				lazy[p] = -1;
			}
			if(i>r || j<l) return;
			if(i<=l && r<=j) {
				if(val==0) st[p] = 0;
				else if(val==1) st[p] = r-l+1;
				else if(val==2) st[p] = r-l+1-st[p];
				if(l!=r) {
					if(val!=2) {
						lazy[p<<1] = val;
						lazy[(p<<1)+1] = val;
					} else {
						lazy[p<<1] = lazy[p<<1]==-1 ? 2 : lazy[p<<1]==0 ? 1: lazy[p<<1]==1 ? 0 : -1;
						lazy[(p<<1)+1] = lazy[(p<<1)+1]==-1 ? 2 : lazy[(p<<1)+1]==0 ? 1: lazy[(p<<1)+1]==1 ? 0 : -1;
					}
				}
				return;
			}
			int mid = (l+r)/2;
			update(p<<1, l, mid, i, j, val);
			update((p<<1)+1, mid+1, r, i, j, val);
			st[p] = st[p<<1]+st[(p<<1)+1];
		}
		
		void update(int i, int j, int val) {
			update(1, 0, terms.length-1, i, j, val);
		}
		
		int rsq(int p, int l, int r, int i, int j) {
			if(i>r || j<l) return 0;
			if(lazy[p]!=-1) {
				if(lazy[p]==0) st[p] = 0;
				else if(lazy[p]==1) st[p] = r-l+1;
				else if(lazy[p]==2) st[p] = r-l+1-st[p];
				if(l!=r) {
					if(lazy[p]!=2) {
						lazy[p<<1] = lazy[p];
						lazy[(p<<1)+1] = lazy[p];
					} else {
						lazy[p<<1] = lazy[p<<1]==-1 ? 2 : lazy[p<<1]==0 ? 1: lazy[p<<1]==1 ? 0 : -1;
						lazy[(p<<1)+1] = lazy[(p<<1)+1]==-1 ? 2 : lazy[(p<<1)+1]==0 ? 1: lazy[(p<<1)+1]==1 ? 0 : -1;
					}
				}
				lazy[p] = -1;
			}
			if(i<=l && r<=j) return st[p];
			int mid = (l+r)/2;
			return rsq(p<<1, l, mid, i, j)+rsq((p<<1)+1, mid+1, r, i, j);
		}
		
		int rsq(int i, int j) {
			return rsq(1, 0, terms.length-1, i, j);
		}
	}
}
