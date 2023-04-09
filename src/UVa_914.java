import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

// implemented Mo's Algorithm on Square Root Decomposition to solve general Range Mode Query
// seems to be overkill for the bounds of the prime range, but good implementation practice regardless
public class UVa_914 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int cap = 1000000;
		boolean[] sieve = new boolean[cap+1];
		TreeMap<Integer, Integer> primeMap = new TreeMap<>();
		int lastPrime = -1;
		ArrayList<Integer> diff = new ArrayList<>();
		int ctr = 0;
		for(int i=2; i<=cap; i++)
			if(!sieve[i]) {
				primeMap.put(i, ctr++);
				if(i>2) diff.add(i-lastPrime);
				lastPrime = i;
				for(int j=i+i; j<=cap; j+=i) sieve[j] = true;
			}
		
		int sqrt = (int) Math.ceil(Math.sqrt(diff.size()));
		int size = sqrt*sqrt;
		int filler = -1;
		while(diff.size()<size) diff.add(filler--);
		
		HashMap<Integer, Integer>[] blockFreq = new HashMap[sqrt];
		for(int i=0; i<sqrt; i++) blockFreq[i] = new HashMap<>();
		for(int i=0; i<size; i++) {
			HashMap<Integer, Integer> block = blockFreq[i/sqrt];
			int cur = diff.get(i);
			if(!block.containsKey(cur)) block.put(cur, 0);
			block.put(cur, block.get(cur)+1);
		}
		
		ArrayList<Query> ans = new ArrayList<>();
		ArrayList<Query> q = new ArrayList<>();
		
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			String[] split = br.readLine().split("\\s+");
			int l = Integer.parseInt(split[0]);
			int r = Integer.parseInt(split[1]);
			if(l<2) l = 2;
			if(r<2) r = 2;
//			System.out.println(l+" "+r);
			
			int lPrime = primeMap.ceilingKey(l);
			int rPrime = primeMap.floorKey(r);
			
			int lIdx = primeMap.get(lPrime);
			int rIdx = primeMap.get(rPrime)-1;
			
			int lBlock = lIdx/sqrt;
			int rBlock = rIdx/sqrt;
			
			Query cur = new Query(lIdx, rIdx, lBlock, rBlock);
			
			if(lPrime==rPrime) {
				cur.out = "No jumping champion";
			} else if(lIdx==rIdx) {
				cur.out = "The jumping champion is "+diff.get(lIdx);
			} else {
				q.add(cur);
			}
			
			ans.add(cur);
		}
		Collections.sort(q);
