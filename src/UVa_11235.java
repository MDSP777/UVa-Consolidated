import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVa_11235 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s.equals("0")) break;
			String[] split = s.split("\\s+");
			int n = Integer.parseInt(split[0]);
			int q = Integer.parseInt(split[1]);
			split = br.readLine().split("\\s+");
			int[] terms = new int[n];
			int[] start = new int[n];
			int[] end = new int[n];
			for(int i=0; i<n; i++) end[i] = -1;
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i=0; i<n; i++) {
				terms[i] = Integer.parseInt(split[i]);
				if(!map.containsKey(terms[i])) {
					map.put(terms[i], 1);
					start[i] = i;
					if(i>0) end[i-1] = i-1;
				} else {
					map.put(terms[i], map.get(terms[i])+1);
					start[i] = start[i-1];
				}
			}
			end[n-1] = n-1;
			int[] freq = new int[n];
			for(int i=n-1; i>=0; i--) {
				freq[i] = map.get(terms[i]);
				if(end[i]==-1) end[i] = end[i+1];
			}
			SegmentTree st = new SegmentTree(freq);
			while(q-->0) {
				split = br.readLine().split("\\s+");
				int l = Integer.parseInt(split[0])-1;
				int r = Integer.parseInt(split[1])-1;
				if(terms[l]==terms[r]) sb.append(r-l+1).append("\n");
				else {
					int ans = Math.max(freq[st.rmq(l, end[l])]-(l-start[l]), freq[st.rmq(start[r], r)]-(end[r]-r));
					if(end[l]+1<=start[r]-1) ans = Math.max(ans, freq[st.rmq(end[l]+1, start[r]-1)]);
					sb.append(ans).append("\n");
				}
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
			build(1, 0 , terms.length-1);
		}
		
		int left(int p) {
			return p<<1;
		}
		
		int right(int p) {
			return (p<<1)+1;
		}
		
		void build(int p, int l, int r) {
			if(l==r) st[p] = l;
			else {
				int mid = (l+r)/2;
				build(left(p), l, mid);
				build(right(p), mid+1, r);
				int p1 = st[left(p)];
				int p2 = st[right(p)];
				st[p] = terms[p1]>=terms[p2] ? p1 : p2; 
			}
		}
		
		int rmq(int p, int l, int r, int i, int j) {
			if(i>r || j<l) return -1;
			if(i<=l && r<=j) return st[p];
			int mid = (l+r)/2;
			int p1 = rmq(left(p), l, mid, i, j);
			int p2 = rmq(right(p), mid+1, r, i, j);
			if(p1==-1) return p2;
			if(p2==-1) return p1;
			return terms[p1]>=terms[p2] ? p1 : p2;
		}
		
		int rmq(int i, int j) {
			return rmq(1, 0, terms.length-1, i, j);
		}
	}
}
