import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UVa_437 {
	static HashMap<Block, Long> dp;
	static ArrayList<Block> blocks;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nc = 1;
		while(true) {
			int nBlocks = Integer.parseInt(br.readLine());
			if(nBlocks==0) break;
			dp = new HashMap<>();
			blocks = new ArrayList<>();
			for(int i=0; i<nBlocks; i++) {
				String[] split = br.readLine().split("\\s+");
				int a = Integer.parseInt(split[0]);
				int b = Integer.parseInt(split[1]);
				int c = Integer.parseInt(split[2]);
				blocks.add(new Block(a, b, c));
				blocks.add(new Block(a, c, b));
				blocks.add(new Block(c, b, a));
			}
			Collections.sort(blocks);
			System.out.println("Case "+nc+++": maximum height = "+dp(new Block(0, 0, 0), 0));
		}
	}
	
	static long dp(Block prev, int index) {
		if(index==blocks.size()) return 0;
		if(dp.containsKey(prev)) return dp.get(prev);
		long max = dp(prev, index+1);
		if(blocks.get(index).greaterThan(prev)) max = Math.max(max, blocks.get(index).h+dp(blocks.get(index), index+1));
		dp.put(prev, max);
		return max;
	}
	
	static class Block implements Comparable<Block> {
		int l, w, h;
		
		public Block(int l, int w, int h) {
			this.l = Math.min(l, w);
			this.w = Math.max(l, w);
			this.h = h;
		}
		
		boolean greaterThan(Block o) {
			return this.l>o.l && this.w>o.w;
		}

		@Override
		public int compareTo(Block o) {
			if(this.l==o.l) return Integer.compare(this.w, o.w);
			return Integer.compare(this.l, o.l);
		}
		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + h;
			result = prime * result + l;
			result = prime * result + w;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Block other = (Block) obj;
			if (h != other.h)
				return false;
			if (l != other.l)
				return false;
			if (w != other.w)
				return false;
			return true;
		}
	}
}