//		System.out.println(q);
		
		int prevLeft = -1, prevRight = -1;
		HashMap<Integer, Integer> globalFreq = new HashMap<>();
		TreeMap<Integer, HashSet<Integer>> best = new TreeMap<>();
		for(int k=0; k<q.size(); k++) {
			Query cur = q.get(k);
//			System.out.println("PROCESSING "+cur);
			if(prevLeft!=cur.lBlock) { // left block has moved, reset global lists
				globalFreq = new HashMap<>();
				best = new TreeMap<>();
				for(int i=cur.lBlock+1; i<cur.rBlock; i++) {
					HashMap<Integer, Integer> block = blockFreq[i];
					for(int key : block.keySet()) {
						if(!globalFreq.containsKey(key)) globalFreq.put(key, 0);
						globalFreq.put(key, globalFreq.get(key)+block.get(key));
					}
				}
				for(int key : globalFreq.keySet()) {
					int freq = globalFreq.get(key);
					if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
					best.get(freq).add(key);
				}
			} else if(prevRight!=cur.rBlock) { // left block has not moved, but right block has, must extend global lists
				for(int i=prevRight; i<cur.rBlock; i++) {
					HashMap<Integer, Integer> block = blockFreq[i];
					for(int key : block.keySet()) {
						if(!globalFreq.containsKey(key)) globalFreq.put(key, 0);
						else { // remove old freq
							int freq = globalFreq.get(key);
							if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
							best.get(freq).remove(key);
							if(best.get(freq).isEmpty()) best.remove(freq);
						}
						globalFreq.put(key, globalFreq.get(key)+block.get(key));
						int freq = globalFreq.get(key); // add new freq
						if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
						best.get(freq).add(key);
					}
				}
			}
//			System.out.println("AFTER PREPROCESSING");
//			System.out.println(globalFreq);
			
			// actually solve the query
			// 1. add the individual components of 2 tails
			if(cur.lBlock==cur.rBlock) {
				for(int i=cur.left; i<=cur.right; i++) {
					int key = diff.get(i);
//					System.out.println("ADDING "+key);
					if(!globalFreq.containsKey(key)) globalFreq.put(key, 0);
					else { // remove old freq
						int freq = globalFreq.get(key);
						if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
						best.get(freq).remove(key);
						if(best.get(freq).isEmpty()) best.remove(freq);
					}
					globalFreq.put(key, globalFreq.get(key)+1);
					int freq = globalFreq.get(key); // add new freq
					if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
					best.get(freq).add(key);
				}
			} else {
				for(int i=cur.left; i<sqrt*(cur.lBlock+1); i++) {
					int key = diff.get(i);
//					System.out.println("ADDING "+key);
					if(!globalFreq.containsKey(key)) globalFreq.put(key, 0);
					else { // remove old freq
						int freq = globalFreq.get(key);
						if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
						best.get(freq).remove(key);
						if(best.get(freq).isEmpty()) best.remove(freq);
					}
					globalFreq.put(key, globalFreq.get(key)+1);
					int freq = globalFreq.get(key); // add new freq
					if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
					best.get(freq).add(key);
				}
//				System.out.println("---");
				for(int i=sqrt*cur.rBlock; i<=cur.right; i++) {
					int key = diff.get(i);
//					System.out.println("ADDING "+key);
					if(!globalFreq.containsKey(key)) globalFreq.put(key, 0);
					else { // remove old freq
						int freq = globalFreq.get(key);
						if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
						best.get(freq).remove(key);
						if(best.get(freq).isEmpty()) best.remove(freq);
					}
					globalFreq.put(key, globalFreq.get(key)+1);
					int freq = globalFreq.get(key); // add new freq
					if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
					best.get(freq).add(key);
				}
			}
			
			
			HashSet<Integer> h = best.isEmpty() ? null : best.get(best.lastKey());
//			System.out.println(best);
			if(h==null || h.size()!=1) cur.out = "No jumping champion";
			else {
				String s = h.toString();
				cur.out = "The jumping champion is "+s.substring(1, s.length()-1);
			}
			
			// undo the adds to maintain correctness of global lists
			if(cur.lBlock==cur.rBlock) {
				for(int i=cur.left; i<=cur.right; i++) {
					int key = diff.get(i);
					if(!globalFreq.containsKey(key)) globalFreq.put(key, 0);
					else { // remove old freq
						int freq = globalFreq.get(key);
						if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
						best.get(freq).remove(key);
						if(best.get(freq).isEmpty()) best.remove(freq);
					}
					globalFreq.put(key, globalFreq.get(key)-1);
					int freq = globalFreq.get(key); // add new freq
					if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
					best.get(freq).add(key);
				}
			} else {
				for(int i=cur.left; i<sqrt*(cur.lBlock+1); i++) {
					int key = diff.get(i);
					if(!globalFreq.containsKey(key)) globalFreq.put(key, 0);
					else { // remove old freq
						int freq = globalFreq.get(key);
						if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
						best.get(freq).remove(key);
						if(best.get(freq).isEmpty()) best.remove(freq);
					}
					globalFreq.put(key, globalFreq.get(key)-1);
					int freq = globalFreq.get(key); // add new freq
					if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
					best.get(freq).add(key);
				}
				for(int i=sqrt*cur.rBlock; i<=cur.right; i++) {
					int key = diff.get(i);
					if(!globalFreq.containsKey(key)) globalFreq.put(key, 0);
					else { // remove old freq
						int freq = globalFreq.get(key);
						if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
						best.get(freq).remove(key);
						if(best.get(freq).isEmpty()) best.remove(freq);
					}
					globalFreq.put(key, globalFreq.get(key)+1);
					int freq = globalFreq.get(key); // add new freq
					if(!best.containsKey(freq)) best.put(freq, new HashSet<Integer>());
					best.get(freq).add(key);
				}
			}
//			System.out.println(best);
			
			prevLeft = cur.lBlock;
			prevRight = cur.rBlock;
		}
		
		for(Query cur : ans) sb.append(cur.out).append("\n");
		System.out.print(sb);
	}
	
	static class Query implements Comparable<Query>{
		int left, right, lBlock, rBlock;
		String out;
		
		Query(int a, int b, int c, int d){
			left = a;
			right = b;
			lBlock = c;
			rBlock = d;
		}

		@Override
		public int compareTo(Query o) {
			if(lBlock==o.lBlock) return rBlock-o.rBlock;
			return lBlock-o.lBlock;
		}
		
		public String toString() {
			return "["+left+","+right+"] - ["+lBlock+","+rBlock+"]";
		}
	}
}
